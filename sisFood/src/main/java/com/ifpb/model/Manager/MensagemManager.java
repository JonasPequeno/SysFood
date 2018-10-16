package com.ifpb.model.Manager;

import com.ifpb.factory.DaoFactory;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.interfaces.MensagemDaoIF;

/**
 *
 * @author jonas
 */
public class MensagemManager implements MensagemDaoIF{
    
    private DaoFactoryIF factory = null;
    private MensagemDaoIF mensagemDao = null;

    public MensagemManager() {
        factory = DaoFactory.createFactoryDao();
        mensagemDao = factory.criaMensagemDaoIf();
    }

    @Override
    public boolean enviar(String remetente, String destinario, String data, String hora, String msg) {
        return mensagemDao.enviar(remetente, destinario, data, hora, msg);
    }
    
    
    
    
    
}
