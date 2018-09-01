package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.SeguirIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class SeguirDao implements SeguirIF{

    @Override
    public List<String> listarAmigos(String email) {
        ArrayList<String> seguidores = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM getSeguidores(?)";
            
            PreparedStatement state = con.prepareCall(sql);
            
            state.setString(1, email);
            
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
               seguidores.add(result.getString("email"));
            }
            
            con.close();
            return seguidores;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO BUSCAR OS SEGUIDORES :" + ex.getMessage());
            return null;
        }               
    }

    @Override
    public boolean aceitarAmizade(String userRemetente, String userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = " SELECT aceitarSolicitacaoSeguir(?, ?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
                    
        } catch (SQLException ex) {
            System.out.println("ERRO AO ACEITAR A SOLICITAÇAO DE SEGUIR : "+ ex.getMessage() );
            return false;
        }
    }

    @Override
    public boolean excluirAmigo(String userRemetente, String userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT excluirSolicitacaoSeguir(?, ?)";
            PreparedStatement pstate = con.prepareStatement(sql);
            
            pstate.setString(1,userRemetente);
            pstate.setString(2,userDestinatario);
            
            pstate.execute();
            pstate.close();
            con.close();           
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO DEIXAR DE SEGUIR :" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean enviarSolicitacao(String userRemetente, String userDestinatario) {
         try {
            Connection con = Conexao.getConnection();
            String sql= "SELECT enviaSolicitacaoSeguir(?, ?)";
            
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRRO AO ENVIAR SOLICITAÇAO DE SEGUIR : " +ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean recusarSolicitacao(String userRemetente, String userDestinatario) {
        Connection con;
        try {
            con = Conexao.getConnection();
            String sql = "recusarSolicitacaoSeguir(?, ?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, userRemetente);
            state.setString(2, userDestinatario);
            state.executeQuery();
            state.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO RECUSAR SOLICITAÇAO DE SEGUIR : " +ex.getMessage());
            return false;
        }
    }

    
    
}
