/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador.lojadeinformatica.dao;

import com.projetointegrador.lojadeinformatica.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author robso
 */
public class ComputadorDAO {
    
    public static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Computador obj) throws SQLException{
        Connection conexao = null;
        boolean retorno = false;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO computador(marca, hd, processador) VALUES(?,?,?)");
            comandoSQL.setString(1, obj.getMarca());
            comandoSQL.setString(2, obj.getHD());
            comandoSQL.setString(3, obj.getProcessador());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
            }
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    
    public static ArrayList<Computador> listar(Computador obj) throws SQLException{
        Connection conexao = null;
        ArrayList<Computador> lista = new ArrayList<Computador>();
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM computador where processador=?");
            comandoSQL.setString(1, obj.getProcessador());
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs !=null){
                while(rs.next()){
                   Computador novoObjeto = new Computador();
                    novoObjeto.setID(rs.getInt("id"));
                    novoObjeto.setHD(rs.getString("hd"));
                    novoObjeto.setProcessador(rs.getString("processador"));
                    
                    lista.add(novoObjeto);
                }
                
            }
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return lista;
    }
    
    public static Computador consultarPorProcessador(String processador){
        Computador lista = new Computador();
        return lista;
    }
    
    public static boolean atualizar(Computador obj){
        Connection conexao = null;
        boolean retorno = false;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE computador SET hd=?, processador=? WHERE id=?");
            comandoSQL.setString(1, obj.getHD());
            comandoSQL.setString(2, obj.getProcessador());
            comandoSQL.setInt(3, obj.getId());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno=true;
            }
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    
    public static boolean excluir(String excluirPorId){
        Connection conexao = null;
        boolean retorno = false;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM computador WHERE id=?");
            comandoSQL.setString(1,excluirPorId);
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
}
