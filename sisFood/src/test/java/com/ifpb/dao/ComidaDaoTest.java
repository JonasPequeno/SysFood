
package com.ifpb.dao;

import com.ifpb.model.Comida;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonaspeuqno
 */
public class ComidaDaoTest {
    
    ComidaDao dao = new ComidaDao();
    
    public ComidaDaoTest() {
    }

    @Test
    public void testInserir() {
        Comida comida = new Comida("Carne  Assada ", 12, 10, "Porção de 1Kg");
        assertTrue(dao.inserir(comida));
    }

    @Test
    public void testEditar() {
        Comida comida = new Comida(1,"Carne Cozida", 12, 10, "Porção de 1Kg");
        assertTrue(dao.editar(comida));
        
    }

    @Test
    public void testRemover() {
        Comida comida = new Comida(2,"Carne  Assada ", 12, 10, "Porção de 1Kg");
        assertTrue(dao.remover(comida));
    }

    @Test
    public void testListar() {
        assertNotNull(dao.listar());
    }
    
}
