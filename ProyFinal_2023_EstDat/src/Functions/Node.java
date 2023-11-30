/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 * @author Luis Aguilar, Victor González
 * @version IDE 17
 */
public class Node {
    // ATRIBUTOS
    Task task;
    Node next;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una tarea como un nodo
     * @param task Tarea a convertir en nodo
     */
    public Node (Task task){
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
