/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 * @author Luis Aguilar, Victor González
 * @version IDE 17
 */
public class TodoList {
    // ATRIBUTOS
    public LinkedList linkedList;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una lista enlazada
     */
    public TodoList() {
        linkedList = new LinkedList();
    }

    // MÉTODOS
    /**
     * Método que añade una tarea a la lista TODO
     * @param task Tarea a añadir
     */
    public void addTask(Task task) {
        linkedList.addTask(task);
    }
    /**
     * Método que remueve una tarea de la lista TODO
     * @param task Tarea a remover
     */
    public void removeTask(Task task) {
        linkedList.removeTask(task);
    }
    /**
     * metodos para actualizar o reordenar tareas segun el criterio especificado
     */
    public void actualizarX(){
        
    }
    /**
     * Método que muestra la lista TODO con todas sus tareas
     */
    public void display() {
        linkedList.display();
    }
    /**
     * Método que ordena la lista TODO por quickSort
     */
    public void quickSort(){
        linkedList.quickSort();
    }
}