/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListLinked;

import java.time.LocalDateTime;
import java.util.InputMismatchException;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class LinkedList {

    public int size = 0;
    public boolean vacio = true;
    public Task cabeza = null, temp = null;

    public LinkedList() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public Task getCabeza() {
        return cabeza;
    }

    public void setCabeza(Task cabeza) {
        this.cabeza = cabeza;
    }

    public Task getTemp() {
        return temp;
    }

    public void setTemp(Task temp) {
        this.temp = temp;
    }

    public void insertar(int prioridad, int posicion, LocalDateTime venceF, String descripcion, String titulo) {
        Task tareaNueva = new Task(prioridad, posicion, venceF, descripcion, titulo);

        if (vacio == true) {
            this.cabeza = tareaNueva;
            vacio = false;
            size++;
        } else {
            temp = cabeza;
            for (int x = 0; x <= size; x++) {
                if (temp.getSiguiente() == null) {
                    temp.setSiguiente(tareaNueva);
                    vacio = false;
                    size++;
                } else {
                    temp = temp.getSiguiente();
                }

            }
        }
    }

    public void quitar(int posicion) {
        temp = cabeza;
        Task ant = null;
        if(cabeza.getPosicion()==posicion){
        cabeza=null;
        }else{
                    
                    
        try {
            if (posicion > size) {
                System.out.println("esta tarea no existe");
            } else {
                for (int x = 0; x <= posicion; x++) {
                    ant = temp;
                    temp = temp.getSiguiente();
                }
                ant.setSiguiente(temp.getSiguiente());
                temp = null;
                size--;
            }
        } catch (InputMismatchException ex) {

        }
        }
    }

    public boolean empty() {
        if (cabeza == null) {
            vacio = true;
            return true;
        } else {
            vacio = false;
            return false;
        }
    }

    public int tamaño() {
        return size;
    }

    public Task buscarPorPosicion(int posicion) {
         temp = cabeza;
for (int x = 0; x <= size; x++) {
    if(temp.getPosicion()!=posicion){
             temp= temp.getSiguiente();
                }else{
                       return temp;
                        }
}
        return null;
    }

    public void ordernarPrioridad() {
 temp = cabeza;
for (int x = 0; x <= size; x++) {
}
    }

    public void ordernarVencimiento() {

    }
    public String imprimirLista(){
        String resultado ="->",tarea = "{";
        temp = cabeza;
        if(cabeza!=null){
for (int x = 0; x < size; x++) {
    tarea+="titulo ";
   tarea+=temp.getTitulo();
   tarea+=". descripcion ";
   tarea+=temp.getDescripcion();
    tarea+=". fecha anadida a la lista ";
   tarea+=temp.getAñadidaF().toString();
    tarea+=". prioridad de la tarea ";
  tarea+=temp.getPrioridad();
   tarea+=". fecha vencimiento de la tarea ";
   tarea+=temp.getVenceF().toString();
    tarea+=". posicion en la lista ";
  tarea+=temp.getPosicion();
    
 resultado+="tarea "+temp.getPosicion()+" posicion en lista= "+(x+1)+" : "+tarea+"}, ";
    System.out.println(resultado);
 tarea=null;
       temp=temp.getSiguiente(); 
} return resultado;
        }else{
            System.out.println("lista vacia");
       
        return resultado;
         }
    }
    public String imprimirTarea(Task temp){
         String resultado ="->",tarea = "{";
      tarea+="titulo ";
   tarea+=temp.getTitulo();
   tarea+=". descripcion ";
   tarea+=temp.getDescripcion();
    tarea+=". fecha anadida a la lista ";
   tarea+=temp.getAñadidaF().toString();
    tarea+=". prioridad de la tarea ";
  tarea+=temp.getPrioridad();
   tarea+=". fecha vencimiento de la tarea ";
   tarea+=temp.getVenceF().toString();
    tarea+=". posicion en la lista ";
  tarea+=temp.getPosicion();
    
 resultado+="tarea "+temp.getPosicion()+" posicion en lista= "+(temp.getPosicion())+" : "+tarea+"}, ";
    System.out.println(resultado);

        return resultado;
    }

}
