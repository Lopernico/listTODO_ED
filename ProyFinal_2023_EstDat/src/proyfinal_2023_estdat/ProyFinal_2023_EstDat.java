/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyfinal_2023_estdat;

import ListLinked.LinkedList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Date;
/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class ProyFinal_2023_EstDat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        LocalDateTime now=LocalDateTime.now();
       LinkedList lista=new LinkedList();
      
       lista.insertar(1, 1, now, "popo", "popis");
        System.out.println("lista vacia? "+lista.empty());
     
       
    lista.imprimirLista();
    lista.imprimirTarea(lista.buscarPorPosicion(1));
    lista.quitar(1);
        lista.imprimirLista();
    
            
    }
    
}
