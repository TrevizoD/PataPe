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
public class Servicos {
    private Integer cod_serv;
    private Integer cod_fun;
    private String nome;
    private String descricao;
    
       public Integer getcod_serv () {
        return cod_serv;
    }

    public void setcod_serv(Integer cod_serv) {
        this.cod_serv=cod_serv ;
    }

       public Integer getcod_fun () {
        return cod_fun;
    }

    public void setcod_fun(Integer cod_fun) {
        this.cod_fun=cod_fun ;
    }

       public String getnome () {
        return nome;
    }

    public void setnome(String nome) {
        this.nome=nome ;
    }

       public String getdescricao () {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao=descricao ;
    }

}
