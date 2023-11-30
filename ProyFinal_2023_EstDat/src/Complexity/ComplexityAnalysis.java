/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complexity;

/**
 *Destinada al análisis y reporte de la complejidad algorítmica 
de las operaciones realizadas en las clases anteriores.
 * @author Victor y Luis
 */
public class ComplexityAnalysis {
    // MÉTODOS
    /**
     * Analiza la complejidad del sistema de manera linear
     * @param n 
     */
    public void analyzeLinear(int n) {
        // Análisis de tiempo lineal O(n)
        System.out.println("Análisis de bucle lineal:");
        // Tiempo
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            // Lógica del algoritmo
            System.out.println("Iteración " + i);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " 
                + elapsedTime + " nanosegundos");
        // Espacio
        System.out.println("Análisis de espacio: "
                + "Se asume espacio constante O(1)\n");
    }
    /**
     * Analiza la complejidad del sistema de manera cuadrática
     * @param n 
     */
    public void analyzeQuadratic(int n) {
        // Análisis de tiempo cuadrático O(n^2)
        System.out.println("Análisis de bucle anidado cuadrático:");
        // Tiempo
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Lógica del algoritmo
                System.out.println("Iteración " + i + "," + j);
            }
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " 
                + elapsedTime + " nanosegundos");
        // Espacio
        System.out.println("Análisis de espacio: "
                + "Se asume espacio constante O(1)\n");
    }
}