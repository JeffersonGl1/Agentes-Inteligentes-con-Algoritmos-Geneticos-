/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Guasumba
 */
public class Contenedor {
    
    private AgentContainer mainContainer; //Declaraciòn del contenedor "mainContainer"
    Object[] contenedor = new Object[1];
    
    public void contenedor(){
  
        
        
    jade.core.Runtime runtime = jade.core.Runtime.instance(); //Creaciòn de la rutina de jade
    runtime.setCloseVM(true);
    System.out.println("El runtime ha sido creado \n");
    //Creación del profile
    //profile: contenedor, puerto y nombre
    
    Profile profile=new ProfileImpl(null, 1099, null);
    System.out.println("El perfil ha sido creado \n");
    mainContainer=runtime.createMainContainer(profile); //Contenedor
    System.out.println("El contenedor ha sido creado:" + profile.toString());
    contenedor[0]=this;
    iniciarAgentes();
    
    
    }
    
    private void iniciarAgentes(){
    
        try {
           
            mainContainer.createNewAgent("Agente4", Agente4.class.getName(), null ).start();
            mainContainer.createNewAgent("Agente3", Agente3.class.getName(), null ).start();
            mainContainer.createNewAgent("Agente2", Agente2.class.getName(), null ).start();
            mainContainer.createNewAgent("AgenteH", AgenteH.class.getName(), new Object[]{this} ).start();
           
            } catch (StaleProxyException e) {
 //          Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
          e.printStackTrace();
         
        }
    
    }
    
    public void crearHijos(String nickname,Object[] conocimiento){
        try {
            mainContainer.createNewAgent(nickname,AgenteH0.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
