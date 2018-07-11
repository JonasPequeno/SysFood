package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.ComidaDaoIF;
import com.ifpb.model.Comida;
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
public class ComidaDao implements ComidaDaoIF{

    public ComidaDao() {
    }
  

    @Override
    public boolean inserir(Comida comida) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "INSERT INTO COMIDA(Nome, Nota, Descricao, Preco)"
                   + "VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,comida.getNome());
            pstm.setDouble(2,comida.getNota());
            pstm.setString(3,comida.getDescricao());
            pstm.setDouble(4,comida.getPreco());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR A COMIDA :" + ex.getMessage());
            return false;
        }
    }
    @Override
    public boolean editar(Comida comida) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "UPDATE COMIDA SET Nome = ?, Descricao = ?, Preco = ? WHERE Id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, comida.getNome());
            pstm.setString(2, comida.getDescricao());
            pstm.setDouble(3, comida.getPreco());
            pstm.setInt(4, comida.getId());
            pstm.executeUpdate();
            pstm.close();
            con.close();
            return true;            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EDITAR A COMIDA :" + ex.getMessage());
            return false;
        }
        
    }
    
    @Override
    public boolean remover(Comida comida) {
        try {
            System.out.println(comida.getId());
            Connection con = Conexao.getConnection();
            String sql = "DELETE FROM COMIDA WHERE Id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            System.out.println(comida.getId());
            pstm.setInt(1, comida.getId());
            pstm.execute();
            pstm.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO REMOVER COMIDA :" +ex.getMessage());
            return false;
        }
        
    }

    @Override
    public List<Comida> listar() {
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM COMIDA";
            Statement state = con.createStatement(
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT,
                    ResultSet.TYPE_SCROLL_SENSITIVE
            );
            ResultSet result = state.executeQuery(sql);
            
            while(result.next()){
                Comida c = new Comida();
                c.setId(result.getInt("id"));
                c.setNome(result.getString("nome"));
                c.setDescricao(result.getString("descricao"));
                c.setPreco(result.getDouble("preco"));
                c.setNota(result.getDouble("nota"));
                comidas.add(c);   
            }
            return comidas;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO LISTAR COMIDAS :" + ex.getMessage());
            return null;
        }                
    }
    
}
