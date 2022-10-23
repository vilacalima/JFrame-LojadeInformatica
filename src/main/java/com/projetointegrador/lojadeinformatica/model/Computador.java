/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador.lojadeinformatica.model;

/**
 *
 * @author robso
 */
public class Computador {
  
    static String marca = "Robson Lima";
    private String hd;
    private String processador;
    private int id;
    
    public Computador(){
        
    }
    
    public Computador(String processador){
        this.processador = processador;
    }
    
    public Computador(String hd, String processador){
       
        this.hd = hd;
        this.processador = processador;
    }
    
    public int getId(){
        return id;
    }
    
    public void setID(int novoID){
        this.id = novoID;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setHD(String novoHD){
        this.hd = novoHD;
    }
    
    public String getHD(){
        return hd;
    }
    
    public void setProcessador(String novoProcessador){
        this.processador = novoProcessador;
    }
    
    public String getProcessador(){
        return processador;
    }
}

