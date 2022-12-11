package agents;

import MiniChatMulPC.*;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author eduar
 */
public class Chef extends Agent {
    //Los comportamientos se ejecutan en el orden que se crearon
    protected void setup() {
        //Aqui es donde se añade el comportamiento.
        Frm2 m = new Frm2();
        m.setVisible(true);
    }
    
    
    /**
     * Este es el comportamiento del agente Imprime dos mensajes uno con el
     * nombre e indica que es el primer comporttamiento, ademas de que crea un
     * nuevo comportamiento
     */
    private class MiComportamiento1 extends Behaviour {

        public void action() {
            System.out.println("Mi nombre es: " + getName());
            System.out.println("Soy el primer comportamiento");

            myAgent.addBehaviour(new MiComportamiento2());
        }

        public boolean done() {
            return true;
        }
    }

    //Este es el otro comportamiento
    private class MiComportamiento2 extends Behaviour {

        public void action() {
            System.out.println("Soy el segundo comportamiento");
        }

        public boolean done() {
            return true;
        }
    }
    
}
