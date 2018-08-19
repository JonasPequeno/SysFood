package com.ifpb.dao;

import com.ifpb.model.Comida;
import com.ifpb.model.Estabelecimento;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jonaspeuqno
 * 
 */
public class app {
    
    public static void main(String[] args) {
        
       ComidaDao dao = new ComidaDao();
       Comida c = new Comida(1,"Carne de Sol", 12.2, "Carne de sol ao molho, com batata frita");
       dao.remover(c);
    
   
    }
}
