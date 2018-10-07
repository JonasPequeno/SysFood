/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.infra.FileManagement;
import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.UsuarioManager;
import com.ifpb.model.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
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
        final Part fotoPerfil = request.getPart("foto");
        System.out.println("Foto :" + fotoPerfil);

            OutputStream out = null;
            InputStream filecontent = null;

            try {
                out = new FileOutputStream(new File("./" + File.separator
                        + fotoPerfil.hashCode()));
                filecontent = fotoPerfil.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }

            File foto = new File("./" + File.separator
                    + fotoPerfil.hashCode());

            String fotoBase64 = FileManagement.encodeFile(foto);
            System.out.println("Foto base64" + fotoBase64);
            user.setFotoPerfil(fotoBase64);
            
            if(usuarioMeManager.inserir(user)) {
                response.sendRedirect("login.jsp");                
            }
            
            
               
    }
    
    
}

