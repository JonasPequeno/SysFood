package com.ifpb.interfaces;

/**
 *
 * @author jonas
 */
public interface DaoFactoryIF {
    
    public AmigosIF criaAmigoDao();
    public ComidaDaoIF criaComidaDao();
    public EstabelecimentoDaoIF criaEstabelecimentoDao();
    public SeguirIF criaSeguirDao();
    public SolicitaAmizade criaSolicitaAmizadeDao();    
    public UsuarioDaoIF criaUsuarioDao();
}
