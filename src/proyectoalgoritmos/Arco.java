/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

/**
 *
 * @author Javier
 */
public class Arco {

    private Vertice origen;
    private Vertice destino;
    private int peso;
    private Boolean anadido;
    
    public Arco(Vertice origen, Vertice destino, int peso, Boolean anadido) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.anadido = anadido;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }
    
    public Vertice getOrigen() {
        return origen;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
    
     public Vertice getDestino() {
        return destino;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public int getPeso() {
        return peso;
    }

    public void setAnadido(Boolean anadido) {
        this.anadido = anadido;
    }

    public Boolean getAnadido() {
        return anadido;
    }
    
    
}
