
package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.SolicitaAmizade;
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
public class SolicitacaoAmizadeDao implements SolicitaAmizade{

    @Override
    public boolean enviaSolicitacao(String userRemetente, String userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "INSERT INTO Amizade(UserRemetente, UserDestinatario, Status)"
                    + "VALUES(?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,userRemetente );
            pstate.setString(2,userDestinatario);
            pstate.setBoolean(3,false);
            pstate.execute();
            pstate.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO ENVIAR SOLICITAÇÃO :" + ex.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean excluirSolicitacao(String userRemetente, String userDestinatario){
         try{
            Connection con = Conexao.getConnection();
            String sql = "DELETE FROM Amizade a WHERE a.userRemetente ILIKE ?"
                    + "a.userDestinatario ILIKE ? ";
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1, userRemetente);
            pstate.setString(2, userDestinatario);
            pstate.execute();
            pstate.close();
            con.close();
            return true;
        } catch (SQLException ex) {
             System.out.println("ERRO AO EXCLUIR A SOLICITAÇÃO :" +ex.getMessage());
             return false;
        }
        
    }

    @Override
    public boolean aceitarSolicitacao(String userRemetente, String userDestinatario) {
        try {
            Connection  con = Conexao.getConnection();
            String sql = "UPDATE Amizade a SET status = true"
                    + " WHERE a.userRemetente ILIKE ? and a.userDestinatario ILIKE ? ";
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1, userRemetente);
            pstate.setString(2, userDestinatario);
            pstate.executeUpdate();
            pstate.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO ACEITAR SOLICITAÇÃO :" +ex.getMessage());
            return false;
        }
        
    }

    @Override
    public List<String> solicitacoes(String email) {
        ArrayList<String> solicitacoes = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM getSolicitacoes g WHERE g.userRemetente ILIKE ? ";
            
            Statement state = con.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
               solicitacoes.add(result.getString("userDestinatario"));
            }
            
            con.close();
            return solicitacoes;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO BUSCAR AS SOLICITAÇÕES :" + ex.getMessage());
            return null;
        }
    }
    
}
