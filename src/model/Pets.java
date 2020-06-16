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
public class Pets {

    private Integer cod_pet;
    private Integer cod_cli;
    private String nome;
    private String porte;
    private String especie;
    private String raca;
    private String sexo;
    private Integer idade;
    private String cor;

    public Integer getcod_pet() {
        return cod_pet;
    }

    public void setcod_pet(Integer cod_pet) {
        this.cod_pet = cod_pet;
    }

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

    public String getporte() {
        return porte;
    }

    public void setporte(String porte) {
        this.porte = porte;
    }

    public String getespecie() {
        return especie;
    }

    public void setespecie(String especie) {
        this.especie = especie;
    }

    public String getraca() {
        return raca;
    }

    public void setraca(String raca) {
        this.raca = raca;
    }

    public String getsexo() {
        return sexo;
    }

    public void setsexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getidade() {
        return idade;
    }

    public void setidade(Integer idade) {
        this.idade = idade;
    }

    public String getcor() {
        return cor;
    }

    public void setcor(String cor) {
        this.cor = cor;
    }

}
