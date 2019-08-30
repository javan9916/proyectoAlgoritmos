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
public class Grafo {
    ArrayList<Vertice> vertices;
    
    public Grafo() {
        
    }

    public void addVertice(Vertice vertice) {
        if (this.vertices == null) 
            vertices = new ArrayList<>();
        
        this.vertices.add(vertice);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    
    
}
