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
    Node head=null;
    public int size = 0;
    public boolean vacio = true;

    public LinkedList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
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

    // MÉTODOS
    /**
     * Método para añadir una tarea a la lista
     * @param task Tarea a añadir
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            vacio = false;
            size++;
            System.out.println("agregado");
              display();
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            System.out.println("agregado");
            display();
            current.next = newNode;
            vacio = false;
                    size++;
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
            size--;
            } else {
                prev.next = current.next;
                 size--;
            }
        }
    }
    
    /**
     * metodo que confirma si la lista se encuentra vacio
     * @return false si contiene elementos.
     */
     public boolean empty() {
        if (head == null) {
            vacio = true;
            return true;
        } else {
            vacio = false;
            return false;
        }
    }
    
     
     /**
      * busca una tarea en la lista segun la posicion que se indique
      * @param posicion posicion de la tarea en la lista
      * @return tarea con la posicion correspondiente
      */
      public Task buscarPorPosicion(int posicion) {
             Node temp ;
         temp = head;
for (int x = 0; x <= size; x++) {
    if(temp.task.getPosicion()!=posicion){
             temp= temp.getNext();
                }else{
                       return temp.task;
                        }
}
        return null;
    }
    
    /**
     * Método para mostrar la lista con todas las tareas que contiene
     */
    public String display() {
        Node temp ;
       String resultado ="->",tarea = "{";
        temp = head;
        if(temp!=null){
for (int x = 0; x <= size; x++) {
    tarea+="titulo ";
   tarea+=temp.task.getTitulo();
   tarea+=". descripcion ";
   tarea+=temp.task.getDescripcion();
    tarea+=". fecha anadida a la lista ";
   tarea+=temp.task.getAñadidaF().toString();
    tarea+=". prioridad de la tarea ";
  tarea+=temp.task.getPrioridad();
   tarea+=". fecha vencimiento de la tarea ";
   tarea+=temp.task.getVenceF().toString();
    tarea+=". posicion en la lista ";
  tarea+=temp.task.getPosicion();
    
 resultado+=("tarea "+temp.task.getPosicion()+" posicion en lista= "+(x+1)+" : "+tarea+"}, ");
    System.out.println(resultado);
 tarea= "{";
 if(temp.getNext()!=null){
       temp=temp.getNext();} 
} return resultado;
        }else{
            System.out.println("lista vacia");
       
        return resultado;
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