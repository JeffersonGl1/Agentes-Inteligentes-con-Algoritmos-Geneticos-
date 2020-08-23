/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class RespuestaAlgoritmo implements Serializable{
    
    private double valorX;
    private double valory;

    public RespuestaAlgoritmo(double valorX, double valory) {
        this.valorX = valorX;
        this.valory = valory;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValory() {
        return valory;
    }

    public void setValory(double valory) {
        this.valory = valory;
    }
    
    
    
    
}
