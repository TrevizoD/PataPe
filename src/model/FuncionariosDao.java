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
public class FuncionariosDao {

    public void create(Funcionarios p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            
            String cmd = "INSERT INTO Funcionarios(nome,cpf,rg,data_nacimento,nome_pai,nome_mae," 
                        + "estado_civil,titulo_eleitor,nacionalidade,naturalidade,uf_n,cam,telefone,celular,endereco,cidade,bairro,"
                        + "cep,uf,email,pis_pasep,ctps,uf_c,cargo,data_admissao,remuneracao,horario_trabalho) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            //stmt.setInt(1, p.getcod_func());
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getcpf());
            stmt.setString(3, p.getrg());
            stmt.setString(4, p.getdata_nacimento());
            stmt.setString(5, p.getnome_pai());
            stmt.setString(6, p.getnome_mae());
            stmt.setString(7, p.getestado_civil());
            stmt.setString(8, p.gettitulo_eleitor());
            stmt.setString(9, p.getnacionalidade());
            stmt.setString(10, p.getnaturalidade());
            stmt.setString(11, p.getuf_n());
            stmt.setString(12, p.getcam());
            stmt.setString(13, p.gettelefone());
            stmt.setString(14, p.getcelular());
            stmt.setString(15, p.getendereco());
            stmt.setString(16, p.getcidade());
            stmt.setString(17, p.getbairro());
            stmt.setString(18, p.getcep());
            stmt.setString(19, p.getuf());
            stmt.setString(20, p.getemail());
            stmt.setString(21, p.getpis_pasep());
            stmt.setString(22, p.getctps());
            stmt.setString(23, p.getuf_c());
            stmt.setString(24, p.getcargo());
            stmt.setString(25, p.getdata_admissao());
            stmt.setFloat(26, p.getremuneracao());
            stmt.setInt(27, p.gethorario_trabalho());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*public void create(Funcionarios p) {                                      //NOVO FUNCIONARIOSDAO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "INSERT INTO Funcionarios(cod_func,nome,cpf,rg,data_nacimento,nome_pai,nome_mae," 
                        + "estado_civil,titulo_eleitor,nacionalidade,naturalidade,uf_n,cam,telefone,celular,endereco,cidade,bairro,"
                        + "cep,uf,email,pis_pasep,ctps,uf_c,cargo,data_admissao,remuneracao,horario_trabalho) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_func());
            stmt.setString(2, p.getnome());
            stmt.setString(3, p.getcpf());
            stmt.setString(4, p.getrg());
            stmt.setString(5, p.getdata_nacimento());
            stmt.setString(6, p.getnome_pai());
            stmt.setString(7, p.getnome_mae());
            stmt.setString(8, p.getestado_civil());
            stmt.setString(9, p.gettitulo_eleitor());
            stmt.setString(10, p.getnacionalidade());
            stmt.setString(11, p.getnaturalidade());
            stmt.setString(12, p.getuf_n());
            stmt.setInt(13, p.getcam());
            stmt.setString(14, p.gettelefone());
            stmt.setString(15, p.getcelular());
            stmt.setString(16, p.getendereco());
            stmt.setString(17, p.getcidade());
            stmt.setString(18, p.getbairro());
            stmt.setString(19, p.getcep());
            stmt.setString(20, p.getuf());
            stmt.setString(21, p.getemail());
            stmt.setString(22, p.getpis_pasep());
            stmt.setString(23, p.getctps());
            stmt.setString(24, p.getuf_c());
            stmt.setString(25, p.getcargo());
            stmt.setString(26, p.getdata_admissao());
            stmt.setInt(27, p.getremuneracao());
            stmt.setInt(27, p.gethorario_trabalho());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/

    public void delete(Funcionarios p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Funcionarios where cpf=?;";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setString(1, p.getcpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*public void delete(Funcionarios p) {                                      //NOVO FUNCIONARIOSDAO
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "delete from Funcionarios where cod_func=?;";
            stmt = con.prepareStatement(cmd.toLowerCase());
            stmt.setInt(1, p.getcod_func());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/

    public void update(Funcionarios p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Funcionarios set nome=?,cpf=?,rg=?,data_nacimento=?,nome_pai=?,nome_mae=?,"
                    + "estado_civil=?,titulo_eleitor=?,nacionalidade=?,naturalidade=?,uf_n=?,cam=?,telefone=?,celular=?,endereco=?,cidade=?,bairro=?,"
                    + "cep=?,uf=?,email=?,pis_pasep=?,ctps=?,uf_c=?,cargo=?,data_admissao=?,remuneracao=?,horario_trabalho=? where cpf=?";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getcpf());
            stmt.setString(3, p.getrg());
            stmt.setString(4, p.getdata_nacimento());
            stmt.setString(5, p.getnome_pai());
            stmt.setString(6, p.getnome_mae());
            stmt.setString(7, p.getestado_civil());
            stmt.setString(8, p.gettitulo_eleitor());
            stmt.setString(9, p.getnacionalidade());
            stmt.setString(10, p.getnaturalidade());
            stmt.setString(11, p.getuf_n());
            stmt.setString(12, p.getcam());
            stmt.setString(13, p.gettelefone());
            stmt.setString(14, p.getcelular());
            stmt.setString(15, p.getendereco());
            stmt.setString(16, p.getcidade());
            stmt.setString(17, p.getbairro());
            stmt.setString(18, p.getcep());
            stmt.setString(19, p.getuf());
            stmt.setString(20, p.getemail());
            stmt.setString(21, p.getpis_pasep());
            stmt.setString(22, p.getctps());
            stmt.setString(23, p.getuf_c());
            stmt.setString(24, p.getcargo());
            stmt.setString(25, p.getdata_admissao());
            stmt.setFloat(26, p.getremuneracao());
            stmt.setInt(27, p.gethorario_trabalho());
            stmt.setString(28, p.getcpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*public void update(Funcionarios p) {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String cmd = "update Funcionarios set cod_func=?,nome=?,cpf=?,rg=?,data_nacimento=?,nome_pai=?,nome_mae=?,"
                    + "estado_civil=?,titulo_eleitor=?,nacionalidade=?,naturalidade=?,uf_n=?,cam=?,telefone=?,celular=?,endereco=?,cidade=?,bairro=?"
                    + "cep=?,uf=?,email=?,pis_pasep=?,ctps=?,uf_c=?,cargo=?,data_admissao=?,remuneracao=?,horario_trabalho=? where cod_func=?";
            stmt = con.prepareStatement(cmd.toLowerCase());            
            stmt.setInt(1, p.getcod_func());
            stmt.setString(2, p.getnome());
            stmt.setString(3, p.getcpf());
            stmt.setString(4, p.getrg());
            stmt.setString(5, p.getdata_nacimento());
            stmt.setString(6, p.getnome_pai());
            stmt.setString(7, p.getnome_mae());
            stmt.setString(8, p.getestado_civil());
            stmt.setString(9, p.gettitulo_eleitor());
            stmt.setString(10, p.getnacionalidade());
            stmt.setString(11, p.getnaturalidade());
            stmt.setString(12, p.getuf_n());
            stmt.setInt(13, p.getcam());
            stmt.setString(14, p.gettelefone());
            stmt.setString(15, p.getcelular());
            stmt.setString(16, p.getendereco());
            stmt.setString(17, p.getcidade());
            stmt.setString(18, p.getbairro());
            stmt.setString(19, p.getcep());
            stmt.setString(20, p.getuf());
            stmt.setString(21, p.getemail());
            stmt.setString(22, p.getpis_pasep());
            stmt.setString(23, p.getctps());
            stmt.setString(24, p.getuf_c());
            stmt.setString(25, p.getcargo());
            stmt.setString(26, p.getdata_admissao());
            stmt.setInt(27, p.getremuneracao());
            stmt.setInt(27, p.gethorario_trabalho());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }
    }*/
    
    public Funcionarios getFuncionariosPorCPF(String cpf) {                     //NÃO TEM NO NOVO FUNCIONARIOSDAO
        //cpf = cpf.replace(".", "").replace("-", "");
        Funcionarios Funcionario = null;
        try {
            Connection conn = connectionFactory.getConnection();
            String query = "select * from Funcionarios where cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(query.toLowerCase());

            stmt.setString(1, cpf);
             System.out.println(stmt);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario  = new Funcionarios();
                Funcionario.setnome(rs.getString("nome"));
                Funcionario.setrg(rs.getString("rg"));
                Funcionario.setdata_nascimento(rs.getString("data_nacimento"));
                Funcionario.setnome_pai(rs.getString("nome_pai"));
                Funcionario.setnome_mae(rs.getString("nome_mae"));
                Funcionario.setestado_civil(rs.getString("estado_civil"));
                Funcionario.settitulo_eleitor(rs.getString("titulo_eleitor"));
                Funcionario.setnacionalidade(rs.getString("nacionalidade"));
                Funcionario.setnaturalidade(rs.getString("naturalidade"));
                Funcionario.setuf_n(rs.getString("uf_n"));
                Funcionario.setcam(rs.getString("cam"));
                Funcionario.settelefone(rs.getString("telefone"));
                Funcionario.setcelular(rs.getString("celular"));
                Funcionario.setendereco(rs.getString("endereco"));
                Funcionario.setcidade(rs.getString("cidade"));
                Funcionario.setbairro(rs.getString("bairro"));
                Funcionario.setcep(rs.getString("cep"));
                Funcionario.setuf(rs.getString("uf"));
                Funcionario.setemail(rs.getString("email"));
                Funcionario.setpis_pasep(rs.getString("pis_pasep"));
                Funcionario.setctps(rs.getString("ctps"));
                Funcionario.setuf_c(rs.getString("uf_c"));
                Funcionario.setcargo(rs.getString("cargo"));
                Funcionario.setdata_admissao(rs.getString("data_admissao"));
                Funcionario.setremuneracao(rs.getFloat("remuneracao"));
                Funcionario.sethorario_trabalho(rs.getInt("horario_trabalho"));
                Funcionario.setuf(rs.getString("uf"));
                Funcionario.setemail(rs.getString("email"));              
            }

            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente: " + e.getMessage());
        }

        return Funcionario;
    }
    
    public ArrayList<Funcionarios> getContatos(String nome) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Funcionarios where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setcod_func(rs.getInt("cod_func"));
                funcionario.setnome(rs.getString("nome"));
                funcionario.setcpf(rs.getString("cpf"));
                funcionario.setrg(rs.getString("rg"));
                funcionario.setdata_nascimento(rs.getString("data_nacimento"));
                funcionario.setnome_pai(rs.getString("nome_pai"));
                funcionario.setnome_mae(rs.getString("nome_mae"));
                funcionario.setestado_civil(rs.getString("estado_civil"));
                funcionario.settitulo_eleitor(rs.getString("titulo_eleitor"));
                funcionario.setnacionalidade(rs.getString("nacionalidade"));
                funcionario.setnaturalidade(rs.getString("naturalidade"));
                funcionario.setuf_n(rs.getString("uf_n"));
                funcionario.setcam(rs.getString("cam"));
                funcionario.settelefone(rs.getString("telefone"));
                funcionario.setcelular(rs.getString("celular"));
                funcionario.setendereco(rs.getString("endereco"));
                funcionario.setcidade(rs.getString("cidade"));                
                funcionario.setbairro(rs.getString("bairro"));
                funcionario.setcep(rs.getString("cep"));
                funcionario.setuf(rs.getString("uf"));
                funcionario.setemail(rs.getString("email"));
                funcionario.setpis_pasep(rs.getString("pis_pasep"));
                funcionario.setctps(rs.getString("ctps"));
                funcionario.setuf_c(rs.getString("uf_c"));
                funcionario.setcargo(rs.getString("cargo"));
                funcionario.setdata_admissao(rs.getString("data_admissao"));
                funcionario.setremuneracao(rs.getFloat("remuneracao"));
                funcionario.sethorario_trabalho(rs.getInt("horario_trabalho"));
                funcionarios.add(funcionario);
            }
            
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return funcionarios;
    }
    
    /*public ArrayList<Funcionarios> getContatos(String nome) {                 //NOVO FUNCIONARIOSDAO
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Funcionarios where nome like ?".toLowerCase());
            stmt.setString(1, '%' + nome + '%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setcod_func(rs.getInt("cod_func"));
                funcionario.setnome(rs.getString("nome"));
                funcionario.setcpf(rs.getString("cpf"));
                funcionario.setrg(rs.getString("rg"));
                funcionario.setdata_nascimento(rs.getString("data_nacimento"));
                funcionario.setnome_pai(rs.getString("nome_pai"));
                funcionario.setnome_mae(rs.getString("nome_mae"));
                funcionario.setestado_civil(rs.getString("estado_civil"));
                funcionario.settitulo_eleitor(rs.getString("titulo_eleitor"));
                funcionario.setnacionalidade(rs.getString("nacionalidade"));
                funcionario.setnaturalidade(rs.getString("naturalidade"));
                funcionario.setuf_n(rs.getString("uf_n"));
                funcionario.setcam(rs.getInt("cam"));
                funcionario.settelefone(rs.getString("telefone"));
                funcionario.setcelular(rs.getString("celular"));
                funcionario.setendereco(rs.getString("endereco"));
                funcionario.setcidade(rs.getString("cidade"));                
                funcionario.setbairro(rs.getString("bairro"));
                funcionario.setcep(rs.getString("cep"));
                funcionario.setuf(rs.getString("uf"));
                funcionario.setemail(rs.getString("email"));
                funcionario.setpis_pasep(rs.getString("pis_pasep"));
                funcionario.setctps(rs.getString("ctps"));
                funcionario.setuf_c(rs.getString("uf_c"));
                funcionario.setcargo(rs.getString("cargo"));
                funcionario.setdata_admissao(rs.getString("data_admissao"));
                funcionario.setremuneracao(rs.getInt("remuneracao"));
                funcionario.sethorario_trabalho(rs.getInt("horario_trabalho"));
                funcionarios.add(funcionario);
            }
            
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return funcionarios;
    }*/
    
    public ArrayList<Funcionarios> all() {                                      //ADD PELO NOVO FUNCIONARIOSDAO
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from Funcionarios order by nome".toLowerCase());
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setcod_func(rs.getInt("cod_func"));
                funcionario.setnome(rs.getString("nome"));
                funcionario.setcpf(rs.getString("cpf"));
                funcionario.setrg(rs.getString("rg"));
                funcionario.setdata_nascimento(rs.getString("data_nacimento"));
                funcionario.setnome_pai(rs.getString("nome_pai"));
                funcionario.setnome_mae(rs.getString("nome_mae"));
                funcionario.setestado_civil(rs.getString("estado_civil"));
                funcionario.settitulo_eleitor(rs.getString("titulo_eleitor"));
                funcionario.setnacionalidade(rs.getString("nacionalidade"));
                funcionario.setnaturalidade(rs.getString("naturalidade"));
                funcionario.setuf_n(rs.getString("uf_n"));
                funcionario.setcam(rs.getString("cam"));                           //NO NOVO: INT
                funcionario.settelefone(rs.getString("telefone"));
                funcionario.setcelular(rs.getString("celular"));
                funcionario.setendereco(rs.getString("endereco"));
                funcionario.setcidade(rs.getString("cidade"));                
                funcionario.setbairro(rs.getString("bairro"));
                funcionario.setcep(rs.getString("cep"));
                funcionario.setuf(rs.getString("uf"));
                funcionario.setemail(rs.getString("email"));
                funcionario.setpis_pasep(rs.getString("pis_pasep"));
                funcionario.setctps(rs.getString("ctps"));
                funcionario.setuf_c(rs.getString("uf_c"));
                funcionario.setcargo(rs.getString("cargo"));
                funcionario.setdata_admissao(rs.getString("data_admissao"));
                funcionario.setremuneracao(rs.getFloat("remuneracao"));           //NO NOVO: INT
                funcionario.sethorario_trabalho(rs.getInt("horario_trabalho"));
                funcionarios.add(funcionario);
            }
            
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return funcionarios;
    }

}
