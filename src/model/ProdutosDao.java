/*
 * INTS de valor alterados para FLOAT
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
public class ProdutosDao {

    /*public void create(Produtos p) {                                          //ANTIGO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Produtos(nome,descricao,data_validade,categoria,quantidade,valor,cod_for) values ('TapeteHigienico','tapetesparapets','2021-04-14','v',20,40,2)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            
            stmt.setString(1, p.getnome());
            stmt.setInt(2, p.getcod_prod());
            stmt.setInt(3, p.getcod_for());
            stmt.setString(4, p.getdescricao());
            stmt.setString(5, p.getdata_validade());
            stmt.setString(6, p.getcategoria());
            stmt.setInt(7, p.getquantidade());
            stmt.setFloat(8, p.getvalor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/
    
    public void create(Produtos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Produtos(nome,descricao,data_validade,categoria,quantidade,valor,cod_for) values (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());

            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getdescricao());
            stmt.setString(3, p.getdata_validade());
            stmt.setString(4, p.getcategoria());
            stmt.setInt(5, p.getquantidade());
            stmt.setFloat(6, p.getvalor());
            stmt.setInt(7, p.getcod_for());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Produtos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Produtos where cod_prod=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_prod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Produtos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Produtos set nome=?, cod_prod=?, cod_for=?, descricao=?, data_validade=?, "
                    + "categoria=? ,quantidade=?, valor = ? where cod_prod=?;";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setString(1, p.getnome());
            stmt.setInt(2, p.getcod_prod());
            stmt.setInt(3, p.getcod_for());
            stmt.setString(4, p.getdescricao());
            stmt.setString(5, p.getdata_validade());
            stmt.setString(6, p.getcategoria());
            stmt.setInt(7, p.getquantidade());
            stmt.setFloat(8, p.getvalor());
            stmt.setInt(9, p.getcod_prod());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
        
    public void updateEstoque(Produtos p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Produtos set quantidade=? where cod_prod=?;";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getquantidade());
            stmt.setInt(2, p.getcod_prod());
            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produtos> getContatos(String nome){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Produtos where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos(); 
                produto.setcod_prod(rs.getInt("cod_prod"));
                produto.setcod_for(rs.getInt("cod_for"));
                produto.setnome(rs.getString("nome"));
                produto.setdescricao(rs.getString("descricao"));
                produto.setdata_validade(rs.getString("data_validade"));
                produto.setcategoria(rs.getString("categoria"));
                produto.setvalor(rs.getFloat("valor"));
                produto.setquantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return produtos;
    }
        
    public Produtos getProdutoPorID(int id){
        Produtos produto = null;        
        try {
            Connection conn = connectionFactory.getConnection();
            
            String query = "select * from Produtos where cod_prod = ?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produtos();
                produto.setcod_prod(rs.getInt("cod_prod"));
                produto.setcod_for(rs.getInt("cod_for"));
                produto.setnome(rs.getString("nome"));
                produto.setdescricao(rs.getString("descricao"));
                produto.setdata_validade(rs.getString("data_validade"));
                produto.setcategoria(rs.getString("categoria"));
                produto.setvalor(rs.getFloat("valor"));
                produto.setquantidade(rs.getInt("quantidade"));
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return produto;
    }

}


