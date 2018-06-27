package com.ifpb.dao;

import com.ifpb.model.Usuario;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonaspeuqno
 */
public class UsuarioDaoTest {
    
    UsuarioDao dao = new UsuarioDao();
    
    public UsuarioDaoTest() {
        
    }    

    @Test
    public void testInserir() {        
        Usuario user = new 
        Usuario("UserTeste", "UserTeste@gmail.com", "Testador","M",
                "Sem foto","123", "Rua Teste 12", "12", "Teste", 
                "Teste","Testando", "teste", "Teste-TE");
        System.out.println(user);        
        assertTrue(dao.inserir(user));
    }

    @Test
    public void testEditar() {
        Usuario user = new 
        Usuario("EditaTeste", "UserTeste@gmail.com", "aaaa","M",
                "Sem foto","123", "Rua Teste 12", "12", "Teste", 
                "Teste","Testando", "teste", "Teste-TE");
        System.out.println(user);
        assertTrue(dao.editar(user));
    }

    @Test
    public void testRemover() {
        Usuario user = new 
        Usuario("UserTeste", "UserTeste@gmail.com", "Testador","M",
                "Sem foto","123", "Rua Teste 12", "12", "Teste", 
                "Teste","Testando", "teste", "Teste-TE");
        assertTrue(dao.remover(user));
    }

    @Test
    public void testListar() {
        assertNotNull(dao.listar());
    }
    
}
