/*ç+' * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author rsoli
 */
public class ProyectoAlgoritmos {
    
    public static int aA;
    public static int aB;
    public static int aC;
    public static int aD;
    public static int cA;
    public static int cB;
    public static int cC;
    public static int cD;
    public static int lA;
    public static int lB;
    public static int lC;
    public static int lD;
    
    public static Grafo g;
    public static ArrayList<Vertice> verticesLocales;
    public static ArrayList<Arco> arcosLocales;
    public static int vertices;
    public static int arcos;
    public static int [][] matrizAdy;
    
    public static int [][] matriz5C = { {1,1,1,1,1},
                                        {1,0,1,1,1},
                                        {1,1,0,1,1},
                                        {1,1,1,0,1},
                                        {1,1,1,1,0}};
    
    public static int [][] matriz10C = {{0,0,1,0,0,1,1,0,0,0},
                                        {0,0,1,0,0,0,0,0,0,0},
                                        {1,1,0,1,0,1,0,0,0,0},
                                        {0,0,1,0,0,0,1,0,1,0},
                                        {0,0,0,0,0,1,1,1,0,1},
                                        {1,0,1,0,1,0,0,0,1,0},
                                        {1,0,0,1,1,0,0,0,0,0},
                                        {0,0,0,0,1,0,0,0,1,0},
                                        {0,0,0,1,0,1,0,1,0,1},
                                        {0,0,0,0,1,0,0,0,1,0}};
    
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
                System.out.println("Ha seleccionado 5 vertices.");
                vertices = 5;
                crearMatriz1(algoritmo);
                break;
            case "2":
                System.out.println("Ha seleccionado 10 vertices.");
                vertices = 10;
                crearMatriz1(algoritmo);
                break;
            case "3":
                System.out.println("Ha seleccionado 20 vertices.");
                vertices = 20;
                crearMatriz1(algoritmo);
                break;
            case "4":
                System.out.println("Ha seleccionado 30 vertices.");
                vertices = 30;
                crearMatriz1(algoritmo);
                break;
            case "5":
                System.out.println("Ha seleccionado 50 vertices.");
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
                System.out.println("Ha seleccionado 5 vertices.");
                vertices = 5;
                crearMatriz2(algoritmo);
                break;
            case "2":
                System.out.println("Ha seleccionado 10 vertices.");
                vertices = 10;
                arcos = 30;
                crearMatriz2(algoritmo);
                break;
            case "3":
                System.out.println("Ha seleccionado 20 vertices.");
                vertices = 20;
                arcos = 60;
                crearMatriz2(algoritmo);
                break;
            case "4":
                System.out.println("Ha seleccionado 30 vertices.");
                vertices = 30;
                arcos = 90;
                crearMatriz2(algoritmo);
                break;
            case "5":
                System.out.println("Ha seleccionado 50 vertices.");
                vertices = 50;
                arcos = 150;
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
        int cont = 00;

        if (vertices == 5) {
            matrizAdy = matriz5C;
        } else if(vertices == 10){
            matrizAdy = matriz10C;
        } else {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (i < j && (i + 1) == j) {
                        matrizAdy[i][j] = 1;
                        matrizAdy[j][i] = 1;
                        cont++;
                        if (i == 0 || i == (vertices / 2) - 2 || i == (vertices / 2) + 2) {
                            matrizAdy[i][vertices - 1] = 1;
                            matrizAdy[j][vertices - 1] = 1;
                            cont++;
                        }
                    }

                }
            }

            while (cont < arcos) {
                for (int i = 0; i < vertices; i++) {
                    int limite = 1;
                    if (i <= vertices - 3 && limite <= 2) {
                        int j = 19;
                        if ((2 + i) != (vertices - 1)) {
                            j = ThreadLocalRandom.current().nextInt(2 + i, vertices - 1);
                        }
                        if (matrizAdy[i][j] == 0 && i + 2 <= j) {
                            matrizAdy[i][j] = 1;
                            matrizAdy[j][i] = 1;
                            limite++;
                            cont++;
                        }
                    }
                }
            }
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
        Grafo u = new Grafo();                          aA++;lA++;
        Vertice mayor = getMayorBeneficio();            aA++;lA++;
        
        while (mayor.getBeneficio() != 0) {             cA++;lA++;
            u.addVertice(mayor);                        aA++;cA++;lA++;
            mayor = getMayorBeneficio();                aA++;lA++;
        }                                               cA++;
        
        imprimirGrafo(u);                               lA++;
        menuAlgoritmo();                                lA++;
    }
    
    public static Vertice getMayorBeneficio() {
        ArrayList<Vertice> v = g.getVertices();         aA++;lA++;
        Vertice mayor = new Vertice("", false, 0);      aA+=2;lA++;
                
        for (int i = 0; i < v.size(); i++) {            aA++;cA+=2;lA++;
            if (!v.get(i).getUsed()) {                  cA++;lA++;
                if (mayor.getBeneficio() < v.get(i).getBeneficio()) {   lA++;
                    mayor = v.get(i);                   aA++;lA++;
                }
            }
        }                                               cA++;
        mayor.setUsed(true);                            aA++;cA++;lA++;
        if (mayor.getBeneficio() != 0) {                lA++;
            marcarAdyacentes(mayor);                    lA++;
        }

        return mayor;
    }

    public static void marcarAdyacentes(Vertice v) {
        ArrayList<Arco> arcos = v.getArcos();           aA+=2;lA++;
        for (int i = 0; i < arcos.size(); i++) {        aA+=2;cA++;lA++;
            g.buscarVerticeGrafo(arcos.get(i).getDestino().getVertice()).setUsed(true);lA++;
        }                                               cA++;
    }
    
    // ------------------------* Algoritmo B *------------------------
    
    public static void algoritmoB(){
        Grafo u = new Grafo();                          aB++;lB++;
        
        while (!g.verificarUsados()) {                  cB++;lB++;
            etapa(u);                                   lB++;
        }                                               cB++;
        
        imprimirGrafo(u);                               lB++;
        menuAlgoritmo();                                lB++;
    }
    
    public static void etapa(Grafo u) {
        int[] diferencias = new int[vertices];          aB++;lB++;
        int peso;                                       lB++;
        int diferencia;                                 lB++;
        int beneficio;                                  aB++;lB++;
        
        for (int i = 0; i < vertices; i++) {            aB++;cB+=2;lB++;
            if (!g.vertices.get(i).getUsed()) {         lB++;
                beneficio = g.vertices.get(i).getBeneficio();                   lB++;
                ArrayList<Arco> adyacentes = g.vertices.get(i).getArcos();      lB++;
                peso = 0;                               aB+=4;                  lB++;

                for (int j = 0; j < adyacentes.size(); j++) {                   aB++;cB+=2;lB++;
                    if (!adyacentes.get(j).getDestino().getUsed()) {            lB++;
                        peso += adyacentes.get(j).getDestino().getBeneficio();  aB++;lB++;
                    }
                }                                                               cB++;
                
                diferencia = beneficio - peso;          lB++;                       
                diferencias[i] = diferencia;            aB+=2;lB++;
            }
        }                                               cB++;
        
        int mayor = diferencias[obtenerPrimerMayor()];  aB++;lB++;
        int index = 0;                                  aB+=2;lB++;
        for (int i = 0; i < vertices; i++) {            aB++;cB+=2;lB++;
            if (!g.buscarVerticeGrafo(Integer.toString(i)).getUsed()) {     cB++;lB++;
                if (diferencias[i] > mayor) {           lB++;
                    mayor = diferencias[i];             aB++;lB++;
                    index = i;                          aB++;lB++;
                }
            } 
        }                                               cB++;
        
        Vertice v = g.buscarVerticeGrafo(Integer.toString(index));          aB++;lB++;
        v.setUsed(true);                                aB++;lB++;
        marcarAdyacentes(v);                            lB++;//CAMBIAR EN LAS PRUEBAS DE B
        ArrayList<Vertice> sueltos = g.buscarVerticesSueltos();             aB++;lB++;
        
        u.addVertice(v);                                aB++;cB+=2;lB++;                                  
        if (!sueltos.isEmpty()) {                       aB++;lB++;
            for (int i = 0; i < sueltos.size(); i++) {  aB++;cB++;lB++;
                sueltos.get(i).setUsed(true);           aB++;lB++;
                u.addVertice(sueltos.get(i));           aB++;cB++;lB++;
            }                                           cB++;
        }
    }
    
    public static int obtenerPrimerMayor() {            aB++;lB++;
        for (int i = 0; i < g.vertices.size(); i++) {   aB++;cB+=2;lB++;
            if (!g.vertices.get(i).getUsed()) {         lB++;
                                                        lB++;
                return i;                               
            }
        }                                               cB++;lB++;
        return 0;
    }
    
    // ------------------------* Algoritmo C *------------------------
    
    public static void algoritmoC(){
        ArrayList<Vertice> vertices = g.getVertices();  aC++;lC++;
        ArrayList<Vertice> selected = new ArrayList();  aC++;lC++;
        
        Vertice mayor = getMayorAbyacentes();           aC++;lC++;
        while(mayor != null){                           cC++;lC++;
            System.out.println(mayor.getVertice());     lC++;
            g.marcarVertice(mayor);                     lC++;
            addSelected(selected);                      lC++;
            mayor = getMayorAbyacentes();               aC++;lC++;
        }                                               cC++;
        
        System.out.println("Los locales con mayor numero de ubicaciones son:"); lC++;
        int benetotal = 0;                              cC++;aC++;lC++;
        for(int i = 0; i < selected.size(); i++){       aC++;cC++;lC++;
            System.out.print(selected.get(i).getVertice() + ", ");lC++;
            benetotal += selected.get(i).getBeneficio();    aC++;lC++;
        }                                               cC++;
        System.out.println("El beneficio total de esta seleccion es: " + benetotal); lC++;
    }
    
    public static void addSelected(ArrayList<Vertice> selected){
        ArrayList<Vertice> vertices = g.getVertices();  aC+=2;lC++;
        for(int i = 0; i < vertices.size(); i++){       aC++;cC+=2;lC++;
            if(!vertices.get(i).getUsed()){             cC++;lC++;
                if(vertices.get(i).getArcosActivos() == 0){ lC++;
                    g.marcarVertice(vertices.get(i));   lC++;
                    selected.add(vertices.get(i));      aC++;lC++;
                }
            }
        }                                               cC++;
    }
    
    public static Vertice getMayorAbyacentes(){
        ArrayList<Vertice> vertices = g.getVertices();  aC++;lC++;
        int mayorA = 0;                                 aC++;lC++; 
        Vertice mayorV = null;                          aC+=2;lC++;
        for(int i = 0; i < vertices.size(); i++){       aC++;cC+=2;lC++;
            if(!vertices.get(i).getUsed()){             lC++;
                int totales = vertices.get(i).getArcosActivos();    aC++;cC++;lC++;
                if(totales > mayorA){                   lC++;
                    mayorA = totales;                   aC++;lC++;
                    mayorV = vertices.get(i);           aC++;lC++;
                }
            }    
        }                                               cC++;lC++;
        return mayorV;
    }
    
    // ------------------------* Algoritmo D *------------------------
    
    public static void algoritmoD() {
        ArrayList<Vertice> used = new ArrayList();
        ArrayList<Vertice> vertices = g.getVertices();
        Vertice next = vertices.get(0);
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
    
    public static ArrayList<Vertice> backtracking(ArrayList<Vertice> usados, ArrayList<Vertice> opciones, Vertice vertice, int max, ArrayList<Vertice> solucion, ArrayList<Vertice> combinacion){
        if(vertice == null){
            return solucion;
        }
        usados = marcarAdyacentesBackU(usados, vertice);
        usados.add(vertice);
        
        Vertice next = getMayorBeneficioBack(opciones, usados);
        
        combinacion.add(vertice);
        if(sumarpesovertices(combinacion) > max){
            solucion = combinacion;
            max = sumarpesovertices(combinacion);
        }
        return backtracking(usados, opciones, next, max, solucion, combinacion);
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
        
}
