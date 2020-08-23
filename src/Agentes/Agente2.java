/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import algoritmosgeneticos1.Prueba;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Guasumba
 */
public class Agente2 extends Agent{

    @Override
    protected void setup() {
       
        super.setup();
        addBehaviour(new ComportamientoAgente()); //Añade el comportamiento del agente
    
    }

    @Override
    protected void takeDown() { //Este metodo me permite realizar una accion antes de morir
       
     
    }
    
    

    
    class ComportamientoAgente extends CyclicBehaviour{

        @Override
        public void action() {
            
            ACLMessage acl = blockingReceive();
            
           
            
            try {
                RespuestaAlgoritmo  s = (RespuestaAlgoritmo) acl.getContentObject();
                
                Double valorAbsoluto = s.getValory();
                valorAbsoluto = -valorAbsoluto;
                
                if(valorAbsoluto < 20000){
                
                    new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente3", getAgent(), "Se puede vender al individuo" + getAgent().getName(), "COD004");
                
                }else{
                
                new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Agente4", getAgent(), new RespuestaAlgoritmo(valorAbsoluto,valorAbsoluto ), "COD005");
                
                
                }
                
                
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
            }

        
   
    }
   


 
    
    
    
    
    
}
    
}