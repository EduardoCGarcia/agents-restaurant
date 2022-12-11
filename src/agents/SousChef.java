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
        addBehaviour(new PedirIngredientesBehaiviour());
    }

    private class PedirIngredientesBehaiviour extends Behaviour {

        private boolean finished = false;

        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            ACLMessage respuesta;
            String msj = mensajeRecibido.getContent();
            if (msj != null) {
                switch (msj) {
                    case "Hamburgesa 1" -> {
                        SousChefFrm.txtSolicitud.append("Preparando ingredientes \npara: ");
                        SousChefFrm.txtSolicitud.append(msj+"\n");
                        SousChefFrm.txtSolicitud.append("Ingredientes:\n");
                        String ingredientes = "Pan;Carne;Lechuga;Jitomate;Ketchup;Aros de Cebolla";
                        SousChefFrm.txtSolicitud.append("Ingredientes:\n");
                        SousChefFrm.txtSolicitud.append(ingredientes + "\n");
                        SousChefFrm.txtSolicitud.append("\n----------------------------------------\n");
                        respuesta = mensajeRecibido.createReply();
                        respuesta.setContent(ingredientes);
                        send(respuesta);
                    }
                    case "Hamburgesa 2" -> {

                    }
                    case "Hamburgesa 3" -> {

                    }
                    case "Pizza 1" -> {

                    }
                    case "Pizza 2" -> {

                    }
                    case "Pizza 3" -> {

                    }
                    case "Malteada 1" -> {

                    }
                    case "Malteada 2" -> {

                    }

                }
            }
        }

        public boolean done() {
            return finished;
        }
    }
}
