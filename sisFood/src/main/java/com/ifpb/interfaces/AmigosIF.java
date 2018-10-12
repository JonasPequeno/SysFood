package com.ifpb.interfaces;

import com.ifpb.model.Usuario;
import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface AmigosIF {
    
    public List<Usuario> listarAmigos(String email);
    public boolean aceitarAmizade(String userRemetente, String userDestinatario);
    public boolean excluirAmigo(String userRemetente, String userDestinatario);
    public boolean enviarSolicitacao (String userRemetente, String userDestinatario);
    public boolean recusarSolicitacao (String userRemtente, String userDestinatario);
    
}
