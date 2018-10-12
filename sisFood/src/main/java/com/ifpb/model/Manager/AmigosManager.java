package com.ifpb.model.Manager;

import com.ifpb.factory.DaoFactory;
import com.ifpb.interfaces.AmigosIF;
import com.ifpb.interfaces.DaoFactoryIF;
import com.ifpb.model.Usuario;
import java.util.List;

/**
 *
 * @author jonas
 */
public class AmigosManager  implements  AmigosIF{
    
    private DaoFactoryIF factory = null;
    private AmigosIF amigosDao = null;

    public AmigosManager() {
        factory = DaoFactory.createFactoryDao();
        amigosDao = factory.criaAmigoDao();
    }
    
    @Override
    public List<Usuario> listarAmigos(String email) {
        return amigosDao.listarAmigos(email);
    }

    @Override
    public boolean aceitarAmizade(String userRemetente, String userDestinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirAmigo(String userRemetente, String userDestinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enviarSolicitacao(String userRemetente, String userDestinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean recusarSolicitacao(String userRemtente, String userDestinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
