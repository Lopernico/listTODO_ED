/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListLinked;

import java.time.LocalDateTime;


/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class Task {
    //atributos de las tareas en el todo list
    public Task siguiente;
    public int prioridad,posicion;
    public LocalDateTime añadidaF,venceF;
    public String descripcion,titulo;
    public boolean done;

    public Task(int prioridad,int posicion, LocalDateTime venceF, String descripcion, String titulo) {
        LocalDateTime now = LocalDateTime.now();  
        this.prioridad = prioridad;
        this.añadidaF = now;
        this.venceF = venceF;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.done = false;
        this.posicion=posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
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

    public LocalDateTime getAñadidaF() {
        return añadidaF;
    }

    public void setAñadidaF(LocalDateTime añadidaF) {
        this.añadidaF = añadidaF;
    }

    public LocalDateTime getVenceF() {
        return venceF;
    }

    public void setVenceF(LocalDateTime venceF) {
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
    
    
    
    
    
    
    
    
}
