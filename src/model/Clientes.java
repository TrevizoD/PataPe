/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author crisdut
 */
public class Clientes {

    private Integer cod_cli;
    private String nome;
    private String data_nascimento;
    private String cpf;
    private String telefone;
    private String celular;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String uf;
    private String email;

    public Integer getcod_cli() {
        return cod_cli;
    }

    public void setcod_cli(Integer cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getnome() {
        return nome;
    }
    
    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getdata_nascimento() {
        return data_nascimento.replace("-", "/");
    }

    public void setdata_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
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
        this.cep = cep;
    }

    public String getuf() {
        return uf;
    }

    public void setuf(String uf) {
        this.uf = uf;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

}
