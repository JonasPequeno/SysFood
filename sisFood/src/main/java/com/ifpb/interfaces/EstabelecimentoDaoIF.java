package com.ifpb.interfaces;

import com.ifpb.model.Estabelecimento;
import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface EstabelecimentoDaoIF {
    
    public boolean inserir (String email, Estabelecimento e);
    public boolean editar (String email, Estabelecimento e);
    public boolean remover (String email, Estabelecimento e);
    public List<Estabelecimento> listar();
    
}
