/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Agente4 extends Agent{


  
   @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgente());
    
    }

    @Override
    protected void takeDown() {
        
    
    }
    
    

    
    class ComportamientoAgente extends CyclicBehaviour{

        @Override
        public void action() {
            
            ACLMessage acl = blockingReceive();
            
            try {
                RespuestaAlgoritmo  s = (RespuestaAlgoritmo) acl.getContentObject();
                
                if(s.getValory() <= 30000 ){
                
                 new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente3", getAgent(), "Se puede vender al individuo" + getAgent().getName(), "COD006");
                
                
                }else{
                
                 new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente3", getAgent(), "No puede vender al individuo" + getAgent().getName(), "COD007");
                }
                
                
                
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente4.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            
         
            
       
            
        }
   
    
    }
   
    
}
