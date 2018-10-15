package com.ifpb.command;

import com.ifpb.infra.FileManagement;
import com.ifpb.interfaces.CommandIF;
import com.ifpb.model.Estabelecimento;
import com.ifpb.model.Manager.EstabelecimentoManager;
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
public class CadastroEstabelecimentoCommand implements CommandIF{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
    
        Estabelecimento estabelecimento = new Estabelecimento();
        EstabelecimentoManager gerenciador = new EstabelecimentoManager();
        
        String emailUser = request.getParameter("email");
        
        
        estabelecimento.setNome(request.getParameter("nome"));
        estabelecimento.setCidade(request.getParameter("cidade"));
        estabelecimento.setEstado(request.getParameter("estado"));
        estabelecimento.setCep(request.getParameter("cep"));
        estabelecimento.setRua(request.getParameter("rua"));
        estabelecimento.setDescricao(request.getParameter("descricao"));
        estabelecimento.setFone(request.getParameter("telefone"));
        estabelecimento.setTipo(request.getParameter("tipo"));
        estabelecimento.setNumero( Integer.parseInt(request.getParameter("numero")));
                
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
            
            estabelecimento.setFoto(fotoBase64);
            
            System.out.println("Criado com sucesso " + estabelecimento.toString());
            gerenciador.inserir(emailUser, estabelecimento);
            
                       
            
    }
    
}
