package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.UsuarioDaoIF;
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
public class UsuarioDao implements UsuarioDaoIF {

    @Override
    public boolean inserir(Usuario usuario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "INSERT INTO USUARIO(Nome, Sexo, Email, Foto, Fone, "
                    + "Descricao, Profissao, Cidade, Estado, Cep, Rua, Senha) VALUES ("
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstam = con.prepareStatement(sql);
            pstam.setString(1, usuario.getNome());
            pstam.setString(2, usuario.getSexo());
            pstam.setString(3, usuario.getEmail());
            pstam.setString(4, usuario.getFotoPerfil());
            pstam.setString(5, usuario.getFone());
            pstam.setString(6, usuario.getDescricao());
            pstam.setString(7, usuario.getProfissao());
            pstam.setString(8, usuario.getCidade());
            pstam.setString(9, usuario.getEstado());
            pstam.setString(10, usuario.getCep());
            pstam.setString(11, usuario.getRua());
            pstam.setString(12, usuario.getSenha());
            pstam.execute();
            pstam.close();
            con.close();            
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO INSERIR : " + ex.getMessage());
            return false;
        }        
    }
    @Override
    public boolean editar(Usuario usuario) {
        try {      
            System.out.println("Usuario" + usuario);
            System.out.println("Dao :"+usuario.toString());
            Connection con = Conexao.getConnection();
            String sql = "UPDATE USUARIO SET "
                    + "NOME = ? , SEXO = ? ,FOTO = ? ,"
                    + "FONE = ?, DESCRICAO = ? , PROFISSAO = ? ,"
                    + "CIDADE = ? , ESTADO = ? , CEP = ? , RUA = ? WHERE EMAIL = ?";
            PreparedStatement pstam = con.prepareStatement(sql);
            pstam.setString(1, usuario.getNome());
            pstam.setString(2, usuario.getSexo());
            pstam.setString(3, usuario.getFotoPerfil());
            pstam.setString(4, usuario.getFone());
            pstam.setString(5, usuario.getDescricao());
            pstam.setString(6, usuario.getProfissao());
            pstam.setString(7, usuario.getCidade());
            pstam.setString(8, usuario.getEstado());
            pstam.setString(9, usuario.getCep());
            pstam.setString(10, usuario.getRua());
            pstam.setString(11, usuario.getEmail());
            pstam.executeUpdate();
            pstam.close();
            con.close();            
            return  true;
        } catch (SQLException ex) {
            System.out.println("ERRO AO EDITAR :" + ex.getMessage());
            return false;
        }                
    }

    @Override
    public boolean remover(Usuario usuario) {
        try {
            Connection con = Conexao.getConnection();
            String sql = "UPDATE Usuario set Status = false WHERE email = ?";
            PreparedStatement pstam = con.prepareStatement(sql);
            pstam.setString(1,usuario.getEmail());
            pstam.executeUpdate();
            pstam.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO REMOVER O USUARIO :" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Usuario> listar() {
        ArrayList<Usuario> usuarios  = new ArrayList<>();
        try {
            Connection con = Conexao.getConnection();
            String sql = "SELECT Nome, Sexo, Email, Foto, Fone, Descricao, Profissao,"
                    + "Cidade, Estado, Rua, Cep"
                    + " FROM USUARIO";
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
                usuarios.add(u);
            }
            return usuarios;
            } catch (SQLException ex) {
            System.out.println("ERRO AO LISTAR OS USUARIOS :" + ex.getMessage());
            return null;
        }
    }
    
    public Usuario getByEmail (String email) {
        try {
            System.out.println("Email no dao" + email);
            Usuario user = new Usuario();
            Connection con = Conexao.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE EMAIL ILIKE ?";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, email);
            ResultSet result = state.executeQuery();
            
            if(result.next()) {
               user.setEmail(result.getString("email"));
               user.setSenha(result.getString("senha"));
               user.setNome(result.getString("nome"));
               user.setProfissao(result.getString("profissao"));
               user.setDescricao(result.getString("descricao"));
               user.setRua(result.getString("rua"));
               user.setCidade(result.getString("cidade"));
               user.setEstado(result.getString("estado"));
               user.setCep(result.getString("cep"));
               user.setFone(result.getString("fone"));
               user.setSexo(result.getString("sexo"));
               //user.setNumero(result.getInt("numero"));
               user.setFotoPerfil(result.getString("foto"));
            }
            state.close();
            con.close();
            return user;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
     
    public Usuario login (String email, String senha) {
            Usuario user = new Usuario();
            Connection con;
        try {
            con = Conexao.getConnection();
            String sql = "SELECT * FROM USUARIO WHERE EMAIL ILIKE ? AND SENHA ILIKE ?";
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, email);
            state.setString(2, senha);
            ResultSet result = state.executeQuery();
            
            if(result.next()) {
               user.setEmail(result.getString("email"));
               user.setSenha(result.getString("senha"));
               user.setNome(result.getString("nome"));
               user.setProfissao(result.getString("profissao"));
               user.setDescricao(result.getString("descricao"));
               user.setRua(result.getString("rua"));
               user.setCidade(result.getString("cidade"));
               user.setEstado(result.getString("estado"));
               user.setCep(result.getString("cep"));
               user.setFone(result.getString("fone"));
               user.setSexo(result.getString("sexo"));
               //user.setNumero(result.getInt("numero"));
               user.setFotoPerfil(result.getString("foto"));
            }
            state.close();
            con.close();
            return user;
            
        } catch (SQLException ex) {
            System.out.println("Erro " + ex.getMessage());
            return null;
        }        
               
    }
    
}
