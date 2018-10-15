/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model.Manager;

import com.ifpb.factory.DaoFactory;
import com.ifpb.interfaces.ComidaDaoIF;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.model.Comida;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class ComidaManager implements ComidaDaoIF{
    
    private DaoFactoryIF factory = null;
    private ComidaDaoIF comidaDao = null;

    public ComidaManager() {
        factory = DaoFactory.createFactoryDao();
        comidaDao = factory.criaComidaDao();
    }

    @Override
    public boolean inserir(Comida comida) {
        return comidaDao.inserir(comida);
    }

    @Override
    public boolean editar(Comida comida) {
        return comidaDao.editar(comida);
    }

    @Override
    public boolean remover(Comida comida) {
        return comidaDao.remover(comida);
    }

    @Override
    public List<Comida> listar() {
        return comidaDao.listar();
    }
    
    
    
    
    
    
}
