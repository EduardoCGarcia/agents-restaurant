package agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import views.ChefFrm;

/**
 *
 * @author eduar
 */
public class Chef extends Agent {
    //Los comportamientos se ejecutan en el orden que se crearon
    protected void setup() {
        //Aqui es donde se añade el comportamiento.
        ChefFrm m = new ChefFrm();
        m.setVisible(true);
        addBehaviour(new PedirIngredientesBehaiviour());
    }
    
    
    /**
     * Este es el comportamiento del agente Imprime dos mensajes uno con el
     * nombre e indica que es el primer comporttamiento, ademas de que crea un
     * nuevo comportamiento
     */
    private class PedirIngredientesBehaiviour extends Behaviour {
        private boolean finished = false;
        public void action() {
            if (!ChefFrm.peticion.isEmpty()) {
                finished = true;
                ChefFrm.peticion += "\nPedido recibido";
                ChefFrm.txtOrden.setText(ChefFrm.peticion);
            }
        }

        public boolean done() {
            return finished;
        }
    }


    
}
