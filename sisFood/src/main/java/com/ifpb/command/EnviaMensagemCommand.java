package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Manager.MensagemManager;
import com.ifpb.model.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonas
 */
public class EnviaMensagemCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
                
        Object user = request.getSession().getAttribute("Usuario");
        Usuario usuario = (Usuario) (user);
        
        String m = request.getParameter("msg");
        String emailDes = request.getParameter("emailDes");
        
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = Date.valueOf(LocalDate.now());
        String hora = formatter.format(date);
        
        DateFormat formatter2 = new SimpleDateFormat("DD/mm/YYYY");
        Date d = Date.valueOf(LocalDate.now());
        String data = formatter.format(d);
        
        MensagemManager gerenciador = new MensagemManager();
        
        gerenciador.enviar(usuario.getEmail(), emailDes, data, hora, m );
        
        response.sendRedirect("enviaMensagem.jsp");
        
        
        
    }
    
}
