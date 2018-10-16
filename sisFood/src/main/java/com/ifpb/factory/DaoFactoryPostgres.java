
package com.ifpb.factory;

import com.ifpb.dao.AmigosDao;
import com.ifpb.dao.ComidaDao;
import com.ifpb.dao.EstabelecimentoDao;
import com.ifpb.dao.MensageDao;
import com.ifpb.dao.SeguirDao;
import com.ifpb.dao.SolicitacaoAmizadeDao;
import com.ifpb.dao.UsuarioDao;
import com.ifpb.interfaces.AmigosIF;
import com.ifpb.interfaces.ComidaDaoIF;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.interfaces.EstabelecimentoDaoIF;
import com.ifpb.interfaces.MensagemDaoIF;
import com.ifpb.interfaces.SeguirIF;
import com.ifpb.interfaces.SolicitaAmizade;
import com.ifpb.interfaces.UsuarioDaoIF;

/**
 *
 * @author jonas
 */
public class DaoFactoryPostgres implements DaoFactoryIF{

    @Override
    public AmigosIF criaAmigoDao() {
        return new AmigosDao();
    }

    @Override
    public ComidaDaoIF criaComidaDao() {
       return new ComidaDao();
    }

    @Override
    public EstabelecimentoDaoIF criaEstabelecimentoDao() {
        return new EstabelecimentoDao();
    }

    @Override
    public SeguirIF criaSeguirDao() {
        return new SeguirDao();
    }

    @Override
    public SolicitaAmizade criaSolicitaAmizadeDao() {
        return new SolicitacaoAmizadeDao();
    }

    @Override
    public UsuarioDaoIF criaUsuarioDao() {  
        return new UsuarioDao();
    }

    @Override
    public MensagemDaoIF criaMensagemDaoIf() {
        return new MensageDao();
    }
    
}
