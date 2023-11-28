/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.util.Date;

/**
 * @author Luis Aguilar, Victor González
 * @version IDE 17
 */
public class Task implements Comparable<Task> {
    // ATRIBUTOS
    public String name;
    public Date dueDate;
    public int priority;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa los atributos de la clase
     * @param name Nombre de la tarea
     * @param dueDate Fecha de la tarea
     * @param priority Prioridad de la tarea
     */
    public Task(String name, Date dueDate, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
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
        int dateComp = this.dueDate.compareTo(otherTask.dueDate);
        if (dateComp != 0){
            return dateComp;
        }
        // Comparar tareas por prioridad
        return Integer.compare(this.priority, otherTask.priority);
    }
    /**
     * Crea una cadena con los datos de la tarea
     * @return 
     */
    @Override
    public String toString() {
        return name;
    }
}