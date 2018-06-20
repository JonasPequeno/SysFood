package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.UsuarioDaoIF;
import com.ifpb.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        return true;
    }

    @Override
    public boolean remover(Usuario usuario) {
        return true;
    }

    @Override
    public List<Usuario> listar() {
        return null;        
    }
    
}
