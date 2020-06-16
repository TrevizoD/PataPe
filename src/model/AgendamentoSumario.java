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
public class AgendamentoSumario {

    private Integer cod_age;
    private String data;
    private String cliente;
    private String cpf;
    private String pet;
    private String porte;
    private String servico;
    private String hora;            //ADD
    private String status_agend;    //ADD

    public Integer getcod_age() {
        return cod_age;
    }

    public void setcod_age(Integer cod_age) {
        this.cod_age = cod_age;
    }

    public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }

    public String getcliente() {
        return cliente;
    }

    public void setcliente(String cliente) {
        this.cliente = cliente;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getpet() {
        return pet;
    }

    public void setpet(String pet) {
        this.pet = pet;
    }

    public String getporte() {
        return porte;
    }

    public void setporte(String porte) {
        this.porte = porte;
    }

    public String getservico() {
        return servico;
    }

    public void setservico(String servico) {
        this.servico = servico;
    }
    
    public String gethora() {   //ADD
        return hora;
    }

    public void sethora(String hora) {  //ADD
        this.hora = hora;
    }
    
    public String getstatus_agend() {   //ADD
        return status_agend;
    }

    public void setstatus_agend(String status_agend) {  //ADD
        this.status_agend = status_agend;
    }

}
