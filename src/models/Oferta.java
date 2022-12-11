
package models;

import jade.content.Predicate;
import java.io.Serializable;

public class Oferta implements Predicate, Serializable {
    private Producto producto;
    
    public Producto getPlanta() {
        return producto;
    }

    public void setPlanta(Producto producto) {
        this.producto = producto;
    }
}
