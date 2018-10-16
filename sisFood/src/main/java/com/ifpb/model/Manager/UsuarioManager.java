    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model.Manager;

import com.ifpb.dao.UsuarioDao;
import com.ifpb.factory.DaoFactory;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.interfaces.UsuarioDaoIF;
import com.ifpb.model.Usuario;
import java.util.List;

/**
 *
 * @author jonas
 */
public class UsuarioManager implements UsuarioDaoIF{
    
    private DaoFactoryIF factory = null;
    private UsuarioDaoIF usuarioDao = null;
    
    public UsuarioManager(){
        factory = DaoFactory.createFactoryDao();
        usuarioDao = factory.criaUsuarioDao();
    }

    @Override
    public boolean inserir(Usuario usuario) {
        
       return usuarioDao.inserir(usuario);
    }

    @Override
    public boolean editar(Usuario usuario) {
       return usuarioDao.editar(usuario);       
    }

    @Override
    public boolean remover(Usuario usuario) {
       return true;
    }

    @Override
    public List<Usuario> listar() {
       return usuarioDao.listar();
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioDao.getByEmail(email);
    }

    @Override
    public Usuario login(String email, String senha) {

        Usuario usuario = null;          
       
        if(this.getByEmail(email) == null) {
            System.out.println("Email nao encontrado");
            return null;
        }
        else {
            usuario = usuarioDao.login(email, senha);
            if(usuario == null) {
                System.out.println("Senha Incorreta");
                return null;
            }else {
                return usuario;
            }       
        }
    }
       
}