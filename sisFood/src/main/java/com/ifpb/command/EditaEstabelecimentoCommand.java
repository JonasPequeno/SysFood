/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.command;

import com.ifpb.infra.FileManagement;
import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Estabelecimento;
import com.ifpb.model.Manager.EstabelecimentoManager;
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
public class EditaEstabelecimentoCommand  implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        Estabelecimento estabelecimento = new Estabelecimento();
        EstabelecimentoManager gerenciador = new EstabelecimentoManager();
        
        Object user = request.getSession().getAttribute("Usuario");
        Usuario usuario = (Usuario) (user);
        
        String nome = request.getParameter("nome");
        estabelecimento.setId(Integer.parseInt(request.getParameter("id")));
        estabelecimento.setNome(request.getParameter("nome"));
        estabelecimento.setCidade(request.getParameter("cidade"));
        estabelecimento.setEstado(request.getParameter("estado"));
        estabelecimento.setCep(request.getParameter("cep"));
        estabelecimento.setRua(request.getParameter("rua"));
        estabelecimento.setDescricao(request.getParameter("descricao"));
        estabelecimento.setFone(request.getParameter("telefone"));
        estabelecimento.setTipo(request.getParameter("tipo"));
        estabelecimento.setNumero( Integer.parseInt(request.getParameter("numero")));
        estabelecimento.setUserAdd(usuario.getEmail());
        
        System.out.println("Estabelecimento editardo :" + estabelecimento.toString());
                
        final Part fotoPerfil = request.getPart("foto");
        
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
            
            
            
            estabelecimento.setFoto(fotoBase64);
            
        gerenciador.editar(usuario.getEmail(), estabelecimento);                    
        response.sendRedirect("meusEstabelecimentos.jsp");
        
    }
    
    
}
