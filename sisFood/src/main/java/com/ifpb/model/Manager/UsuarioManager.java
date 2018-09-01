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
        System.out.println("Email pessoa Manager" + email);
        if(dao.getByEmail(email) != null) {
            System.out.println("Email nao encontrado");
        }
        else {
            usuario = dao.login(email, senha);
            if(usuario == null) {
                System.out.println("Senha Incorreta");
            }
        }
        return usuario;        
    }
    
}
