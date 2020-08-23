/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;
import algoritmosgeneticos2.Prueba1;
import algoritmosgeneticos3.Prueba2;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */

public class AgenteH0 extends Agent{
    
    private Contenedor c;
    public Integer hijo=0;
    String nombreAgenteHijo = "";

  
    @Override
    protected void setup() {
       
        
        addBehaviour(new ComportamientoAgente()); //Añade el comportamiento del agente
        super.setup();
    }

    @Override
    protected void takeDown() {
        
        if(nombreAgenteHijo.equalsIgnoreCase("AgenteH1")){
        c.crearHijos(nombreAgenteHijo, new Object[] {c,hijo});
         System.out.println("\n Soy el" +getName() +"y ya morí");
     }else{
        
        
        System.out.println("\n Soy el" +getName() +"y ya morí");
        }
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    
    class ComportamientoAgente extends CyclicBehaviour{

        @Override
        public void action() {
           
            if(nombreAgenteHijo.equalsIgnoreCase("AgenteH0")){
                
                Prueba1 pr = new Prueba1();
     
            Object[] obj  = pr.empezar();
            
           String x = obj[0].toString();
           String y = obj[1].toString();
           
           
           double valorX = Double.parseDouble(x);
           double valorY = Double.parseDouble(y);
           
           
           
           
            
            
            
          //  RespuestaAlgoritmo resp = new RespuestaAlgoritmo(valorX, valorY);
       
 
            
        
          new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Agente2", getAgent(), new RespuestaAlgoritmo(valorX, valorY), "COD002");
            
            }else{
                
            Prueba2 pr = new Prueba2();
     
            Object[] obj  = pr.empezar();
            
           String x = obj[0].toString();
           String y = obj[1].toString();
           
           
           double valorX = Double.parseDouble(x);
           double valorY = Double.parseDouble(y);
           
           
           
           
            
            
            
          //  RespuestaAlgoritmo resp = new RespuestaAlgoritmo(valorX, valorY);
       
 
            
        
          new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Agente2", getAgent(), new RespuestaAlgoritmo(valorX, valorY), "COD003");
            
            
            
            
            
            }
            
            
            
            
            
           
            c = (Contenedor)getArguments()[0];
            hijo= (int) getArguments()[1]; 
                 nombreAgenteHijo= "AgenteH"+hijo;
                 hijo++;
                 
               
                doDelete();
            
        }

       
   
    }
   


 
    
    
    
}