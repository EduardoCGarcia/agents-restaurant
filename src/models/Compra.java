
package models;

import jade.content.AgentAction;


public class Compra  implements AgentAction{
    private Producto producto;
 
   public Producto getPlanta() {
     return producto;
   }
 
   public void setFruta(Producto producto) {
     this.producto = producto;
   }
}
    