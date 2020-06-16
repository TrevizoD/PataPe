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
public class Produtos {

    private Integer cod_prod;
    private Integer cod_for;
    private Integer quantidade;
    private Float valor;                                                        //ERA INT
    private String nome;
    private String descricao;
    private String data_validade;
    private String categoria;

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getcod_prod() {
        return cod_prod;
    }

    public void setcod_prod(Integer cod_prod) {
        this.cod_prod = cod_prod;
    }

    public Integer getcod_for() {
        return cod_for;
    }

    public void setcod_for(Integer cod_for) {
        this.cod_for = cod_for;
    }

    public String getdata_validade() {
        return data_validade.replace("-", "/");
    }

    public void setdata_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public String getcategoria() {
        return categoria;
    }

    public void setcategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getquantidade() {
        return quantidade;
    }

    public void setquantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getvalor() {                                                   //ERA INT
        return valor;
    }

    public void setvalor(Float valor) {                                         //ERA INT
        this.valor = valor;
    }

}
