/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.dao.ComidaDao;
import com.ifpb.interfaces.ComidaDaoIF;
import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Comida;
import com.ifpb.model.Manager.ComidaManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class ComidaCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        ComidaManager comidaM = new ComidaManager();
        Comida comida = new Comida();
        
        comida.setNome(request.getParameter("nome"));
        comida.setDescricao(request.getParameter("descricao"));
        comida.setPreco(Float.parseFloat(request.getParameter("preco")));
        
        if(comidaM.inserir(comida)){
            response.sendRedirect("cadastroComida.jsp");
        }
            
        
    }

   
}
