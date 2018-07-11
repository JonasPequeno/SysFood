package com.ifpb.interfaces;

import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface AmigosIF {
    
    public List<String> listarAmigos(String email);
    public boolean excluirAmigo(String userRemetente, String userDestinatario);
    
    
}
