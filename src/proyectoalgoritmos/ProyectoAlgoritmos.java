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
 * @author 
 */
public class ProyectoAlgoritmos {
    
    
    /*Varaiables utilizadas en la medición de los algoritmos
    Creador y fecha: Javier, 26/09/19
    Ultima modificacion: 27/09/19*/
    
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
    
    /*Objeto grafo (g), donde se almacenan los vertices creados.
    
    verticesLocales y arcosLocales almecenan localmente los vertices y arcos que tambien son
    almecenados dentro de g para un acceso a estos de forma mas rapida
    
    vertices determina la cantidad de arcos que seran creados, tanto en la creacion de matrices
    quemadas como aleatorias. Arcos limita el numero de arcos creados en las matrices aleatorias
    
    matrizAdya será una variable general que se ajustara a la matriz seleccionada a traves de los menus
    
    Creador y fecha: Javier, 10/09/19
    Ultima modificacion: 17/09/19*/
    
    public static Grafo g;
    public static ArrayList<Vertice> verticesLocales;
    public static ArrayList<Arco> arcosLocales;
    public static int vertices;
    public static int arcos;
    public static int [][] matrizAdy;
    
    /* Las siguientes son las matrices de adyacencia que seran utilizadas a la hora de crear los grafos
    matriz5C y matriz10C son usaas para el algoritmo D (pues este no requiere que sean aciclicas,
    mientras que las demas son utilizadas para crear los grafos sobre los que trabajan los 
    algoritmos a, b y c.
    
    Creador y fecha: Javier, 10/09/19
    Ultima modificacion: 14/09/19*/
    
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
    
    /*menu por el cual se determina el algortimo a ejecutar
    
    Creador y fecha: Carlos 10/09/19
    Ultima modificacion: 15/09/19
    */
    
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
    
    
    /*menu por el cual se determina el tamaño de la matriz, y por ende el grafo, sobre el cual se va
    a trabajar. Se divide segun el algoritmo escogido.
    
    Creador y fecha: Carlos 10/09/19
    Ultima modificacion: 15/09/19
    */
    
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
    
    /* Algoritmo de creacion de la matriz para los algortimos a, b y c. Define la matriz de adyacencia 
    segun el tamaño de matriz elegida.
    
    Creador y fecha: Javier 11/09/19
    Ultima modificacion: 15/09/19*/
    
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
    
     /* Algoritmo de creacion de la matriz para el algoritmo d. Define la matriz de adyacencia 
    segun el tamaño de matriz elegida o crea una matriz aleatoria de ser un tamaño mayor a 10
    
    Creador y fecha: Javier 15/09/19
    Ultima modificacion: 18/09/19*/
    
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
    
    /*Algoritmo que crea los vertices y arcos segun la matriz de adyacencia determinada gracias a los menus y 
    los almacena dentro de g (el objeto grafo)
    
    Ademas llama al algoritmo seleccionado
    
    Creador y fecha: Javier 10/09/19
    Ultima modificacion: 18/09/19
    */
    
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
    
    /*metodo que imprime los beneficios de los vertices creados
    
    Creador y fecha: Javier 15/09/19
    Ultima modificacion 15/09/19*/
    
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
    
    /*Imprime el resultado del algortime los vertices dentro de un grafo
    
    Creador y fecha: Javier 12/09/19
    Ultima modificacion: 15/09/19*/
    
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
    
    /*primer algoritmos del proyecto, obtiene el vertice de mayor beneficio, lo marca a el y sus
    adyacentes y repite de forma iterativa hasta que no puede encontrar mas vertices
    mayores
    
    Creador y fecha: Javier 13/09/19
    Ultima modificacion: 14/09/19*/
    
    public static void algoritmoA() {
        long start = System.currentTimeMillis();
        Grafo u = new Grafo();                          aA++;lA++;
        Vertice mayor = getMayorBeneficio();            aA++;lA++;
        
        while (mayor.getBeneficio() != 0) {             cA++;lA++;
            u.addVertice(mayor);                        aA++;cA++;lA++;
            mayor = getMayorBeneficio();                aA++;lA++;
        }                                               cA++;
        
        long end = System.currentTimeMillis();
        float millisec = end - start; 
        System.out.println("Duración: " + millisec);
        System.out.println("Asignaciones: " + aA);  aA=0;
        System.out.println("Comparaciones: " + cA); cA=0;
        System.out.println("Líneas: " + lA);        lA=0;
        
        imprimirGrafo(u);                               lA++;
        menuAlgoritmo();                                lA++;
    }
    
    /* Metodo que busca el vertice mayor y llama al metodo que marca sus dayacentes
    
    Creador y fecha: Javier 13/09/19
    Ultima modificacion: 14/09/19*/
    
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

    /* Metodo que marca a todos los vertices adyacentes a un vertice determinado
    
    Creador y fecha: Javier 13/09/19
    Ultima modificacion: 14/09/19*/
    
    public static void marcarAdyacentes(Vertice v) {
        ArrayList<Arco> arcos = v.getArcos();           aA+=2;lA++;
        for (int i = 0; i < arcos.size(); i++) {        aA+=2;cA++;lA++;
            g.buscarVerticeGrafo(arcos.get(i).getDestino().getVertice()).setUsed(true);lA++;
        }                                               cA++;
    }
    
    // ------------------------* Algoritmo B *------------------------
    
    /*Algoritmo que llama de forma iterativa al metodo etapa es quien determina cada paso de la solucion a este algoritmo
    
    Creador y fecha: Javier 15/09/19
    Ultima modificacion 16/09/19*/
    
    public static void algoritmoB(){
        long start = System.currentTimeMillis();
        Grafo u = new Grafo();                          aB++;lB++;
        
        while (!g.verificarUsados()) {                  cB++;lB++;
            etapa(u);                                   lB++;
        }                                               cB++;
        
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F; 
        System.out.println("Duración: " + sec);
        System.out.println("Asignaciones: " + aB);  aB=0;
        System.out.println("Comparaciones: " + cB); cB=0;
        System.out.println("Líneas: " + lB);        lB=0;
        
        imprimirGrafo(u);                               lB++;
        menuAlgoritmo();                                lB++;
    }
    
    /*Algoritmo que mide la diferencia del beneficio de cada vertice con la de sus adyacentes, determina el vertice con la mayor diferencia,
    lo añade a la solucion, marca a el y sus adyacentes y busca aquellos vertices que no poseen adyacentes sin marcar y los añade a
    la solucion tambien
    
    Creador y fecha: Javier 15/09/19
    Ultima modificacion 16/09/19*/
    
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
    
    /*algoritmo que busca el primer vertice del vertice que no este marcado
    
    Creador y fecha: Javier 15/08/19
    Ultima modificacion: 16/09/19*/
    
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
    
    /*algoritmo C que llama de forma iterativa al algoritmo que se encarga de deterinar la solucion
    
    Creador y fecha: Carlos 14/09/19
    Ultima modificacion: 15/09/19*/
    
    public static void algoritmoC(){
        long start = System.currentTimeMillis();
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
        
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F; 
        System.out.println("Duración: " + sec);
        System.out.println("Asignaciones: " + aC);  aC=0;
        System.out.println("Comparaciones: " + cC); cC=0;
        System.out.println("Líneas: " + lC);        lC=0;
    }
    
    /*metodo que añade a la solucion los vertices que no posean adyacentes no marcados
    
    Creador y fecha: Carlos 14/09/19
    Ultima modificacion: */
    
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
    
    /*metodo que busca dentro de los vertices no marcados el que posea el mayor numero de adyacentes
    
    Creador y fecha: Carlos 14/09/19
    Ultima modificacion: 15/09/19*/
    
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
    
    /*Metodo que corresponde al algoritmo D, llama al metodo de backtracking de forma iterativa con cada uno de los vertices del grafo
    como vertice inicial, en caso de poder encontrar una solucion mejor a la de una iteracion anterior, o sea, prueba todas las posible 
    combinaciones
    
    Creador y fecha: Carlos 15/09/19
    Ultima modificacion 27/09/19*/
    
    public static void algoritmoD() {
        long start = System.currentTimeMillis();
        ArrayList<Vertice> resultado = new ArrayList<>();       aD++;lD++;
        ArrayList<Vertice> verticesG = g.getVertices();         aD+=2;lD++;
        for(int i = 0; i < vertices; i++){                      aD++;cD++;lD++;
            ArrayList<Vertice> used = new ArrayList<>();        aD++;lD++;
            ArrayList<Vertice> combinacion = new ArrayList<>(); aD++;lD++;
            int max = sumarpesovertices(resultado);             aD++; lD++;
            resultado = backtracking(used, verticesG, verticesG.get(i), max, resultado, combinacion);aD++;lD++;
        }                                                       cD++;
        
        System.out.println("Los vertices seleccionados  para el algoritmo son: ");lD++;
        int i = 0;                                              aD++;lD++;
        while(i < resultado.size()){                            cD++;lD++;
            System.out.print(resultado.get(i).getVertice()+ ", ");lD++;
            i++;                                                aD++;lD++;
        }                                                       cD++;
        System.out.println("");                                 lD++;
        System.out.println("Peso total del grafo: " + sumarpesovertices(resultado));lD++;
        
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F; 
        System.out.println("Duración: " + sec);
        System.out.println("Asignaciones: " + aD);  aD=0;
        System.out.println("Comparaciones: " + cD); cD=0;
        System.out.println("Líneas: " + lD);        lD=0;
        
        menuAlgoritmo();
        
    }
    
    /*metodo que va creando combinaciones de vertices no adyacentes segun el vertice dentro de opciones y fuera de usados con el mayor beneficio,
    compara el peso total de la combinacion actual con el de la ultima solucion encontrada, de ser mayor define la solucion actual como 
    esta combinacion
    
    Creador y fecha: Carlos 15/09/19
    Ultima mofificacion: 27/09/19*/
    
    public static ArrayList backtracking(ArrayList<Vertice> usados, ArrayList<Vertice> opciones, Vertice vertice, int max, ArrayList<Vertice> solucion, ArrayList<Vertice> combinacion){
                                                                cD++;
        if(vertice == null){                                    lD+=2;
            return solucion;                                    
        }
        usados = marcarAdyacentesBack(usados, vertice);         aD++;lD++;
        usados.add(vertice);                                    aD++;lD++;
        
        combinacion.add(vertice);                               aD++;cD++;lD++;
        if(sumarpesovertices(combinacion) > max){               lD++;
            solucion = combinacion;                             aD++;lD++;
            max = sumarpesovertices(combinacion);               aD++;lD++;
        }
        Vertice next = getMayorBeneficioBack(opciones, usados); aD++;lD+=2;
        return backtracking(usados, opciones, next, max, solucion, combinacion);
    }
    
    /*Algoritmo que determina la suma de los beneficios de los vertices de una combinacion
    
    Creador y fecha: Carlos 15/09/19
    Ultima mofificacion: 16/09/19*/
    
    public static int sumarpesovertices(ArrayList<Vertice> vertices){
        int total = 0;                                          aD+=2;lD++;
        for(int i = 0; i < vertices.size(); i++){               aD++;cD+=2;lD++;
            if(vertices.get(i) != null){                        lD++;
                total += vertices.get(i).getBeneficio();        aD++;lD++;
            }
        }                                                       cD++;lD++;
        return total;
    }
    
    /*Determina el vertice de mayor beneficio que no este ya usado en una combinacion o sea adyacente a otro a usado
    
    Creador y fecha: Carlos 15/09/19
    Ultima mofificacion: 16/09/19*/
    
    public static Vertice getMayorBeneficioBack(ArrayList<Vertice> vertices, ArrayList<Vertice> used){
        int maxB = 0;                                           aD++;lD++;
        Vertice maxV = null;                                    aD+=2;lD++;
        
        for(int i = 0; i < vertices.size(); i++){               aD++;cD+=2;lD++;            
            if(!used.contains(vertices.get(i))){                cD++;lD++;
                if(vertices.get(i).getBeneficio() > maxB){      lD++;
                    maxB = vertices.get(i).getBeneficio();      aD++;lD++;
                    maxV = vertices.get(i);                     aD++;lD++;
                }
            }
        }                                                       cD++;lD++;
        return maxV;
    }
    
    /*Algoritmo que introduce a la lista de vertices usados aquellos que sean adyacentes a un vertice determinado
    
    Creador y fecha: Carlos 15/09/19
    Ultima mofificacion: 16/09/19*/
    
    public static ArrayList<Vertice> marcarAdyacentesBack(ArrayList<Vertice> used, Vertice vertice){
        ArrayList<Arco> arcos = vertice.getArcos();             aD+=2;lD++;
        
        for(int i = 0; i < arcos.size(); i++){                  aD++;cD++;lD++;
            Vertice objetivo = arcos.get(i).getDestino();       aD++;cD++;lD++;
            if(!used.contains(objetivo)){                       lD++;
                used.add(objetivo);                             aD++;lD++;
            }
        }                                                       cD++;lD++;
        
        return used;}
}