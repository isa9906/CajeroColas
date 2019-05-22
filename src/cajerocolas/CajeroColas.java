/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajerocolas;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import logica.Cola;

/**
 *
 * @author estudiantes
 */
public class CajeroColas {
    
    
    public static void main(String[] args) {
    Cola cola = new Cola();
      
        insertar(cola);
        atender(cola);
        
    }
    public static void insertar(Cola cola) {
        
	TimerTask insertar = new TimerTask() {
	    public void run() {
	        String turnoAtendido="";
	        System.out.println("Insertando..."+ new Date());
	        System.out.println(cola.enqueue("Prueba "+(int)((Math.random()*200)+1)));
                 System.out.println(cola.Mostrar());
	     }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 2000L; //retraso del hilo
	    long period = 2000L; //período de retraso
	    timer.scheduleAtFixedRate(insertar, delay, period);
	}
    
    
    
    public static void atender(Cola cola) {
        
	TimerTask atender = new TimerTask() {
	    public void run() {
	        String turnoAtendido="";
	        System.out.println("Atendiendo..."+ new Date());
	        System.out.println(cola.dequeue());
                System.out.println(cola.Mostrar());
	     }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 4000L; //retraso del hilo
	    long period = 4000L; //período de retraso
	    timer.scheduleAtFixedRate(atender, delay, period);
	}
    
}
