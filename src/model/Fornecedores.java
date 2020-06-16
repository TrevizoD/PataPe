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
public class Fornecedores {

    private Integer cod_for;
    private String nome;
    private String data_cadastro;
    private String cpf_cnpj;
    private String tipo;
    private String telefone;
    private String celular;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String uf;
    private String email;

    public Integer getcod_for() {
        return cod_for;
    }

    public void setcod_for(Integer cod_for) {
        this.cod_for = cod_for;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getdata_cadastro() {
        return data_cadastro.replace("-", "/");
    }

    public void setdata_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getcpf_cnpj() {
        return cpf_cnpj;
    }

    public void setcpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }
        public String gettelefone() {
        return telefone;
    }
    
    public void settelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getcelular() {
        return celular;
    }
    
    public void setcelular(String celular) {
        this.celular = celular;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public String getcidade() {
        return cidade;
    }

    public void setcidade(String cidade) {
        this.cidade = cidade;
    }

    public String getbairro() {
        return bairro;
    }

    public void setbairro(String bairro) {
        this.bairro = bairro;
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

}
