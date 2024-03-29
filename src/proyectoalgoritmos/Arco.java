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

/*
    clase que representa la conexion entre dos vertices

    Creador y fecha: 10/09/19
    Ultima modificacion: 10/09/19
*/
public class Arco {

    private Vertice origen;
    private Vertice destino;
    private Boolean used;
    
    public Arco(Vertice origen, Vertice destino, Boolean anadido) {
        this.origen = origen;
        this.destino = destino;
        this.used = anadido;
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

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Boolean getUsed() {
        return used;
    }
    
    
}
