/*ç+' * To change this license header, choose License Headers in Project Properties.
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
    public static int [][] matrizAdy;
    
    public static int [][] matriz5C = { {1,1,1,1,1},
                                        {1,0,1,1,1},
                                        {1,1,0,1,1},
                                        {1,1,1,0,1},
                                        {1,1,1,1,0}};
    
    public static int [][] matriz5 =   {{0,1,0,0,0},
                                        {1,0,1,1,0},
                                        {0,1,0,0,0},
                                        {0,1,0,0,1},
                                        {0,0,0,1,0}};
    
    public static int [][] matriz10 = { {0,0,1,0,0,0,0,0,0,0},
                                        {0,0,1,0,0,0,0,0,0,0},
                                        {1,1,0,1,0,1,0,0,0,0},
                                        {0,0,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,1,1,0,0},
                                        {0,0,1,0,1,0,0,0,1,0},
                                        {0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,1,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,1,0}};
    
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
    
    public static int [][] matriz30 = { {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}};
    
    public static int [][] matriz50 = { {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}};
    
    
    public static void main(String[] args) {
        menuAlgoritmo();
        printVerts();
    }
    
    public static void menuAlgoritmo(){
        System.out.println("\n"
                + "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algoritmos:\n"
                + "1) Algoritmo A\n"
                + "2) Algoritmo B\n"
                + "3) Algoritmo C\n"
                + "4) Algoritmo D\n");
        System.out.print("Opción: ");
        String option = scanner.next();
        switch(option){
            case "1":
                System.out.println("Ha seleccionado el algorimo A.");
                menuTamano("a");
                break;
            case "2":
                System.out.println("Ha seleccionado el algorimo B.");
                menuTamano("b");
                break;
            case "3":
                System.out.println("Ha seleccionado el algorimo C.");
                menuTamano("c");
                break;
            case "4":
                System.out.println("Ha seleccionado el algorimo D.");
                menuTamano("d");
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuAlgoritmo();
                break;
        }
    }
    
    public static void menuTamano(String algoritmo){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tamaño del grafo que desea realizar:\n"
                + "1) 5 vertices\n"
                + "2) 10 vertices\n"
                + "3) 20 vertices\n"
                + "4) 30 vertices\n"
                + "5) 50 vertices\n");
        System.out.print("Opción: ");
        String option = scanner.next();
        if (!algoritmo.equals("d")) {
           switch(option){
            case "1":
                System.out.println("Ha seleccionado la opción 1.");
                vertices = 5;
                crearMatriz1(algoritmo);
                break;
            case "2":
                System.out.println("Ha seleccionado la opción 2.");
                vertices = 10;
                crearMatriz1(algoritmo);
                break;
            case "3":
                System.out.println("Ha seleccionado la opción 3.");
                vertices = 20;
                crearMatriz1(algoritmo);
                break;
            case "4":
                System.out.println("Ha seleccionado la opción 4.");
                vertices = 30;
                crearMatriz1(algoritmo);
                break;
            case "5":
                System.out.println("Ha seleccionado la opción 5.");
                vertices = 50;
                crearMatriz1(algoritmo);
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opcción válida.");
                menuTamano(algoritmo);
                break;
            } 
        } else {
            switch(option){
            case "1":
                System.out.println("Ha seleccionado la opción 1.");
                vertices = 5;
                crearMatriz2(algoritmo);
                break;
            case "2":
                System.out.println("Ha seleccionado la opción 2.");
                vertices = 10;
                crearMatriz2(algoritmo);
                break;
            case "3":
                System.out.println("Ha seleccionado la opción 3.");
                vertices = 20;
                crearMatriz2(algoritmo);
                break;
            case "4":
                System.out.println("Ha seleccionado la opción 4.");
                vertices = 30;
                crearMatriz2(algoritmo);
                break;
            case "5":
                System.out.println("Ha seleccionado la opción 5.");
                vertices = 50;
                crearMatriz2(algoritmo);
                break;
            default: 
                System.out.println("Elección inválida, por favor seleccione una opción válida.");
                menuTamano(algoritmo);
                break;
            }
        }
    }
    
    public static void crearMatriz1(String algoritmo){
        matrizAdy = new int[vertices][vertices];
        Random random = new Random();
        int cont = 0;

        switch (vertices) {
            case 5:
                matrizAdy = matriz5;
                break;
            case 10:
                matrizAdy = matriz10;
                break;
            case 20:
                matrizAdy = matriz20;
                break;
            case 30:
                matrizAdy = matriz30;
                break;
            case 50:
                matrizAdy = matriz50;
                break;
            default:
                break;
        }

        llenarGrafo(algoritmo);
    }
    
    public static void crearMatriz2(String algoritmo){
        matrizAdy = new int[vertices][vertices];
        Random random = new Random();
        int cont = 0;

        if (vertices == 5) {
            matrizAdy = matriz5C;
        } else {
            
        }

        llenarGrafo(algoritmo);
    }
    
    public static void llenarGrafo(String algoritmo) {
        g = new Grafo();
        verticesLocales = new ArrayList<>();
        arcosLocales = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < vertices; i++) {
            Vertice nuevo = new Vertice(Integer.toString(i), false, random.nextInt(50)+1);
            g.addVertice(nuevo);
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdy[i][j] != 0) {
                    Vertice origen = g.buscarVerticeGrafo(Integer.toString(i));
                    Vertice destino = g.buscarVerticeGrafo(Integer.toString(j));
                    
                    if (origen != null && destino != null)
                        arcosLocales.add(new Arco(origen, destino, false));
                    
                    origen.addArco(new Arco(origen, destino, false));
                }
            }
        }
        
        switch(algoritmo){
            case "a":
                algoritmoA();
                break;
            case "b":
                algoritmoB();
                break;
            case "c":
                algoritmoC();
                break;
            case "d":
                algoritmoD();
                break;
            default:
                break;
        }
    }
    
    public static void printVerts() {
        System.out.print("Beneficios: ");
        for (int i = 0; i < vertices; i++) {
            if (g.getVertices().get(i) != null) {
                System.out.print(g.getVertices().get(i).getBeneficio()+ ", ");
            }
        }
        System.out.println("");
        
        menuAlgoritmo();
    }
    
    public static void imprimirGrafo(Grafo u) {
        if (u != null) {
            System.out.print("Vertices de U: ");
            for (int i = 0; i < u.getVertices().size(); i++) {
                System.out.print(u.getVertices().get(i).getVertice() + ", ");
            }

            int beneficio = 0;
            for (int i = 0; i < u.getVertices().size(); i++) {
                beneficio += u.getVertices().get(i).getBeneficio();
            }
            System.out.println("");
            System.out.println("Beneficio Total: " + beneficio);
        }
    }
    
    // ------------------------* Algoritmo A *------------------------
    
    public static void algoritmoA() {
        Grafo u = new Grafo();
        Vertice mayor = getMayorBeneficio();
        
        while (mayor.getBeneficio() != 0) {
            u.addVertice(mayor);
            mayor = getMayorBeneficio();
        }
        
        imprimirGrafo(u);
        menuAlgoritmo();
    }
    
    public static Vertice getMayorBeneficio() {
        ArrayList<Vertice> v = g.getVertices();
        Vertice mayor = new Vertice("", false, 0);

        for (int i = 0; i < v.size(); i++) {
            if (!v.get(i).getUsed()) {
                if (mayor.getBeneficio() < v.get(i).getBeneficio()) {
                    mayor = v.get(i);
                }
            }
        }
        mayor.setUsed(true);
        if (mayor.getBeneficio() != 0) {
            marcarAdyacentes(mayor);
        }

        return mayor;
    }

    public static void marcarAdyacentes(Vertice v) {
        ArrayList<Arco> arcos = v.getArcos();
        for (int i = 0; i < arcos.size(); i++) {
            g.buscarVerticeGrafo(arcos.get(i).getDestino().getVertice()).setUsed(true);
        }
    }
    
    // ------------------------* Algoritmo B *------------------------
    
    public static void algoritmoB(){
        Grafo u = new Grafo();
        
        while (!g.verificarUsados()) {
            etapa(u);
        }
        
        imprimirGrafo(u);
        menuAlgoritmo();
    }
    
    public static void etapa(Grafo u) {
        int[] diferencias = new int[vertices];
        int peso;
        int diferencia;
        int beneficio;
        
        for (int i = 0; i < vertices; i++) {
            if (!g.vertices.get(i).getUsed()) {
                beneficio = g.vertices.get(i).getBeneficio();
                ArrayList<Arco> adyacentes = g.vertices.get(i).getArcos();
                peso = 0;

                for (int j = 0; j < adyacentes.size(); j++) {
                    if (!adyacentes.get(j).getDestino().getUsed()) {
                        peso += adyacentes.get(j).getDestino().getBeneficio();
                    }
                }

                diferencia = beneficio - peso;
                diferencias[i] = diferencia;
            }
        }
        
        int mayor = diferencias[obtenerPrimerMayor()];
        int index = 0;
        for (int i = 0; i < vertices; i++) {
            if (!g.buscarVerticeGrafo(Integer.toString(i)).getUsed()) {
                if (diferencias[i] > mayor) {
                    mayor = diferencias[i];
                    index = i;
                }
            } 
        }
        
        Vertice v = g.buscarVerticeGrafo(Integer.toString(index));
        v.setUsed(true);
        marcarAdyacentes(v);
        ArrayList<Vertice> sueltos = g.buscarVerticesSueltos();
        
        u.addVertice(v);
        if (!sueltos.isEmpty()) {
            for (int i = 0; i < sueltos.size(); i++) {
                sueltos.get(i).setUsed(true);
                u.addVertice(sueltos.get(i));
            }
        }
    }
    
    public static int obtenerPrimerMayor() {
        for (int i = 0; i < g.vertices.size(); i++) {
            if (!g.vertices.get(i).getUsed()) {
                return i;
            }
        }
        return 0;
    }
    
    // ------------------------* Algoritmo C *------------------------
    
    public static void algoritmoC(){
        ArrayList<Vertice> vertices = g.getVertices();
        ArrayList<Vertice> selected = new ArrayList();
        
        Vertice mayor = getMayorAbyacentes();
        while(mayor != null){
            System.out.println(mayor.getVertice());
            g.marcarVertice(mayor);
            addSelected(selected);
            mayor = getMayorAbyacentes();
        }
        
        System.out.println("Los locales con mayor numero de ubicaciones son:");
        int benetotal = 0;
        for(int i = 0; i < selected.size(); i++){
            System.out.print(selected.get(i).getVertice() + ", ");
            benetotal += selected.get(i).getBeneficio();
        }
        System.out.println("El beneficio total de esta seleccion es: " + benetotal);
    }
    
    public static void addSelected(ArrayList<Vertice> selected){
        ArrayList<Vertice> vertices = g.getVertices();
        for(int i = 0; i < vertices.size(); i++){
            if(!vertices.get(i).getUsed()){
                if(vertices.get(i).getArcosActivos() == 0){
                    g.marcarVertice(vertices.get(i));
                    selected.add(vertices.get(i));
                }
            }
        }
    }
    
    public static Vertice getMayorAbyacentes(){
        ArrayList<Vertice> vertices = g.getVertices();
        int mayorA = 0;
        Vertice mayorV = null;
        for(int i = 0; i < vertices.size(); i++){
            if(!vertices.get(i).getUsed()){
                int totales = vertices.get(i).getArcosActivos();
                if(totales > mayorA){
                    mayorA = totales;
                    mayorV = vertices.get(i);
                }
            }    
        }
        return mayorV;
    }
    
    // ------------------------* Algoritmo D *------------------------
    
    public static void algoritmoD() {
        ArrayList<Vertice> used = new ArrayList();
        ArrayList<Vertice> vertices = g.getVertices();
        Vertice next = getMayorBeneficioBack(vertices, used);
        ArrayList<Vertice> solucion = new ArrayList();
        ArrayList<Vertice> combinacion = new ArrayList();
        
        ArrayList<Vertice> resultado = backtracking(used, vertices, next, 0, solucion, combinacion);
        
        System.out.println("Los vertices seleccionados  para el algoritmo son: ");
        for(int i = 0; i < resultado.size(); i++){
            System.out.print(resultado.get(i).getVertice()+ ", ");
        }
        System.out.println("");
        System.out.println("Peso total del grafo: " + sumarpesovertices(resultado));
        
        menuAlgoritmo();
    }
    
    public static ArrayList<Vertice> backtracking(ArrayList<Vertice> used, ArrayList<Vertice> vertices, Vertice vertice, int max, ArrayList<Vertice> solucion, ArrayList<Vertice> combinacion){
        System.out.println("Combinacion: ");
        for(Vertice vert : combinacion){
            System.out.print(vert.getVertice());
        }
        System.out.println("");
        
        if(vertice == null){
            return solucion;
        }
        
        used.add(vertice);
        vertices.remove(vertice);
        vertices = marcarAdyacentesBackV(vertices, vertice);
        used = marcarAdyacentesBackU(used, vertice);
        
        combinacion.add(vertice);
        if(sumarpesovertices(combinacion) > max){
            solucion = combinacion;
            max = sumarpesovertices(combinacion);
            Vertice next = getMayorBeneficioBack(vertices, used);
            return backtracking(used, vertices, next, max, solucion, combinacion);
        }else{
            Vertice next = getMayorBeneficioBack(vertices, used);
            return backtracking(used, vertices, next, max, solucion, combinacion);
        }
    }
    
    public static int sumarpesovertices(ArrayList<Vertice> vertices){
        int total = 0;
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i) != null){
                total += vertices.get(i).getBeneficio();
            }
        }
        return total;
    }
    
    public static Vertice getMayorBeneficioBack(ArrayList<Vertice> vertices, ArrayList<Vertice> used){
        int maxB = 0;
        Vertice maxV = null;
        
        for(int i = 0; i < vertices.size(); i++){
            if(!used.contains(vertices.get(i))){
                if(vertices.get(i).getBeneficio() > maxB){
                    maxB = vertices.get(i).getBeneficio();
                    maxV = vertices.get(i);
                }
            }
        }
        return maxV;
    }
    
    public static ArrayList<Vertice> marcarAdyacentesBackU(ArrayList<Vertice> used, Vertice vertice){
        ArrayList<Arco> arcos = vertice.getArcos();
        
        for(int i = 0; i < arcos.size(); i++){
            Vertice objetivo = arcos.get(i).getDestino();
            if(!used.contains(objetivo)){
                used.add(objetivo);
            }
        }
        
        return used;
    }
    
    public static ArrayList<Vertice> marcarAdyacentesBackV(ArrayList<Vertice> vertices, Vertice vertice){
        ArrayList<Arco> arcos = vertice.getArcos();
        
        for(int i = 0; i < arcos.size(); i++){
            Vertice objetivo = arcos.get(i).getDestino();
            if(vertices.contains(objetivo)){
                vertices.remove(objetivo);
            }
        }
        
        return vertices;
    }
        
}
