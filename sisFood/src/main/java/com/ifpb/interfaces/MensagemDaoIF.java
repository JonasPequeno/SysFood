package com.ifpb.interfaces;

/**
 *
 * @author jonas
 */
public interface MensagemDaoIF {
    
    public boolean enviar(String remetente,String destinario,String data, String hora, String msg);
}
