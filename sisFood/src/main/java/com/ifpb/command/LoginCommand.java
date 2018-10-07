
package com.ifpb.command;

import com.ifpb.infra.FileManagement;
import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.UsuarioManager;
import com.ifpb.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonas
 */
public class LoginCommand implements CommandIF{
    
    public LoginCommand () {
                
    }
            
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ClassNotFoundException, IOException, ServletException{    
            Usuario usuarioLogado = new Usuario();
            
            UsuarioManager usuarioManager = new UsuarioManager();
            
            String email  = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            System.out.println("email e senha " +email +" "+senha);
            
            usuarioLogado = usuarioManager.login(email, senha);                       
            
                if(usuarioLogado.getEmail() != null ) {
                    File foto = FileManagement.decodeFile(usuarioLogado.getFotoPerfil());
                    System.out.println("foto" + foto);
                    System.out.println("Logado com sucesso!");
                    HttpSession  session  = request.getSession();
                    request.getSession().setAttribute("Usuario", usuarioLogado);                    
                    response.setStatus(200);
                    response.sendRedirect("home.jsp");   
                    
                }else {                    
                    response.setStatus(404);
                    response.sendRedirect("erro.jsp?erro");
            }
    }            
                
    
}
