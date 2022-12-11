package agents;

import MiniChatMulPC.*;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Producto;
import views.CamareroFrm;

/**
 *
 * @author eduar
 */
public class Camarero extends Agent {
    
    
    //  Estructuras de Datos
    public static List<Producto> Compra;
    public static List<Producto> CompraCompleta;
    //  Objetos de Comunicacion
    private Codec codec = new SLCodec();
    private Ontology ontologia = RestauranteOntologia.getInstance();
    
    protected void setup() {
        DFAgentDescription desc = new DFAgentDescription();

        ServiceDescription servicio = new ServiceDescription();
        servicio.setType("Entregar los productos");
        servicio.setName("Camarero");
        
        desc.addServices(servicio);
        
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
        
        CamareroFrm m = new CamareroFrm();
        m.setVisible(true);
    }
    
    class PedirPlantasMensajeBehaviour extends SimpleBehaviour {

        private boolean finished = false;

        public PedirPlantasMensajeBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {

            AID r = new AID();
            r.setLocalName("b");

            System.out.println(getLocalName() + "Vendedor: Esperando mandar Orden...");
            System.out.println("Vendedor: Mandando Orden...");
            try {
                ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                msg.addReceiver(r);

                msg.setContentObject((Serializable) Compra);
                msg.setLanguage("J");
                send(msg);
                System.out.println("V: Orden mandada...");

                System.out.println("V: Esperando Respuesta...");
                block(1000);
                CamareroFrm.txtNota.setText("Entregando los Productos..."); 
                //System.out.println("Trayendo la Orden..."); 

            } catch (IOException ex) {
                Logger.getLogger(Camarero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public boolean done() {

            return true;
            

        }
    } // Fin de la clase EnviarMensajeBehaviour
    
    
   
    
}
