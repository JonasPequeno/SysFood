package com.ifpb.interfaces;

import com.ifpb.model.Usuario;
import java.util.List;
/**
 *
 * @author jonaspeuqno
 */
public interface UsuarioDaoIF {
    
    public boolean inserir (Usuario usuario);
    public boolean editar (Usuario usuario);
    public boolean remover (Usuario usuario);
    public List<Usuario> listar();
    public Usuario getByEmail (String email);
    public Usuario login (String email, String senha);
    
}
