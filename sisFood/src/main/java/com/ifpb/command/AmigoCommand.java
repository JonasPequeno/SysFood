/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.AmigosManager;
import com.ifpb.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonas
 */
public class AmigoCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        HttpSession sessao = request.getSession();
        
        AmigosManager gereciador = new AmigosManager();
        
        Object user = request.getSession().getAttribute("Usuario");
        Usuario usuario = (Usuario) (user);
        
        List<Usuario> amigos = new ArrayList<>();
            amigos = gereciador.listarAmigos(usuario.getEmail());
        
        request.getSession().setAttribute("listaAmigos",amigos);
        
        response.sendRedirect("amigos.jsp");
        
    }
    
}
