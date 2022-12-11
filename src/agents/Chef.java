package agents;

import Utilerias.FondoImagen;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import tools.GUITools;
import views.ChefFrm;
import views.Entrega;

/**
 *
 * @author eduar
 */
public class Chef extends Agent {

    //Los comportamientos se ejecutan en el orden que se crearon
    ChefFrm m;

    protected void setup() {
        //Aqui es donde se añade el comportamiento.
        m = new ChefFrm();
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
                            ACLMessage mensajeRespuesta = blockingReceive();
                            ChefFrm.txtOrden.append("\nSousChef Prepara los ingredientes para lo siguiente: \n" + prod);
                            ChefFrm.txtOrden.append("\nMushcas Gracias SousChef por los ingredientes: \n" + mensajeRespuesta.getContent());
                            String elementos[] = mensajeRespuesta.getContent().split(";");

                            for (String e : elementos) {
                                ChefFrm.txtOrden.append("\nColocando: " + e);
                            }

                            ChefFrm.txtOrden.append("Listo el producto esta listo");
                            ChefFrm.txtOrden.append("\n-------------------------------------------------------------\n");

                            Entrega n = new Entrega(m, true);
                            GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("h1.jpeg"));
                            n.setVisible(true);
                            ChefFrm.sendMessage(prod);
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
        }

        public boolean done() {
            return finished;
        }
    }

}
