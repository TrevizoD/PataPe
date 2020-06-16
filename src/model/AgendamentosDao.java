/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author blackNite
 */
public class AgendamentosDao {

    public void create(Agendamentos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Agendamentos(cod_pet,data_agendada,hora_agendada,status_agend) values (?,?,?,?)";  //ADD STATUS
            stmt = con.prepareStatement(cmd.toLowerCase(), Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getcod_pet());
            stmt.setString(2, p.getdata_agendada());
            stmt.setString(3, p.gethora_agendada());    //ADD
            stmt.setString(4, p.getstatus_agend());    //ADD
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int last_inserted_id = rs.getInt(1);
                p.setcod_age(last_inserted_id);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Agendamentos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Agendamentos where cod_age=?";    //ADD
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_age()); //ADD

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    /*public void update(Agendamentos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Agendamentos set cod_age=?,cod_pet=?,data_agendada=? where cod_pet=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_age());
            stmt.setInt(2, p.getcod_pet());
            stmt.setString(3, p.getdata_agendada());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/
    
    public ArrayList<AgendamentoSumario> getAgendamento() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<AgendamentoSumario> agendamentos = new ArrayList<AgendamentoSumario>();
        try {
            conn = connectionFactory.getConnection();
            String cmd = 
            "select  ag.cod_age," +
            "        ag.data_agendada," +
            "        ag.hora_agendada," +   //ADD
            "        ag.status_agend," +   //ADD
            "        c.nome as cliente," +
            "        c.cpf," +
            "        p.nome as pet," +
            "        p.porte," +
            "        GROUP_CONCAT(s.nome SEPARATOR ', ') as servico" +
            " from agendamentos as ag" +
            "	inner join agendamento_servicos as ags" +
            "		on (ag.cod_age = ags.cod_age)" +
            "	inner join servicos s" +
            "		on (ags.cod_serv = s.cod_serv)" +
            "	inner join pets p" +
            "		on (ag.cod_pet = p.cod_pet)" +
            "	inner join clientes c" +
            "		on (p.cod_cli = c.cod_cli)" +
            " group by ag.cod_age," +
            "		ag.data_agendada," +
            "		ag.hora_agendada," +    //ADD
            "		ag.status_agend," +    //ADD
            "		c.nome," +
            "           c.cpf," +
            "           p.nome," +
            "           p.porte";
            
            
            stmt = conn.prepareStatement(cmd.toLowerCase());
            rs = stmt.executeQuery();

            while (rs.next()) {
                AgendamentoSumario age = new AgendamentoSumario();
                age.setcod_age(rs.getInt("cod_age"));
                age.setdata(rs.getString("data_agendada"));
                age.sethora(rs.getString("hora_agendada")); //ADD
                age.setstatus_agend(rs.getString("status_agend")); //ADD
                age.setcliente(rs.getString("cliente"));
                age.setcpf(rs.getString("cpf"));
                age.setpet(rs.getString("pet"));
                age.setporte(rs.getString("porte"));
                age.setservico(rs.getString("servico"));                

                agendamentos.add(age);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return agendamentos;
    }

}
