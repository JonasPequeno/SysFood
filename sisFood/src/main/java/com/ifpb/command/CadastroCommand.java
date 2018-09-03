/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.UsuarioManager;
import com.ifpb.model.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jonas
 */
public class CadastroCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        UsuarioManager usuarioMeManager = new UsuarioManager();
        Usuario user = new Usuario();
        
        user.setNome(request.getParameter("nome"));
        user.setEmail(request.getParameter("email"));
        user.setProfissao(request.getParameter("profissao"));
        user.setFone(request.getParameter("fone"));
        user.setDescricao(request.getParameter("descricao"));
        user.setSenha(request.getParameter("senha"));
        user.setCidade(request.getParameter("cidade"));
        user.setRua(request.getParameter("rua"));
        user.setCep(request.getParameter("cep"));
        user.setEstado(request.getParameter("estado"));
        user.setSexo(request.getParameter("sexo"));        
        user.setFotoPerfil(request.getParameter("foto"));
        
        if(usuarioMeManager.cadastra(user)) {
             response.setStatus(200);
             response.sendRedirect("login.jsp");   
            
        }else{
             response.setStatus(404);
             response.sendRedirect("erro.jsp?erro");
        }
        
        
        
    }
    
    
}

