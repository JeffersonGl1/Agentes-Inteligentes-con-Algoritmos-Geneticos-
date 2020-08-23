/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos3;

/**
 *
 * @author Jefferson Guasumba
 */
import algoritmosgeneticos2.*;
import algoritmosgeneticos1.*;
import static java.lang.Double.NaN;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud extends FitnessFunction {

    private double fitness; //La variable que llevará el valor de aptitud

    public funcionAptitud() {
        fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness;//agregar comprobacion de si es 50
    }

    private void Evaluar(IChromosome cromosoma) {
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();//entero X 
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();//entero X
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();//entero X
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();//entero X
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();//entero X
        
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();//entero y
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();//entero y
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();//entero y
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();//entero y
        Integer c10 = (Integer) cromosoma.getGene(9).getAllele();//entero y
        Integer c11 = (Integer) cromosoma.getGene(10).getAllele();//entero y
        Integer c12 = (Integer) cromosoma.getGene(11).getAllele();//entero y
        Integer c13 = (Integer) cromosoma.getGene(12).getAllele();//entero y
        Integer c14 = (Integer) cromosoma.getGene(13).getAllele();//entero y
        Integer c15 = (Integer) cromosoma.getGene(14).getAllele();//entero y
        Integer c16 = (Integer) cromosoma.getGene(15).getAllele();//entero y
        Integer c17 = (Integer) cromosoma.getGene(16).getAllele();//entero y
        Integer c18 = (Integer) cromosoma.getGene(17).getAllele();// entero y
        Integer c19 = (Integer) cromosoma.getGene(18).getAllele();//entero y
        Integer c20 = (Integer) cromosoma.getGene(19).getAllele();//entero y
        Integer c21 = (Integer) cromosoma.getGene(20).getAllele();//entero y
        Integer c22 = (Integer) cromosoma.getGene(21).getAllele();//entero y
        Integer c23 = (Integer) cromosoma.getGene(22).getAllele();//entero y
        
        
        
        Integer c24 = (Integer) cromosoma.getGene(23).getAllele();//decimal y
        Integer c25 = (Integer) cromosoma.getGene(24).getAllele();//decimal y
        Integer c26 = (Integer) cromosoma.getGene(25).getAllele();//decimal y
        Integer c27 = (Integer) cromosoma.getGene(26).getAllele();//decimal y
        Integer c28 = (Integer) cromosoma.getGene(27).getAllele();//decimal y
        Integer c29 = (Integer) cromosoma.getGene(28).getAllele();//decimal y
        Integer c30 = (Integer) cromosoma.getGene(29).getAllele();//decimal y
        

        String valorXInt = c1.toString() + c2.toString() + c3.toString() + c4.toString() + c5.toString();
     
        Integer valorXentero = (Integer.parseInt(valorXInt, 2)); 
        
        //Integer valorXdecimal = (Integer.parseInt(valorXDec, 2));
        
        //String valorX = valorXentero.toString() + puntox + valorXdecimal.toString();
        
        String valorX = valorXentero.toString(); 
        
        Double valorXFinal = (Double.parseDouble(valorX));
        
        
        String valorYInt = c6.toString() + c7.toString() + c8.toString() + c9.toString() + c10.toString() + c11.toString() + c12.toString() + c13.toString() +
                c14.toString() + c15.toString() + c16.toString() + c17.toString() + c18.toString() + c19.toString() + c20.toString() + c21.toString() + c22.toString() + c23.toString();
        String puntoy = ".";
        String valorYDec = c24.toString() + c25.toString() + c26.toString() + c27.toString() + c28.toString() + c29.toString()+ c30.toString() ;
        
        Integer valorYentero  = (Integer.parseInt(valorYInt, 2));
        
       // Integer valorYdecimal = (Integer.parseInt(valorYDec, 2));
        
        //String valorY = valorYentero.toString() + puntoy + valorYdecimal.toString();
        
         String valorY = valorYentero.toString() + puntoy + binarioADecimal(valorYDec).toString();
        Double valorYFinal = (Double.parseDouble(valorY));
        
        valorYFinal = -valorYFinal;

       
        
        System.out.println(valorXFinal + " ; " + valorYFinal);
        //fitness = 256 - Math.abs(valor - 50);
        //fitness = 450 - ((valorXint) * (valorXint) + valorYint * valorYint);
        //log^2(15.127 + 15.127 )
        
        double valor= -188752 + ((27156 * Math.log10(valorXFinal)) - 188752);
        
        if(Double.isNaN(valor)){
            
              fitness = 0.0;
        }else if (valor < 0){
            fitness = 0.0;
             
        }else{
            fitness =  -188752 + ((27156 * Math.log10(valorXFinal)) - 188752);
        
        }
        
      
        
    }
    
      
        public Integer binarioADecimal(String aux){
        
        char b[] = aux.toCharArray();
        double suma = 0;
        int j = -1; 
        String nu = "";
        for (int i = 0; i < 7 ; i++){
        
        nu+= b[i];
        int num1 = Integer.parseInt(nu);
        suma=(int)(suma + num1*Math.pow(2, j));
        
        j--;
        }
         return (int) suma;
        }
}
