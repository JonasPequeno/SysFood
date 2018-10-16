
package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.MensagemDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonas
 */
public class MensageDao implements MensagemDaoIF{

    @Override
    public boolean enviar(String remetente, String destinario, String data, String hora, String msg) {
        
        try {
            Connection con = Conexao.getConnection();
            String sql = "INSERT INTO enviamensagem(emailDestinatario, emailRemetente, data, hora, mensagem)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql);
            
            pstate.setString(1,destinario);
            pstate.setString(2,remetente);
            pstate.setString(3, data);
            pstate.setString(4, hora);
            pstate.setString(5, msg);
           
            pstate.execute();
            pstate.close();
            con.close();            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao Enviar Mensagem :" + e.getMessage());

        }
        return false;
    }
    
}
