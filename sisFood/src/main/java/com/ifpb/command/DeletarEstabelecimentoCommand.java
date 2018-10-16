/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Estabelecimento;
import com.ifpb.model.Manager.EstabelecimentoManager;
import com.ifpb.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonas
 */
public class DeletarEstabelecimentoCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
      
     Estabelecimento e = new Estabelecimento();
        e.setId(Integer.parseInt( request.getParameter("estabelecimentoId")));
        
     Object user = request.getSession().getAttribute("Usuario");
     
        System.out.println("id do estabelecimento :" + e.getId());
     
     Usuario usuario = (Usuario) (user);
     
     EstabelecimentoManager gerenciador = new EstabelecimentoManager();
     
     gerenciador.remover(usuario.getEmail(), e);
     
     response.sendRedirect("meusEstabelecimentos.jsp");
     
        
      
        
    }
    
}
