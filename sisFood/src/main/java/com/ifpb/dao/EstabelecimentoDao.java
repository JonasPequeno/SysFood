/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.EstabelecimentoDaoIF;
import com.ifpb.model.Estabelecimento;
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
 * @author Matheus
 */
public class EstabelecimentoDao implements EstabelecimentoDaoIF{

    public EstabelecimentoDao() {
    }

    @Override
    public boolean inserir(String email, Estabelecimento e) {
        try {
            Connection con = Conexao.getConnection();
            String sql ="INSERT INTO estabelecimento(NOME, FOTO,FONE,TIPO,HORAABERTURA,HORAFECHAMENTO,"
                    + "DESCRICAO,USERADD,CIDADE,ESTADO,CEP,RUA,NUMERO)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, e.getNome());
            state.setString(2, e.getFoto());
            state.setString(3, e.getFone());
            state.setString(4, e.getTipo());
            state.setString(5, e.getHoraAbertura());
            state.setString(6, e.getHoraFechamento());
            state.setString(7, e.getDescricao());
            state.setString(8, email);   
            state.setString(9, e.getCidade());
            state.setString(10, e.getEstado());
            state.setString(11, e.getCep());
            state.setString(12, e.getRua());
            state.setInt(13,e.getNumero());
            
            state.execute();
            state.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR UM ESTABELECIMENTO : " +ex.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean editar(String email, Estabelecimento e) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "UPDATE ESTABELECIMENTO SET NOME = ?, FOTO = ?,FONE = ?,TIPO = ?,HORAABERTURA = ?,HORAFECHAMENTO = ? ,"
                    + "DESCRICAO = ?,CIDADE = ?,ESTADO = ?,CEP = ?,RUA = ?,NUMERO = ?"
                    + "WHERE USERADD = ? ";
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setString(1, e.getNome());
            state.setString(2, e.getFoto());
            state.setString(3, e.getFone());
            state.setString(4, e.getTipo());
            state.setString(5, e.getHoraAbertura());
            state.setString(6, e.getHoraFechamento());
            state.setString(7, e.getDescricao());
            state.setString(8, e.getCidade());
            state.setString(9, e.getEstado());
            state.setString(10, e.getCep());
            state.setString(11, e.getRua());
            state.setInt(12, e.getNumero());
            state.setString(13, email);
            
            state.executeUpdate();
            state.close();
            con.close();
            return true;            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EDITAR O ESTABELECIMENTO : " + ex.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean remover(String email, Estabelecimento e) {
       Connection con;
        try {
         con = Conexao.getConnection();
         String sql = "DELETE FROM ESTABELECIMENTO WHERE ID = ? and UserAdd = ?";
         PreparedStatement state = con.prepareStatement(sql);
         state.setInt(1, e.getId());
         state.setString(2, email);
         state.execute();
         state.close();
         con.close();
         return true;
        } catch (SQLException ex) {
         System.out.println("ERRO AO REMOVER ESTABELECIMENTO  : " +ex.getMessage());
         return false;
        }
      
       
    }

    @Override
    public List<Estabelecimento> listar() {
        ArrayList<Estabelecimento> estabele = new ArrayList<>();
        Estabelecimento e = new Estabelecimento();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM ESTABELECIMENTO";
            
            Statement state = con.createStatement(
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT,
                    ResultSet.TYPE_SCROLL_SENSITIVE
            );
            
            ResultSet result = state.executeQuery(sql);
            
            while(result.next()) {
                e.setId(result.getInt("id"));
                e.setFoto(result.getString("foto"));
                e.setNome(result.getString("nome"));
                e.setNumero(result.getInt("numero"));
                e.setRua(result.getString("rua"));
                e.setTipo(result.getString("tipo"));
                e.setHoraAbertura(result.getString("horaAbertura"));
                e.setHoraFechamento(result.getString("horaFechamento"));
                e.setDescricao(result.getString("descricao"));
                e.setUserAdd(result.getString("userAdd"));
                e.setCidade(result.getString("cidade"));
                e.setCidade(result.getString("cidade"));
                e.setEstado(result.getString("estado"));
                e.setCep(result.getString("cep"));
                
                estabele.add(e);
                System.out.println("Estabelecimento recuperado :" + e.toString());
            }
            return estabele;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override   
    public List<Estabelecimento> getEstabelecimentosUsuario (String usuario) {
        try{
            
            List<Estabelecimento> lista = new ArrayList<>();
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM ESTABELECIMENTO E WHERE E.UserAdd ilike ?";
            Estabelecimento e = new Estabelecimento();
            
            PreparedStatement state = con.prepareStatement(sql);
            
            state.setString(1, usuario);
            
            ResultSet result = state.executeQuery();
            
            while (result.next())  {
                e.setId(result.getInt("id"));
                e.setFoto(result.getString("foto"));
                e.setNome(result.getString("nome"));
                e.setNumero(result.getInt("numero"));
                e.setRua(result.getString("rua"));
                e.setTipo(result.getString("tipo"));
                e.setHoraAbertura(result.getString("horaAbertura"));
                e.setHoraFechamento(result.getString("horaFechamento"));
                e.setDescricao(result.getString("descricao"));
                e.setUserAdd(result.getString("userAdd"));
                e.setCidade(result.getString("cidade"));
                e.setCidade(result.getString("cidade"));
                e.setEstado(result.getString("estado"));
                e.setCep(result.getString("cep"));                                    
                
                lista.add(e);
            }
            
            return lista;
            
            
        }
        catch (Exception ex) {
            Logger.getLogger(EstabelecimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
        
    }
    
}
