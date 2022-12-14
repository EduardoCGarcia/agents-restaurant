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
                            actionProd(prod,"h1.jpeg");
                        }
                        case "Hamburgesa 2" -> {
                            actionProd(prod,"h2.jpg");
                        }
                        case "Hamburgesa 3" -> {
                            actionProd(prod,"h3.jpg");
                        }
                        case "Pizza 1" -> {
                            actionProd(prod,"p1.jpg");
                        }
                        case "Pizza 2" -> {
                            actionProd(prod,"p2.jpg");
                        }
                        case "Pizza 3" -> {
                            actionProd(prod,"p3.jpg");
                        }
                        case "Malteada 1" -> {
                            actionProd(prod,"b1.jpg");
                        }
                        case "Malteada 2" -> {
                            actionProd(prod,"b2.jpg");
                        }
                    }
                }
            }
        }

        public boolean done() {
            return finished;
        }

        public void actionProd(String prod, String img) {
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
            GUITools.panelIntoPanel(n.pnlImg, new FondoImagen(img));
            n.setVisible(true);
            ChefFrm.sendMessage(prod);
        }
    }

}
