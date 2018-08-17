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
    public boolean excluirPedido(int userRemetente, int userDestinatario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "DELETE FROM Amizade a WHERE a.userRemetente = ? and userDestinatario = ? and status is true";
            PreparedStatement pstate = con.prepareStatement(sql);
            
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
    public List<Integer> listarPedidoSeguir(int idUser) {
        return null;
    }
   
    
}
