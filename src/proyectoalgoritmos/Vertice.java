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
public class Vertice {
    private String vertice;
    private Boolean visitado;
    private int veces;
    private Boolean anadido;
    private ArrayList<Arco> arcos;
    
    public Vertice(String vertice, Boolean visitado, int veces, Boolean anadido) {
        this.vertice = vertice;
        this.visitado = visitado;
        this.veces = veces;
        this.anadido = anadido;
    }

    public void setVertice(String vertice) {
        this.vertice = vertice;
    }

     public String getVertice() {
        return vertice;
    }
    
    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }
    
    public Boolean getVisitado() {
        return visitado;
    }

    public void addVeces(int veces) {
        this.veces++;
    }
    
    public int getVeces() {
        return veces;
    }

    public void setAnadido(Boolean anadido) {
        this.anadido = anadido;
    }
    
    public Boolean getAnadido() {
        return anadido;
    }

    public void addArco(Arco arco) {
        this.arcos.add(arco);
    }

    public ArrayList<Arco> getArcos() {
        return arcos;
    }
}
