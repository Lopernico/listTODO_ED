/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Luis Aguilar, Victor González
 * @version IDE 17
 */
public class Task implements Comparable<Task> {
    // ATRIBUTOS
 
    public Task siguiente;
    public int prioridad, posicion;
    public Date venceF;
    public LocalDateTime añadidaF ;
    public String descripcion, titulo;
    public boolean done;

   // CONSTRUCTORES
    /**
     * Constructor que inicializa los atributos de la clase
    * @param prioridad
     * @param posicion
     * @param venceF
     * @param descripcion
     * @param titulo 
     */
    //cambiar fecha de vencimiento para que sea agregada por el usuario
   public Task(int prioridad,int posicion, Date venceF, String descripcion, String titulo) {
        LocalDateTime now = LocalDateTime.now();  
        this.prioridad = prioridad;
        this.añadidaF = now;
        this.venceF = venceF;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.done = false;
        this.posicion=posicion;
    }

 public Task getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Task siguiente) {
        this.siguiente = siguiente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public LocalDateTime getAñadidaF() {
        return añadidaF;
    }

    public void setAñadidaF(LocalDateTime añadidaF) {
        this.añadidaF = añadidaF;
    }

    public Date getVenceF() {
        return venceF;
    }

    public void setVenceF(Date venceF) {
        this.venceF = venceF;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // MÉTODOS
    /**
     * Compara las tareas por su prioridad
     * @param otherTask
     * @return 
     */
   @Override
    public int compareTo(Task otherTask) {
        // Comparar tareas por fecha
        int dateComp = this.venceF.compareTo(otherTask.venceF);
        if (dateComp != 0){
            return dateComp;
        }
        // Comparar tareas por prioridad
        return Integer.compare(this.prioridad, otherTask.prioridad);
    }
    /**
     * Crea una cadena con los datos de la tarea
     * @return 
     */
    @Override
    public String toString() {
         return titulo;
    }
}