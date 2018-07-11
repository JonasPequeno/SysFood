package com.ifpb.dao;

import com.ifpb.model.Comida;
import com.ifpb.model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jonaspeuqno
 */
public class app {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Comida> comidas = new ArrayList<>();
        ComidaDao cdao = new ComidaDao();
        Comida comida = new Comida("Carne", 10, 7, "Carne Muida");
        
        System.out.println("Digite o nome da Comida");
        String nome  =  s.next();
        int id;
        for(Comida c : cdao.listar()){
            if(c.getNome().equals(nome)){
               cdao.remover(c);
                
            }           
        }        
        
        
        
        
        
        
    }
}
