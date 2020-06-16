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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author crisdut
 */
public class ClientesDao {

    public void create(Clientes p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Clientes(nome,data_nascimento,cpf,telefone,celular,endereco,cidade,bairro,cep,uf,email) values (?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());

            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getdata_nascimento());
            stmt.setString(3, p.getcpf());
            stmt.setString(4, p.gettelefone());
            stmt.setString(5, p.getcelular());
            stmt.setString(6, p.getendereco());
            stmt.setString(7, p.getcidade());
            stmt.setString(8, p.getbairro());
            stmt.setString(9, p.getcep());
            stmt.setString(10, p.getuf());
            stmt.setString(11, p.getemail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Clientes p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Clientes where cpf=?";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setString(1, p.getcpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Clientes p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Clientes set nome=?,data_nascimento=?,cpf=?,telefone=?,celular=?,endereco=?,cidade=?,bairro=?,cep=?,uf=?,email=? where cpf=?";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getdata_nascimento());
            stmt.setString(3, p.getcpf());
            stmt.setString(4, p.gettelefone());
            stmt.setString(5, p.getcelular());
            stmt.setString(6, p.getendereco());
            stmt.setString(7, p.getcidade());
            stmt.setString(8, p.getbairro());
            stmt.setString(9, p.getcep());
            stmt.setString(10, p.getuf());
            stmt.setString(11, p.getemail());
            stmt.setString(12, p.getcpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Corrigir
    public Clientes getClientePorCPF(String cpf) {
        //cpf = cpf.replace(".", "").replace("-", "");
        Clientes cliente = null;
        //Clientes cliente = new Clientes();
        try {
            Connection conn = connectionFactory.getConnection();
            String query = "select * from clientes where cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setString(1, cpf);
            System.out.println(stmt);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente = new Clientes();
                cliente.setcod_cli(rs.getInt("cod_cli"));
                cliente.setnome(rs.getString("nome"));
                //cliente.setcpf(rs.getString("cpf"));
                cliente.setdata_nascimento(rs.getString("data_nascimento"));
                cliente.settelefone(rs.getString("telefone"));
                cliente.setcelular(rs.getString("celular"));
                cliente.setendereco(rs.getString("endereco"));
                cliente.setcep(rs.getString("cep"));
                cliente.setbairro(rs.getString("bairro"));
                cliente.setemail(rs.getString("email"));
                //break;
            }

            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente: " + e.getMessage());
        }

        return cliente;
    }

    public ArrayList<Clientes> getContatos(String nome) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Clientes where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setcod_cli(rs.getInt("cod_cli"));
                cliente.setnome(rs.getString("nome"));
                cliente.setcpf(rs.getString("cpf"));
                cliente.setdata_nascimento(rs.getString("data_nascimento"));
                cliente.settelefone(rs.getString("telefone"));
                cliente.setcelular(rs.getString("celular"));
                cliente.setendereco(rs.getString("endereco"));
                cliente.setcep(rs.getString("cep"));
                cliente.setbairro(rs.getString("bairro"));
                cliente.setemail(rs.getString("email"));
                clientes.add(cliente);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return clientes;
    }      

}
