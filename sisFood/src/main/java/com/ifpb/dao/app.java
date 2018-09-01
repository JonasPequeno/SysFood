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
   
        SeguirDao dao = new SeguirDao();
        
        dao.aceitarAmizade("Jonas@gmail.com", "Irineu@gmail.com");
    }
}
