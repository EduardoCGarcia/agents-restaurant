
package agents;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;
import models.Compra;
import models.Oferta;
import models.Producto;

public class RestauranteOntologia  extends Ontology {
     //Nombre de la ontología
    public static final String ONTOLOGY_NAME = "Ontología de restaurante";
    
    //Vocabulario de la ontología que van a manejar los agentes
    public static final String PRODUCTO = "PRODUCTO";
    public static final String PLANTA_NOMBRE = "NOMBRE";
    public static final String PLANTA_PRECIO = "PRECIO";
    //public static final String PLANTA_TIPO = "TIPO";
    
    public static final String OFERTA = "Oferta";
    public static final String OFERTA_PRODUCTO = "Producto";
    
    public static final String COMPRA = "Compra";
    public static final String COMPRA_PRODUCTO = "Producto";
    
    // Instancia de la Ontología
    public static Ontology instancia = new RestauranteOntologia();
    
    // Método para acceder a la instancia de la ontología
    public static Ontology getInstance() {
       return instancia;
    }
    
    private RestauranteOntologia() {
        //BarOntology extiende la Ontología básica
        super(ONTOLOGY_NAME, BasicOntology.getInstance());
        
        try{
            //Añadir elementos
            add(new ConceptSchema(PRODUCTO), Producto.class);
            add(new PredicateSchema(OFERTA), Oferta.class);
            add(new AgentActionSchema(COMPRA), Compra.class);
            
            //Estructura del esquema para el concepto PLANTA
            ConceptSchema cs = (ConceptSchema) getSchema(PRODUCTO);
            cs.add(PLANTA_NOMBRE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            cs.add(PLANTA_PRECIO, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            
            //Estructura del esquema para el predicado OFERTA
            PredicateSchema ps = (PredicateSchema) getSchema(OFERTA);
            ps.add(OFERTA_PRODUCTO, (ConceptSchema) getSchema(PRODUCTO));
            
            //Estructura del esquema para la acción COMPRAR
            AgentActionSchema as = (AgentActionSchema) getSchema(COMPRA);
            as.add(COMPRA_PRODUCTO, (ConceptSchema) getSchema(PRODUCTO));
        }catch( OntologyException e ){
            e.printStackTrace();
        }    
    }
    
}
