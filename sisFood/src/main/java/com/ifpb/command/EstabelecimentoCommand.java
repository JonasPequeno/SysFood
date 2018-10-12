
package com.ifpb.command;

import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Estabelecimento;
import com.ifpb.model.Manager.EstabelecimentoManager;
import com.ifpb.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonas
 */
public class EstabelecimentoCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        HttpSession sessao = request.getSession();
        
        EstabelecimentoManager gerenciador = new EstabelecimentoManager();
        Object user = request.getSession().getAttribute("Usuario");
        
        Usuario u =(Usuario) (user);
        System.out.println("Usuario" + u.getEmail());
        
        List<Estabelecimento> lista = new ArrayList<>();
                lista = gerenciador.getEstabelecimentosUsuario(u.getEmail());
        
                System.out.println("Lista" + lista.toString());
                
        request.getSession().setAttribute("listaEstabelecimento", lista);
        
        response.sendRedirect("teste.jsp");
        
    }
    
}
