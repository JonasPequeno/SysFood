package com.ifpb.dao;

import com.ifpb.interfaces.UsuarioDaoIF;
import com.ifpb.model.Usuario;
import java.util.List;
/**
 *
 * @author jonaspeuqno
 */
public class UsuarioDao implements UsuarioDaoIF {

    @Override
    public boolean inserir(Usuario usuario) {
       return true;
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
        
    }
    
}
