/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author blackNite
 */
public class Funcionarios {

    private Integer cod_func;
    private String nome;
    private String cpf;
    private String rg;
    private String data_nacimento;
    private String nome_pai;
    private String nome_mae;
    private String estado_civil;
    private String titulo_eleitor;
    private String nacionalidade;
    private String naturalidade;
    private String uf_n;
    //private Integer cam;                                                      //NOVO FUNCIONARIOS                
    private String cam;
    private String telefone;
    private String celular;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String uf;
    private String email;
    private String pis_pasep;
    private String ctps;
    private String uf_c;
    private String cargo;
    private String data_admissao;
    //private Integer remuneracao;                                              //NOVO FUNCIONARIOS
    private Float remuneracao;
    private Integer horario_trabalho;

    public Integer getcod_func() {
        return cod_func;
    }

    public void setcod_func(Integer cod_func) {
        this.cod_func=cod_func;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome=nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf=cpf;
    }

    public String getrg() {
        return rg;
    }

    public void setrg(String rg) {
        this.rg=rg;
    }
    
    /*public String getdata_nacimento() {
        return data_nacimento.replace("-", "/");                                //NOVO FUNCIONARIOS
    }*/

    public String getdata_nacimento() {
        return data_nacimento.replace("-", "/");
    }

    public void setdata_nascimento(String data_nascimento) {
        this.data_nacimento=data_nascimento;
    }

    public String getnome_pai() {
        return nome_pai;
    }

    public void setnome_pai(String nome_pai) {
        this.nome_pai=nome_pai;
    }

    public String getnome_mae() {
        return nome_mae;
    }

    public void setnome_mae(String nome_mae) {
        this.nome_mae=nome_mae;
    }

    public String getestado_civil() {
        return estado_civil;
    }

    public void setestado_civil(String estado_civil) {
        this.estado_civil=estado_civil;
    }

    public String gettitulo_eleitor() {
        return titulo_eleitor;
    }

    public void settitulo_eleitor(String titulo_eleitor) {
        this.titulo_eleitor=titulo_eleitor;
    }

    public String getnacionalidade() {
        return nacionalidade;
    }

    public void setnacionalidade(String nacionalidade) {
        this.nacionalidade=nacionalidade;
    }

    public String getnaturalidade() {
        return naturalidade;
    }

    public void setnaturalidade(String naturalidade) {
        this.naturalidade=naturalidade;
    }

    public String getuf_n() {
        return uf_n;
    }

    public void setuf_n(String uf_n) {
        this.uf_n=uf_n;
    }

    /*public Integer getcam() {                                                 //NOVO FUNCIONARIOS
        return cam;
    }

    public void setcam(Integer cam) {
        this.cam=cam;
    }*/
    
    public String getcam() {
        return cam;
    }

    public void setcam(String cam) {
        this.cam=cam;
    }

    public String gettelefone() {
        return telefone;
    }

    public void settelefone(String telefone) {
        this.telefone=telefone;
    }

    public String getcelular() {
        return celular;
    }

    public void setcelular(String celular) {
        this.celular=celular;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco=endereco;
    }

    public String getcidade() {
        return cidade;
    }

    public void setcidade(String cidade) {
        this.cidade=cidade;
    }

    public String getbairro() {
        return bairro;
    }

    public void setbairro(String bairro) {
        this.bairro=bairro;
    }

    public String getcep() {
        return cep;
    }

    public void setcep(String cep) {
        this.cep=cep;
    }

    public String getuf() {
        return uf;
    }

    public void setuf(String uf) {
        this.uf=uf;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email=email;
    }

    public String getpis_pasep() {
        return pis_pasep;
    }

    public void setpis_pasep(String pis_pasep) {
        this.pis_pasep=pis_pasep;
    }

    public String getctps() {
        return ctps;
    }

    public void setctps(String ctps) {
        this.ctps=ctps;
    }

    public String getuf_c() {
        return uf_c;
    }

    public void setuf_c(String uf_c) {
        this.uf_c=uf_c;
    }

    public String getcargo() {
        return cargo;
    }

    public void setcargo(String cargo) {
        this.cargo=cargo;
    }

    /*public String getdata_admissao() {                                        //NOVO FUNCIONARIOS
        return data_admissao;
    }*/
    
    public String getdata_admissao() {
        return data_admissao.replace("-", "/");
    }

    public void setdata_admissao(String data_admissao) {
        this.data_admissao=data_admissao;
    }

    /*public Integer getremuneracao() {                                         //NOVO FUNCIONARIOS
        return remuneracao;
    }

    public void setremuneracao(Integer remuneracao) {
        this.remuneracao=remuneracao;
    }*/
    
    public Float getremuneracao() {
        return remuneracao;
    }

    public void setremuneracao(Float remuneracao) {
        this.remuneracao=remuneracao;
    }

    public Integer gethorario_trabalho() {
        return horario_trabalho;
    }

    public void sethorario_trabalho(Integer horario_trabalho) {
        this.horario_trabalho=horario_trabalho;
    }

}
