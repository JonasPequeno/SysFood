/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.AmigosIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonaspeuqno
 */
public class AmigosDao implements AmigosIF{

    @Override
    public boolean excluirAmigo(String userRemetente, String userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT excluirAmigo(?, ?)";
            PreparedStatement pstate = con.prepareStatement(sql);
            
            pstate.setString(1,userRemetente);
            pstate.setString(2,userDestinatario);
            
            pstate.execute();
            pstate.close();
            con.close();           
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO DESFAZER AMIZADE :" + ex.getMessage());
            return false;
        }
        
    }
    
    @Override
    public List<String> listarAmigos(String email) {
        ArrayList<String> amigos = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM getAmigos(?)";
            
            PreparedStatement state = con.prepareCall(sql);
            
            state.setString(1, email);
            
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
               amigos.add(result.getString("userDestinatario"));
            }
            
            con.close();
            return amigos;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO BUSCAR AMIGOS :" + ex.getMessage());
            return null;
        }       
    }

    @Override
    public boolean enviarSolicitacao(String userRemetente, String userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql= "SELECT enviaSolicitacao(?, ?)";
            
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRRO AO ENVIAR SOLICITAÇAO : " +ex.getMessage());
            return false;
        }
       
    }

    @Override
    public boolean aceitarAmizade(String userRemetente, String userDestinatario){
        try {
            Connection con = Conexao.getConnection();
            String sql = "aceitarSolicitacao(?, ?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
                    
        } catch (SQLException ex) {
            System.out.println("ERRO AO ACEITAR AMIZADE : "+ ex.getMessage() );
            return false;
        }
    }

    @Override
    public boolean recusarSolicitacao(String userRemetente, String userDestinatario) {
        Connection con;
        try {
            con = Conexao.getConnection();
            String sql = "recusarSolicitacao(?, ?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO RECUSAR SOLICITAÇAO : " +ex.getMessage());
            return false;
        }
            
        
    }

    
}
