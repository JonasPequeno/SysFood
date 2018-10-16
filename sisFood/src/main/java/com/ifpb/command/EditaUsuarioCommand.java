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
public class EditaUsuarioCommand implements CommandIF{
   
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
       Object user = request.getSession().getAttribute("Usuario");
        Usuario usuario = (Usuario) (user);
        
        Usuario u = new Usuario();
        
        String nome = request.getParameter("nome");        
        u.setNome(request.getParameter("nome"));
        u.setCidade(request.getParameter("cidade"));
        u.setEstado(request.getParameter("estado"));
        u.setCep(request.getParameter("cep"));
        u.setRua(request.getParameter("rua"));
        u.setDescricao(request.getParameter("descricao"));
        u.setFone(request.getParameter("fone"));        
        u.setEmail(usuario.getEmail());
        final Part fotoPerfil = request.getPart("foto");
        
        
        
        UsuarioManager g = new UsuarioManager();
                      
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
                        
            u.setFotoPerfil(fotoBase64);
        
        g.editar(u);
        
        request.getSession().setAttribute("Usuario", u); 
        response.sendRedirect("home.jsp");

    }
    
}
