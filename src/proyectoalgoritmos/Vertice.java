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
    private Boolean anadido;
    private int beneficio;
    private ArrayList<Arco> arcos;
    
    public Vertice(String vertice, Boolean visitado, Boolean anadido, int beneficio) {
        this.vertice = vertice;
        this.visitado = visitado;
        this.anadido = anadido;
        this.beneficio = beneficio;
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

    public void setAnadido(Boolean anadido) {
        this.anadido = anadido;
    }
    
    public Boolean getAnadido() {
        return anadido;
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
}
