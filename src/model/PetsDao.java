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
 * @author blackNite
 */
public class PetsDao {

    public void create(Pets p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Pets(nome,porte,especie,raca,idade,cor, sexo, cod_cli) values (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getporte());
            stmt.setString(3, p.getespecie());
            stmt.setString(4, p.getraca());
            stmt.setInt(5, p.getidade());
            stmt.setString(6, p.getcor());
            stmt.setString(7, p.getsexo());
            stmt.setInt(8, p.getcod_cli());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Pets p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Pets where cod_pet=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_pet());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exclusão impedida: o pet possui agendamento cadastrado.");
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    /*public void update(Pets p) {                                              //ANTIGO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Pets set cod_cli=?,cod_pet=?,nome=?,porte=?,especie=?,raca=?,sexo=?,idade=?,cor=? where cod_pet=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_cli());
            stmt.setInt(2, p.getcod_pet());
            stmt.setString(3, p.getnome());
            stmt.setString(4, p.getporte());
            stmt.setString(5, p.getespecie());
            stmt.setString(6, p.getraca());
            stmt.setString(7, p.getsexo());
            stmt.setInt(8, p.getidade());
            stmt.setString(9, p.getcor());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }        
    }*/
    
    public void update(Pets p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Pets set cod_cli=?,cod_pet=?,nome=?,porte=?,especie=?,raca=?,sexo=?,idade=?,cor=? where cod_pet=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_cli());
            stmt.setInt(2, p.getcod_pet());
            stmt.setString(3, p.getnome());
            stmt.setString(4, p.getporte());
            stmt.setString(5, p.getespecie());
            stmt.setString(6, p.getraca());
            stmt.setString(7, p.getsexo());
            stmt.setInt(8, p.getidade());
            stmt.setString(9, p.getcor());
            stmt.setInt(10, p.getcod_pet());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Pets getPorNomeEDono(String nome, int codCli) {
        Pets pet = null;
        try {
            Connection conn = connectionFactory.getConnection();
            String query = "select * from pets where nome = ? and cod_cli=?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setString(1, nome);
            stmt.setInt(2, codCli);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pet = new Pets();
                pet.setcod_pet(rs.getInt("cod_pet"));
                pet.setnome(rs.getString("nome"));
                pet.setporte(rs.getString("porte"));
                
                break;
            }

            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar pets: " + e.getMessage());
        }

        return pet;
    }
    
    public Pets getPetPorID(int id){
        Pets pet = null;        
        try {
            Connection conn = connectionFactory.getConnection();
            
            String query = "select * from Pets where cod_pet = ?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pet = new Pets();
                pet.setcod_pet(rs.getInt("cod_pet"));
                pet.setnome(rs.getString("nome"));
                pet.setespecie(rs.getString("especie"));
                pet.setraca(rs.getString("raca"));
                pet.setporte(rs.getString("porte"));
                pet.setsexo(rs.getString("sexo"));
                pet.setcor(rs.getString("cor"));
                pet.setidade(rs.getInt("idade"));
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return pet;
    }
    
    public ArrayList<Pets> getContatosPets(String nome) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Pets> pets = new ArrayList<Pets>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from pets where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pets pet = new Pets();
                pet.setcod_cli(rs.getInt("cod_cli"));
                pet.setcod_pet(rs.getInt("cod_pet"));
                pet.setnome(rs.getString("nome"));
                pet.setporte(rs.getString("porte"));
                pet.setespecie(rs.getString("especie"));
                pet.setraca(rs.getString("raca"));
                pet.setsexo(rs.getString("sexo"));
                pet.setidade(rs.getInt("idade"));
                pet.setcor(rs.getString("cor"));
                pets.add(pet);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return pets;
    }

}
