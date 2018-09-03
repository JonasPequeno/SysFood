    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model.Manager;

import com.ifpb.dao.UsuarioDao;
import com.ifpb.model.Usuario;

/**
 *
 * @author jonas
 */
public class UsuarioManager {
   
    
    public Usuario login (String email, String senha) {
       UsuarioDao dao = new UsuarioDao();
       Usuario usuario = null;          
       
        if(dao.getByEmail(email) == null) {
            System.out.println("Email nao encontrado");
            return null;
        }
        else {
            usuario = dao.login(email, senha);
            if(usuario == null) {
                System.out.println("Senha Incorreta");
                return null;
            }else return usuario;       
        }
 
    }
    
    public boolean cadastra (Usuario user) {
        UsuarioDao dao = new UsuarioDao();
        
        return dao.inserir(user);        
        
    }
    
}
