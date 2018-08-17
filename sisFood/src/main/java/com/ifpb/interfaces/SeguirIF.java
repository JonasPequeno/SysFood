package com.ifpb.interfaces;

import java.util.List;

/**
 *
 * @author jonas
 */
public interface SeguirIF {
    
    public List<Integer> listarPedidoSeguir(int idUser);
    public boolean excluirPedido(int userRemetente, int userDestinatario);
}
