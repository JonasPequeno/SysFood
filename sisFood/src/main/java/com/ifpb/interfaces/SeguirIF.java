package com.ifpb.interfaces;

import java.util.List;

/**
 *
 * @author jonas
 */
public interface SeguirIF {
    
    public List<String> listarAmigos(String email);
    public boolean aceitarAmizade(String userRemetente, String userDestinatario);
    public boolean excluirAmigo(String userRemetente, String userDestinatario);
    public boolean enviarSolicitacao (String userRemetente, String userDestinatario);
    public boolean recusarSolicitacao (String userRemtente, String userDestinatario);
}
