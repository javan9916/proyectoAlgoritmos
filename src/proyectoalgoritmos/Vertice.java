/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */

/*
    Clase que representa los vertices del grafo, cada una almacena sus respectivos arcos

    Creador y fecha: Javier 10/09/19
    Ultima modificacion: 15/09/19
*/
public class Vertice {
    private String vertice;
    private boolean used;
    private int beneficio;
    private ArrayList<Arco> arcos;
    
    public Vertice(String vertice, Boolean adyacente, int beneficio) {
        this.vertice = vertice;
        this.used = adyacente;
        this.beneficio = beneficio;
    }

    public void setVertice(String vertice) {
        this.vertice = vertice;
    }

     public String getVertice() {
        return vertice;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
    
    public Boolean getUsed() {
        return used;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void addArco(Arco arco) {
        if (arcos == null)
           this.arcos = new ArrayList<>();
        
        this.arcos.add(arco);
    }

    public ArrayList<Arco> getArcos() {
        return arcos;
    }
    
    /*
        marca los arcos de este vertice
    */
    
    public void marcarArcos(){
        for(int i = 0; i < arcos.size(); i++){
            arcos.get(i).setUsed(true);
        }
    }
    
    /*
        determina el numero de arcos no marcados que posee el vertice
    */
    
    public int getArcosActivos(){
        int arcosT = 0;
        for(Arco arc : arcos){
            if(!arc.getUsed()){
                arcosT++;
            }
        }
        return arcosT;
    }
}
