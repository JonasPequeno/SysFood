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
            String sql = "DELETE FROM Amizade a WHERE a.userRemetente = ? and userDestinatario = ? and status is true";
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
            String sql = "SELECT * FROM getAmigos g WHERE g.userRemetente ILIKE ? ";
            
            Statement state = con.createStatement();
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

    
}
