package com.ifpb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonaspeuqno
 */
public class Conexao {

    public static Connection getConnection() throws SQLException{
        Connection con = null;
        try {
            Class.forName("org.postgres.Driver");
            String url = "";
            String pass = "";
            String user = "";
            try{
               con = DriverManager.getConnection(url,user,pass);
            } catch(SQLException ex){    
                System.out.println("ERRO AO CONECTAR "+ ex.getMessage());
                return null;
            }            
        } catch (ClassNotFoundException ex) {
                System.out.println("ERRO AO CARREGAR O DRIVER "+ ex.getMessage());
                return null;
        }
        return con;
    } 
}
