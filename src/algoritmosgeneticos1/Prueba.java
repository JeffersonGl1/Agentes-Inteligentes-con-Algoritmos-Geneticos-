/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos1;

/**
 *
 * @author Jefferson Guasumba
 */
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class Prueba {
    
    public Object[] obj;

    public Object[] empezar() {
        try {
            //Configuramos JGAP
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new funcionAptitud();
            configuracion.setFitnessFunction(myFunc); //Le indicamos a JGAP cual sera nuestra funcion de aptitud
            Gene[] genEjemplo = new Gene[30];

            //Creamos una codificacion de 8 genes que nos servira para nuestros individuos (fenotipo)
            //Los genes seran valores entre 0 y 1  ejem 01001110 individuo ejemplo
            genEjemplo[0] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[1] = new IntegerGene(configuracion, 0, 1);//Parte Entera X
            genEjemplo[2] = new IntegerGene(configuracion, 0, 1);//Parte Entera X
            genEjemplo[3] = new IntegerGene(configuracion, 0, 1);//Parte Entera X
            genEjemplo[4] = new IntegerGene(configuracion, 0, 1);//Parte Entera X
            
            
            genEjemplo[5] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[6] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[7] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[8] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[9] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[10] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[11] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[12] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[13] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[14] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[15] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[16] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[17] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[18] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[19] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[20] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[21] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[22] = new IntegerGene(configuracion, 0, 1);//Parte Entera Y
            genEjemplo[23] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[24] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[25] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[26] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[27] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[28] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3
            genEjemplo[29] = new IntegerGene(configuracion, 0, 1);//Parte decimal nivel de precision = 3

            //Recordemos que los cromosomas son el correspondiente a los individuos
            //Creamos un individuo a partir de la configuracion de los genes anterior
            Chromosome cromosomaNumero = new Chromosome(configuracion, genEjemplo);
            //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo de ejemplo que creamos
            configuracion.setSampleChromosome(cromosomaNumero);
            configuracion.setPopulationSize(5); //Creamos nuestra poblacion inicial
            //Creamos el genotipo de la poblacion
            //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
            Genotype population = Genotype.randomInitialGenotype(configuracion);
            //Comienza a iterar el algoritmo
            System.out.println("Poblacion inicial");
            Mostrar show = new Mostrar();
            for (int m = 0; m < 10; m++) { //50 iteraciones, cada iteracion sera una generacion
                System.out.println("-------------------Inicio generacion-------------------");
                System.out.println("Iteracion #" + m);
                show.mostrarTodosIndividuos(population.getChromosomes());
                population.evolve(10);
                //show.mostrarTodosIndividuos(population.getChromosomes());
                IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                //System.out.println("Mejor Individuo de la generacion " + m + " :");
                show.mostrarIndividuo(mejor_individuo);
                System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
                System.out.println("-------------------Fin generacion-------------------");
            }
            /*Al final de las iteraciones, obtenemos el mejor individuo,
             * para nuestro ejemplo, es el cuadrado que no repite valores
             * en sus casillas, y cuya suma de lineas verticales, horizontales y
             * diagonales es 15
             */
            System.out.println("Mejor individuo: ");
            show.mostrarIndividuo(population.getFittestChromosome()); //mejor individuo obtenido
           obj = (Object[]) show.retornarIndividuo(population.getFittestChromosome());
            
           

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");
        }
        
      return (Object[]) obj;
    }
}
