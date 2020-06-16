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
public class Servicos_precos {

    private Integer cod_preco;
    private Integer cod_serv;
    private String porte;
    private String tempo;
    private double valor;

    public Integer getcod_preco() {
        return cod_preco;
    }

    public void setcod_preco(Integer cod_preco) {
        this.cod_preco = cod_preco;
    }

    public Integer getcod_serv() {
        return cod_serv;
    }

    public void setcod_serv(Integer cod_serv) {
        this.cod_serv = cod_serv;
    }

    public String getporte() {
        return porte;
    }

    public void setporte(String porte) {
        this.porte = porte;
    }

    public String gettempo() {
        return tempo;
    }

    public void settempo(String tempo) {
        this.tempo = tempo;
    }

    public double getvalor() {
        return valor;
    }

    public void setvalor(double valor) {
        this.valor = valor;
    }

}
