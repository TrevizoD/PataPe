/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;                                                      //ADD PELO NOVO SERVICOSDAO

/**
 *
 * @author blackNite
 */
public class ServicosDao {

    public void create(Servicos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Servicos(cod_serv,cod_fun,nome,descricao) values (?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_serv());
            stmt.setInt(2, p.getcod_fun());
            stmt.setString(3, p.getnome());
            stmt.setString(4, p.getdescricao());

            stmt.executeUpdate();                                               
            JOptionPane.showMessageDialog(null, "Inserido com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*public void create(Servicos p) {                                          //NOVO SERVICOSDAO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Servicos(cod_serv,cod_func,nome,descricao) values (?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_serv());
            stmt.setInt(2, p.getcod_fun());
            stmt.setString(3, p.getnome());
            stmt.setString(4, p.getdescricao());

            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/                                                                         

    public void delete(Servicos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Servicos where cod_serv=?;";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setInt(1, p.getcod_serv());
       
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Servicos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Servicos set cod_serv=?,cod_fun=?,nome=?,descricao=? where cod_serv=? ";
            stmt = con.prepareStatement(cmd.toLowerCase());                 
            stmt.setInt(1, p.getcod_serv());
            stmt.setInt(2, p.getcod_fun());
            stmt.setString(3, p.getnome());
            stmt.setString(4, p.getdescricao());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void updateAtualizacao(Servicos p) {                                          //NOVO SERVICOSDAO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Servicos set cod_func=?,nome=?,descricao=? where cod_serv=? ";
            stmt = con.prepareStatement(cmd.toLowerCase());                 
            stmt.setInt(1, p.getcod_fun());
            stmt.setString(2, p.getnome());
            stmt.setString(3, p.getdescricao());
            stmt.setInt(4, p.getcod_serv());

            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Servicos getPorNome(String nome){                                    //ADD PELO NOVO SERVICOSDAO
        Servicos serv = null;
        try {
            Connection conn = connectionFactory.getConnection();
            
            String query = "select * from servicos where nome=?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                serv = new Servicos();
                serv.setcod_serv(rs.getInt("cod_serv"));
                serv.setcod_fun(rs.getInt("cod_func"));                          //COD_FUN?
                serv.setdescricao(rs.getString("descricao"));
                serv.setnome(rs.getString("nome"));                
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar serviço" + e.getMessage());
        }
        return serv;
    }

}
