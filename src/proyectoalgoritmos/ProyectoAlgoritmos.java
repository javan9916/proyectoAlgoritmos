/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rsoli
 */
public class ProyectoAlgoritmos {
    
    public static Grafo g;
    public static ArrayList<Vertice> verticesLocales;
    public static ArrayList<Arco> arcosLocales;
    public static int vertices;
    public static int arcos;
    public static int [][] matrizAdy;
    public static int [][] matriz5 = {{0,1,0,0,0},{1,0,1,1,0},{0,1,0,0,0},{0,1,0,0,1},{0,0,0,1,0}};
    
    public static int [][] matriz10 = { {0,0,1,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0},
                                        {1,1,0,1,0,1,0,0,0,0},{0,0,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,1,1,0,0},{0,0,1,0,1,0,0,0,1,0},
                                        {0,0,0,0,1,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,1,0,0,0,1},{0,0,0,0,0,0,0,0,1,0}};
    
    public static int [][] matriz20 = { {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0},};
    
    public static void main(String[] args) {
        menuTamano();
        printVerts();
    }
    
    public static void crearMatriz()
        {
            matrizAdy = new int[vertices][vertices];
            Random random = new Random();
            int cont = 0;

            if (vertices == 5)
            {
                matrizAdy = matriz5;
            }
            else if (vertices == 10)
            {
                matrizAdy = matriz10;
            }
            else if (vertices == 20)
            {
                matrizAdy = matriz20;
            }
            /*else
            {
                for (int i = 0; i < vertices; i++)
                {
                    for (int j = 0; j < vertices; j++)
                    {
                        if (i < j && (i + 1) == j)
                        {
                            matrizAdy[i][j] = random.nextInt(1);
                            cont++;

                            if (i == 0 || i == (vertices / 2) - 2 || i == (vertices / 2) + 2)
                            {
                                matrizAdy[i][vertices - 1] = random.nextInt(1);
                                cont++;
                            }
                        }
                    }
                }

                while (cont < arcos - 2)
                {
                    for (int i = 0; i < vertices; i++)
                    {
                        int limite = 1;
                        if (i <= vertices - 3 && limite <= 2)
                        {
                            int j = 1;
                            //int j = random.nextInt(2 + i, vertices - 1);
                            if (matrizAdy[i][j] == 0 && i + 2 <= j)
                            {
                                matrizAdy[i][j] = random.nextInt(20);
                                limite++;
                                cont++;
                            }
                        }
                    }
                }
            } */

            /*for (int i = 0; i < vertices; i++)
            {
                for (int j = 0; j < vertices; j++)
                {
                    Console.Write(string.Format("{0} ", matrizAdy[i, j]));
                }
                Console.Write(Environment.NewLine + Environment.NewLine);
            }*/

            llenarGrafo();
        }
    
    public static void llenarGrafo() {
        g = new Grafo();
        verticesLocales = new ArrayList<>();
        arcosLocales = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < vertices; i++) {
            Vertice nuevo = new Vertice(Integer.toString(i), false, false, random.nextInt(50));
            g.addVertice(nuevo);
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdy[i][j] != 0) {
                    Vertice origen = g.buscarVerticeGrafo(i);
                    Vertice destino = g.buscarVerticeGrafo(j);
                    
                    if (origen != null && destino != null)
                        arcosLocales.add(new Arco(origen, destino, 0, false));
                    
                    origen.addArco(new Arco(origen, destino, 0, false));
                }
            }
        }
    }
    
    public static void printVerts() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(g.getVertices().get(i).getBeneficio());
        }
    }
    
    public static void menuTamano(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tamaño del grafo que desea realizar:\n"
                + "1) 5 vertices\n"
                + "2) 10 vertices\n"
                + "3) 20 vertices\n"
                + "4) 30 vertices\n"
                + "5) 50 vertices\n");
        System.out.print("Opción: ");
        String option = scanner.next();
        switch(option){
            case "1":
                System.out.println("Ha seleccionado la opción 1.");
                vertices = 5;
                crearMatriz();
                break;
            case "2":
                System.out.println("Ha seleccionado la opción 2.");
                vertices = 10;
                break;
            case "3":
                System.out.println("Ha seleccionado la opción 3.");
                vertices = 20;
                break;
            case "4":
                System.out.println("Ha seleccionado la opción 4.");
                break;
            case "5":
                System.out.println("Ha seleccionado la opción 5.");
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuTamano();
                break;
        }
    }
    
}
