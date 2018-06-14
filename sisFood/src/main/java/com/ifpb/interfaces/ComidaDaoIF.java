package com.ifpb.interfaces;

import com.ifpb.model.Comida;
import java.util.List;

/**
 *
 * @author jonaspeuqno
 */
public interface ComidaDaoIF {
    
    public boolean inserir (Comida comida);
    public boolean editar (Comida comida);
    public boolean remover (Comida comida);
    public List<Comida> listar();
}
