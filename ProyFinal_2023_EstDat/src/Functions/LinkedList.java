/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 * @author Luis Aguilar, Victor González
 * @version IDE 17
 */
public class LinkedList {
    // ATRIBUTOS
    Node head;

    // MÉTODOS
    /**
     * Método para añadir una tarea a la lista
     * @param task Tarea a añadir
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    /**
     * Método para remover una tarea de la lista
     * @param task Tarea a remover
     */
    public void removeTask(Task task) {
        Node current = head;
        Node prev = null;
        while (current != null && current.task != task) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }
    /**
     * Método para mostrar la lista con todas las tareas que contiene
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Task: " + current.task.name + ", Due Date: " + 
                    current.task.dueDate + ", Priority: " + 
                    current.task.priority);
            current = current.next;
        }
    }
    /**
     * Método de ordenamiento para la lista enlazada utilizando Quicksort
     */
    public void quickSort() {
        head = quickSortRec(head);
    }
    /**
     * Método auxiliar para Quicksort
     * @param node
     * @return 
     */
    private Node quickSortRec(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Task pivotTask = node.task;
        Node less = null;
        Node equal = null;
        Node greater = null;
        Node current = node;
        while (current != null) {
            if (current.task.compareTo(pivotTask) < 0) {
                less = addToEnd(less, current.task);
            } else if (current.task.compareTo(pivotTask) == 0) {
                equal = addToEnd(equal, current.task);
            } else {
                greater = addToEnd(greater, current.task);
            }
            current = current.next;
        }
        less = quickSortRec(less);
        greater = quickSortRec(greater);
        return concatenate(less, equal, greater);
    }
    /**
     * Método auxiliar para agregar un elemento al final de una lista
     * @param list
     * @param data
     * @return 
     */
    private Node addToEnd(Node list, Task data) {
        Node newNode = new Node(data);
        if (list == null) {
            return newNode;
        }
        Node current = list;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return list;
    }
    /**
     * Método auxiliar para concatenar tres listas
     * @param less
     * @param equal
     * @param greater
     * @return 
     */
    private Node concatenate(Node less, Node equal, Node greater) {
        Node result = less;
        Node lessTail = getTail(less);
        if (lessTail != null) {
            lessTail.next = equal;
        } else {
            result = equal;
        }
        Node equalTail = getTail(equal);
        if (equalTail != null) {
            equalTail.next = greater;
        }
        return result;
    }
    /**
     * Método auxiliar para obtener la cola de una lista
     * @param list
     * @return 
     */
    private Node getTail(Node list) {
        if (list == null) {
            return null;
        }
        Node current = list;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}