package com.ifpb.model.Manager;

import com.ifpb.factory.DaoFactory;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.interfaces.EstabelecimentoDaoIF;
import com.ifpb.model.Estabelecimento;
import java.util.List;

/**
 *
 * @author jonas
 */

public class EstabelecimentoManager implements EstabelecimentoDaoIF{
    
    private DaoFactoryIF factory = null;
    private EstabelecimentoDaoIF estabelecimentoDao = null;

    public EstabelecimentoManager() {
        factory =  DaoFactory.createFactoryDao();
        estabelecimentoDao = factory.criaEstabelecimentoDao();
    }
    
    

    @Override
    public boolean inserir(String email, Estabelecimento e) {
        try {
            return estabelecimentoDao.inserir(email, e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean editar(String email, Estabelecimento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String email, Estabelecimento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estabelecimento> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Estabelecimento> getEstabelecimentosUsuario (String usuario) {
        return estabelecimentoDao.getEstabelecimentosUsuario(usuario);
    }
    
    
    
}
