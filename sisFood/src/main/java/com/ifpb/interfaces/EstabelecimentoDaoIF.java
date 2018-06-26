package com.ifpb.interfaces;

import com.ifpb.model.Estabelecimento;
import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface EstabelecimentoDaoIF {
    
    public boolean Inserir (String email, Estabelecimento e);
    public boolean Editar (String email, Estabelecimento e);
    public boolean Remover (String email, Estabelecimento e);
    public List<Estabelecimento> Listar(String email);
    
}
