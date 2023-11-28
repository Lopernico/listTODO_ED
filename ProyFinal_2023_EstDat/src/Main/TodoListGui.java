/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Functions.Task;
import Functions.TodoList;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

/**
 *
 * @author antho
 */
public class TodoListGui extends JFrame {
    // ATRIBUTOS
    private TodoList todoList;
    private DefaultListModel<Task> listModel;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa los paneles de la clase
     */
    public TodoListGui() {
        todoList = new TodoList();
        listModel = new DefaultListModel<>();
        JList<Task> taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setTransferHandler(new TaskTransferHandler());
        taskList.setDropMode(DropMode.INSERT);
        // Método para cambiar el nombre de la tarea haciendo doble click
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = taskList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Task selectedTask = listModel.get(selectedIndex);
                        String newTaskName = JOptionPane.showInputDialog("Edit Task", selectedTask.name);
                        if (newTaskName != null) {
                            selectedTask.name = newTaskName;
                        }
                    }
                }
            }
        });
        // Método que añade las tareas a la lista TODO
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        JTextField newTaskField = new JTextField(20);
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener((ActionEvent e) -> {
            String taskName = newTaskField.getText().trim();
            if (!taskName.isEmpty()) {
                Task newTask = new Task(taskName, new Date(), 0);
                todoList.addTask(newTask);
                listModel.addElement(newTask);
                newTaskField.setText("");
            }
        });
        // Método para eliminar las tareas de la lista
        JButton removeTaskButton = new JButton("Remove Task");
        removeTaskButton.addActionListener((ActionEvent e) -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                Task selectedTask = listModel.get(selectedIndex);
                todoList.removeTask(selectedTask);
                listModel.remove(selectedIndex);
            }
        });
        // Método para mezclar la lista con el algoritmo quicksort
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener((ActionEvent e) -> {
            todoList.quickSort();
        });
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(newTaskField);
        panel.add(addTaskButton);
        panel.add(removeTaskButton);
        panel.add(sortButton);
        add(panel);
        setTitle("TODO List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // CLASES
    /**
     * Clase para manejar los transfers de las tareas
     */
    private class TaskTransferHandler extends TransferHandler {
        // MÉTODOS
        /**
         * Método para obtener las acciones de manejador
         * @param c
         * @return 
         */
        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.MOVE;
        }
        /**
         * Método para crear un transferible con la lista de las tareas
         * @param c
         * @return 
         */
        @Override
        protected Transferable createTransferable(JComponent c) {
            JList<Task> list = (JList<Task>) c;
            Task selectedTask = list.getSelectedValue();
            if (selectedTask != null) {
                return new TaskTransferable(selectedTask);
            }
            return null;
        }
        /**
         * Verifica si se puede importar una tarea
         * @param support Soporte
         * @return True en caso que si pueda, false en caso contrario
         */
        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(TaskFlavor.getInstance());
        }
        /**
         * Verifica si se puede importar los datos de la tarea
         * @param support Soporte
         * @return True en caso que si pueda, false en caso contrario
         */
        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }
            JList.DropLocation dl = (JList.DropLocation) 
                    support.getDropLocation();
            int index = dl.getIndex();
            try {
                Task dT = (Task) support.getTransferable().
                        getTransferData(TaskFlavor.getInstance());
                if (index != -1 && index != listModel.indexOf(dT)) {
                    listModel.removeElement(dT);
                    listModel.add(index, dT);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
    /**
     * Clase que maneja las tareas transferibles
     */
    private class TaskTransferable implements Transferable {
        // ATRIBUTOS
        private Task task;
        
        // CONSTRUCTORES
        /**
         * Constructor que inicializa la tarea
         * @param task 
         */
        public TaskTransferable(Task task) {
            this.task = task;
        }
        
        // MÉTODOS
        /**
         * Método que consigue los datos de flavor de transferencias
         * @return El arreglo de los datos de flavor de transferencias
         */
        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{TaskFlavor.getInstance()};
        }
        /**
         * Verifica si el dato se soportado
         * @param flavor Dato a verificar
         * @return True en caso que si pueda, false en caso contrario
         */
        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(TaskFlavor.getInstance());
        }
        /**
         * Obtiene los datos de transferencia
         * @param flavor Datos a obtener
         * @return La tarea obtenida
         */
        @Override
        public Object getTransferData(DataFlavor flavor) {
            if (isDataFlavorSupported(flavor)) {
                return task;
            }
            return null;
        }
    }
    /**
     * Clase que maneja los flavors de cada tarea
     */
    private static class TaskFlavor extends DataFlavor {
        // ATRIBUTOS
        private static final TaskFlavor instance = new TaskFlavor();
        
        // CONSTRUCTORES
        /**
         * Constructor por defecto
         */
        private TaskFlavor() {
            super(Task.class, "Task");
        }
        
        // MÉTODOS
        /**
         * Método Singleton
         * @return 
         */
        public static TaskFlavor getInstance() {
            return instance;
        }
    }
    
    // MÉTODOS
    /**
     * Método MAIN
     * @param args 
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoListGui::new);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}