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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public boolean Inserir(String email, Estabelecimento e) {
        
        try {
            
            Connection con = Conexao.getConnection();
            String sql = "INSERT INTO Estabelecimento (Nome=?, Nota=?, Foto=?, Fone=?, Tipo=?, Funcionamento=?"
                + ", Descricao=?, UserAdd=?, Cidade=?, Estado=?, Cep=? , Rua=? , Numero=? )";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setDouble(2, e.getNota());
            stmt.setString(3, e.getFoto());
            stmt.setString(4, e.getFone());
            stmt.setString(5, e.getTipo());
            stmt.setDate(6, Date.valueOf(e.getFuncionamento()));
            stmt.setString(7, e.getDescricao());
            stmt.setString(8, email);
            stmt.setString(9, e.getCidade());
            stmt.setString(10, e.getEstado());
            stmt.setString(11, e.getCep());
            stmt.setString(12, e.getRua());
            stmt.setString(13, e.getNumero());
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro na conexão: ".concat(ex.getMessage()));
        }
        return false;
        
    }

    @Override
    public boolean Editar(String email, Estabelecimento e) {
        
        try {
            
            Connection con = Conexao.getConnection();
            String sql="UPDATE Estabelecimento SET nome=?, nota=?, foto=?, fone=?, "
                    + "tipo=?, funcionario=?, descricao=?, userAdd=?, cidade=?, estado=?, "
                    + "cep=?, rua=?, numero=? WHERE email=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, e.getNome());
            stmt.setDouble(2, e.getNota());
            stmt.setString(3, e.getFoto());
            stmt.setString(4, e.getFone());
            stmt.setString(5, e.getTipo());
            stmt.setDate(6, Date.valueOf(e.getFuncionamento()));
            stmt.setString(7, e.getDescricao());
            stmt.setString(8, e.getUserAdd());
            stmt.setString(9, e.getCidade());
            stmt.setString(10, e.getEstado());
            stmt.setString(11, e.getCep());
            stmt.setString(12, e.getRua());
            stmt.setString(13, e.getNumero());
            stmt.setString(14, email);
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println("Erro na conexão: ".concat(ex.getMessage()));
        }
        return false;
       
           
    }

    @Override
    public boolean Remover(String email, Estabelecimento e) {
        
         try {
            
            Connection con = Conexao.getConnection();
            String sql="DELETE FROM Estabelecimento WHERE UserAdd=? and id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,email);
            stmt.setInt(2, e.getId());
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar: ".concat(ex.getMessage()));
        }
        return false;
        
    }

    @Override
    public List<Estabelecimento> Listar(String email) {
        
        List<Estabelecimento> listaEstab = new ArrayList<>();
      
        try {
            
            Connection con = Conexao.getConnection();
            String sql ="SELECT * FROM Estabelecimento WHERE UserAdd=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double nota = rs.getDouble("nota");
                String foto = rs.getString("foto");
                String fone = rs.getString("fone");
                String tipo = rs.getString("tipo");
                String dt = String.valueOf(rs.getDate("funcionamento"));
                String descricao = rs.getString("descricao");
                String user = rs.getString("UserAdd");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate funcionamento = LocalDate.parse(dt, formatter);
                
                Estabelecimento e = new Estabelecimento(id, nome, foto, descricao, fone, funcionamento, tipo, nota,
                user, rua, cidade, numero, cep, estado);
                listaEstab.add(e);
                
                
            }
            
            rs.close();
            stmt.close();
            con.close();
            
            return listaEstab;
            
                
        } catch (SQLException ex) {
            System.out.println("Erro na conexão: ".concat(ex.getMessage()));
        }
        return null;
        
        
    }
    
    
    
}
