
package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.UsuarioManager;
import com.ifpb.model.Usuario;
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
                        
            try {
                usuarioLogado = usuarioManager.login(email, senha);
                System.out.println("Usuario logado" + usuarioLogado);
                HttpSession  session  = request.getSession();
                session.setAttribute("usuario", usuarioLogado);
                response.setStatus(200);
                response.sendRedirect("home.jsp");
            }
            catch(IOException e) {
                String erro = URLEncoder.encode(e.getMessage(), "utf-8");
                response.sendRedirect("home.jsp?erro"+erro);
            }          
        
        }
    
}
