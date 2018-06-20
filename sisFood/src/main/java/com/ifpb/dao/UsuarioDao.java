package com.ifpb.dao;

import com.ifpb.factory.Conexao;
import com.ifpb.interfaces.UsuarioDaoIF;
import com.ifpb.model.Usuario;
import java.sql.Connection;
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
            String sql = String.format("INSERT INTO USUARIO(Nome, Sexo, Email, Foto, Fone, "
                    + "Descricao, Profissao, Cidade, Estado, Cep, Rua, Senha) VALUES ("
                    + "%s, %c, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
                    usuario.getNome(),usuario.getSexo(), usuario.getEmail(), usuario.getFotoPerfil(),
                    usuario.getFone(), usuario.getDescricao(), usuario.getProfissao(), usuario.getCidade(),
                    usuario.getEstado(), usuario.getCep(), usuario.getRua(), usuario.getSenha()
            );
            
            Statement stam = con.createStatement();
            stam.executeUpdate(sql);
            stam.close();
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
