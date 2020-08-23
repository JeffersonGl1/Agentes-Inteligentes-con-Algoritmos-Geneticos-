/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import algoritmosgeneticos1.Prueba;
import jade.core.Agent;
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
public class AgenteH extends Agent{
    
    private Contenedor c;

  
    @Override
    protected void setup() {
       
        
        addBehaviour(new ComportamientoAgente()); //Añade el comportamiento del agente
        super.setup();
    }

    @Override
    protected void takeDown() {
               
        c.crearHijos("AgenteH0", new Object[] {c,1});
        System.out.println("\n Soy el agente 2 y ya morí");
        super.takeDown();  
       //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    
    class ComportamientoAgente extends CyclicBehaviour{

        @Override
        public void action() {
            
            
            
            Prueba pr = new Prueba();
     
            Object[] obj  = pr.empezar();
            
           String x = obj[0].toString();
           String y = obj[1].toString();
           
           
           double valorX = Double.parseDouble(x);
           double valorY = Double.parseDouble(y);
           
           
           
           
            
            
            
          //  RespuestaAlgoritmo resp = new RespuestaAlgoritmo(valorX, valorY);
       
 
            
        
          new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Agente2", getAgent(), new RespuestaAlgoritmo(valorX, valorY), "COD001");
           
          
            
             
         
            
             c= (Contenedor)getArguments()[0];
             doDelete();
            
        }

       
   
    }
   


 
    
    
    
}