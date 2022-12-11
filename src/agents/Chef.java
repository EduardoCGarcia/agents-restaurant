package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
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
        private String pedido;

        public void action() {
            ACLMessage mensajeRecibido = blockingReceive();
            String msj = mensajeRecibido.getContent();
            System.out.println("Mensaje: " + msj);
            if (msj == null) {
                if (!ChefFrm.peticion.isEmpty()) {
                    finished = true;
                    pedido = ChefFrm.peticion;
                    String[] prods = pedido.split("\n");
                    for (String prod : prods) {
                        switch (prod) {
                            case "Hamburgesa 1" -> {
                                ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
                                mensaje.addReceiver(new AID(("SousChef"), AID.ISLOCALNAME));
                                mensaje.setContent(prod);
                                send(mensaje);
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
            }else{
                ChefFrm.txtOrden.append("\n"+msj);
            }
        }

        public boolean done() {
            return finished;
        }
    }

}
