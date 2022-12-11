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
            ACLMessage respuesta = null;
            String msj = mensajeRecibido.getContent();
            if (msj != null) {
                switch (msj) {
                    case "Hamburgesa 1" -> {
                        String ingredientes = "Pan;Carne;Lechuga;Jitomate;Ketchup;Aros de Cebolla";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Hamburgesa 2" -> {
                        String ingredientes = "Pan;Carne;Queso;Queso extra;Lechuga;Jitomate;Cebolla;Tocino;Patatas";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Hamburgesa 3" -> {
                        String ingredientes = "Pan;Carne de pollo;Perejil;Queso;Aderezo;Salsa;Calabaza;Jitomate";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Pizza 1" -> {
                        String ingredientes = "Masa de pizza;Queso;Peperoni;Salsa de Tomate";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Pizza 2" -> {
                        String ingredientes = "Masa de pizza;Queso;Peperoni;Salsa de Tomate;Piña;Aceitunas;Tomatitos cherry;Pimiento";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Pizza 3" -> {
                        String ingredientes = "Masa de pizza;Queso;Pimiento;Salsa de Tomate;Chile;Aceitunas;";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Malteada 1" -> {
                        String ingredientes = "Crema batida;Jarabe de chocolate;Formula de la malteada;Jarabe de piña;Chocorrol";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }
                    case "Malteada 2" -> {
                        String ingredientes = "Fresas;Dulces de Colores;Galleta de fresa;Bombon en churrito;Crema batida sabor fresa;Formula de la malteada";
                        accionProd(ingredientes,
                                msj,
                                mensajeRecibido,
                                respuesta);
                    }

                }
            }
        }

        public boolean done() {
            return finished;
        }

        public void accionProd(String ingredientes, String msj, ACLMessage mensajeRecibido, ACLMessage respuesta) {
            SousChefFrm.txtSolicitud.append("Preparando ingredientes \npara: ");
            SousChefFrm.txtSolicitud.append(msj + "\n");
            SousChefFrm.txtSolicitud.append("Ingredientes:\n");
            SousChefFrm.txtSolicitud.append("Ingredientes:\n");
            SousChefFrm.txtSolicitud.append(ingredientes + "\n");
            SousChefFrm.txtSolicitud.append("\n----------------------------------------\n");
            respuesta = mensajeRecibido.createReply();
            respuesta.setContent(ingredientes);
            send(respuesta);
        }
    }
}
