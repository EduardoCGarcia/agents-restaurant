package agents;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import java.util.List;
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
        addBehaviour(new PedirProductosMensajeBehaviour(this));
    }
    
    class PedirProductosMensajeBehaviour extends SimpleBehaviour {

        private boolean finished = false;

        public PedirProductosMensajeBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            if (CamareroFrm.s) {
                finished = true;
                CamareroFrm.txtNota.append("\nEl pedido se ha enviado");
            }
        }

        public boolean done() {

            return finished;
            

        }
    } // Fin de la clase EnviarMensajeBehaviour
}
