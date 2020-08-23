/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class Agente3 extends Agent{
    
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
            String idc = acl.getConversationId();
            
            
            if(idc.equalsIgnoreCase("COD007")){
            
             System.out.println(" \n Confirmación de venta cancelada recibida por parte de:" + acl.getSender() + "  El analisis del agente fue: " + acl.getContent());
            
          
            }else{
            System.out.println(" \n Confirmación de venta recibida por parte de:" + acl.getSender() + "  El analisis del agente fue: " + acl.getContent());
            
            }
         
            
       
            
        }
   
    
    }
   
    
    
    
}
