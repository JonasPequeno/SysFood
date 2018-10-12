package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonas
 */
public class SairCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        HttpSession sessao = request.getSession();
        
        sessao.invalidate();
        
        response.sendRedirect("login.jsp");
    }
    
}
