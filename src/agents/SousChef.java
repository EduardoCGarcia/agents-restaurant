package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import views.ChefFrm;
import views.SousChefFrm;

/**
 *
 * @author eduar
 */
public class SousChef extends Agent {

    //Los comportamientos se ejecutan en el orden que se crearon
    protected void setup() {
        //Aqui es donde se añade el comportamiento.
        SousChefFrm m = new SousChefFrm();
        m.setVisible(true);
    }

    private class PedirIngredientesBehaiviour extends Behaviour {

        private boolean finished = false;

        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            if (mensajeRecibido != null) {
                switch (mensajeRecibido.getContent()) {
                    case "Hamburgesa 1" -> {
                        System.out.println("Se enconttro Hamburgesa 1");
                    }
                    case "Hamburgesa 2" -> {
                        System.out.println("Se enconttro Hamburgesa 2");
                    }
                    case "Hamburgesa 3" -> {
                        System.out.println("Se enconttro Hamburgesa 3");
                    }
                    case "Pizza 1" -> {
                        System.out.println("Se enconttro Pizza 1");
                    }
                    case "Pizza 2" -> {
                        System.out.println("Se enconttro Pizza 2");
                    }
                    case "Pizza 3" -> {
                        System.out.println("Se enconttro Pizza 3");
                    }
                    case "Malteada 1" -> {
                        System.out.println("Se enconttro Malteada 1");
                    }
                    case "Malteada 2" -> {
                        System.out.println("Se enconttro Malteada 2");
                    }

                }
            }
        }

        public boolean done() {
            return finished;
        }
    }
}
