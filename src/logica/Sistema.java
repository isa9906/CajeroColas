package logica;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Sistema {

    private boolean estaDibujando;
    private static int i = 0, numero = 1;
    private Image imagen;

    public void insertar(Cola cola) {

        TimerTask insertar = new TimerTask() {
            public void run() {
                i++;
                //System.out.println("Insertando..." + new Date());
                System.out.println(cola.enqueue("Usuario " + i));
                System.out.println(cola.Mostrar());
            }
        };
        Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
        long delay = 7000L; //retraso del hilo
        long period = 7000L; //período de retraso
        timer.scheduleAtFixedRate(insertar, delay, period);
    }

    public void atender(Cola cola) {

        TimerTask atender = new TimerTask() {
            public void run() {
                numero++;
                if (numero == 5) {
                    numero = 1;
                }
                imagen = new ImageIcon(this.getClass().getResource("/imagenes/Cliente" + numero + ".png")).getImage();

                System.out.println(cola.dequeue());
                System.out.println(cola.Mostrar());

            }
        };
        Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
        long delay = 9000L; //retraso del hilo
        long period = 9000L; //período de retraso

        timer.scheduleAtFixedRate(atender, delay, period);
    }

    public Image getImagen() {
        return imagen;
    }

    public Sistema() {
        estaDibujando = true;
    }

    public int getI() {
        return i;
    }

    public boolean isEstaDibujando() {
        return estaDibujando;
    }

    public void setEstaDibujando(boolean estaDibujando) {
        this.estaDibujando = estaDibujando;
    }

}
