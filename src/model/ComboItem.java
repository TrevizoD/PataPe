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
public class ComboItem {
    public int Chave;
    public String Valor;
    
    public ComboItem(int chave, String valor){
        this.Chave = chave;
        this.Valor = valor;
    }
    
    @Override
    public String toString() {
        return Valor;
    }        
}
