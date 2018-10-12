/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.AmigosIF;
import com.ifpb.model.Usuario;
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
    public List<Usuario> listarAmigos(String email) {
        ArrayList<Usuario> amigos = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM usuario u, getAmigos('"+email+"') g WHERE g.email ilike u.email ";
            
            Statement state = con.createStatement(
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT,
                    ResultSet.TYPE_SCROLL_SENSITIVE
            );                       
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
               Usuario u = new Usuario();
                u.setNome(result.getString("nome"));
                u.setEmail(result.getString("email"));
                u.setSexo(result.getString("sexo"));
                u.setFone(result.getString("fone"));
                u.setFotoPerfil(result.getString("foto"));
                u.setDescricao(result.getString("descricao"));
                u.setProfissao(result.getString("profissao"));
                u.setCidade(result.getString("cidade"));
                u.setEstado(result.getString("estado"));
                u.setCep(result.getString("cep"));
                u.setRua(result.getString("rua"));
                amigos.add(u);
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
            String sql = "SELECT aceitarSolicitacao(?, ?)";
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
