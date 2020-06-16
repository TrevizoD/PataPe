package model;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedoresDao {

    public void create(Fornecedores p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Fornecedores(nome,data_cadastro,cpf_cnpj,tipo,telefone,celular,endereco,cidade,bairro,cep,uf,email) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getdata_cadastro());
            stmt.setString(3, p.getcpf_cnpj());
            stmt.setString(4, p.gettipo());
            stmt.setString(5, p.gettelefone());
            stmt.setString(6, p.getcelular());
            stmt.setString(7, p.getendereco());
            stmt.setString(8, p.getcidade());
            stmt.setString(9, p.getbairro());
            stmt.setString(10, p.getcep());
            stmt.setString(11, p.getuf());
            stmt.setString(12, p.getemail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Fornecedores p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Fornecedores where cpf_cnpj=?";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setString(1, p.getcpf_cnpj());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossível excluir fornecedor. "
                    + "Há produtos cadastrados neste nome no sistema.");
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Fornecedores p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Fornecedores set nome=?,data_cadastro=?,cpf_cnpj=?,tipo=?,telefone=?,celular=?,endereco=?,cidade=?,bairro=?,cep=?,uf=?,email=? where cpf_cnpj=?";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getdata_cadastro());
            stmt.setString(3, p.getcpf_cnpj());
            stmt.setString(4, p.gettipo());
            stmt.setString(5, p.gettelefone());
            stmt.setString(6, p.getcelular());
            stmt.setString(7, p.getendereco());
            stmt.setString(8, p.getcidade());
            stmt.setString(9, p.getbairro());
            stmt.setString(10, p.getcep());
            stmt.setString(11, p.getuf());
            stmt.setString(12, p.getemail());
            stmt.setString(13, p.getcpf_cnpj());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Fornecedores> getContatos(String nome){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedores> fornecedores = new ArrayList<Fornecedores>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Fornecedores where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores(); 
                fornecedor.setcod_for(rs.getInt("cod_for"));
                fornecedor.setnome(rs.getString("nome"));
                fornecedor.setcpf_cnpj(rs.getString("cpf_cnpj"));
                fornecedor.setdata_cadastro(rs.getString("data_cadastro"));
                fornecedor.settipo(rs.getString("tipo"));
                fornecedor.setuf(rs.getString("uf"));
                fornecedor.setcidade(rs.getString("cidade"));
                fornecedor.setendereco(rs.getString("endereco"));
                fornecedor.setcep(rs.getString("cep"));
                fornecedor.setbairro(rs.getString("bairro"));                
                fornecedor.settelefone(rs.getString("telefone"));
                fornecedor.setcelular(rs.getString("celular"));
                fornecedores.add(fornecedor);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return fornecedores;
    }
    
    public Fornecedores getFornecedorPorID(int id){
        Fornecedores fornecedor = null;        
        try {
            Connection conn = connectionFactory.getConnection();
            
            String query = "select * from Fornecedores where cod_for = ?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedor = new Fornecedores();
                fornecedor.setcod_for(rs.getInt("cod_for"));
                fornecedor.setnome(rs.getString("nome"));
                fornecedor.setcpf_cnpj(rs.getString("cpf_cnpj"));
                fornecedor.setdata_cadastro(rs.getString("data_cadastro"));
                fornecedor.settipo(rs.getString("tipo"));
                fornecedor.setuf(rs.getString("uf"));
                fornecedor.setcidade(rs.getString("cidade"));
                fornecedor.setendereco(rs.getString("endereco"));
                fornecedor.setcep(rs.getString("cep"));
                fornecedor.setbairro(rs.getString("bairro"));                
                fornecedor.settelefone(rs.getString("telefone"));
                fornecedor.setcelular(rs.getString("celular"));
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return fornecedor;
    }

}
