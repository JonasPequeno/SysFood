package com.ifpb.interfaces;

import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface SolicitaAmizade {

    public boolean enviaSolicitacao(String userRemetente, String userDestinatario);
    public boolean excluirSolicitacao(String userRemetente, String userDestinatario);
    public boolean aceitarSolicitacao(String userRemetente, String userDestinatario);
    public List<String> solicitacoes ( String email);
}
