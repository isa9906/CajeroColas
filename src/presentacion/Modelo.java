package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import logica.Cola;
import logica.Sistema;

public class Modelo implements Runnable {

    private Sistema miSistema;
    private Cola cola;
    private Vista ventanaPrincipal;
    private Thread hiloDibujo;
    private BufferedImage dobleBuffer;

    public Modelo() {
        cola = new Cola();
        hiloDibujo = new Thread(this);
        dobleBuffer = new BufferedImage(getVentanaPrincipal().getLienzo().getWidth(), getVentanaPrincipal().getLienzo().getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    public Sistema getMiSistema() {
        if (miSistema == null) {
            miSistema = new Sistema();
        }
        return miSistema;
    }

    public Vista getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new Vista(this);
        }
        return ventanaPrincipal;
    }

    public void iniciar() {
        empezarVentana();
        hiloDibujo.start();
    }

    public void empezarVentana() {

        getMiSistema().setEstaDibujando(true);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        getVentanaPrincipal().setSize(900, 550);
        getVentanaPrincipal().setTitle("Simulacion de Procesos");// Coloca nombre a la ventana        
        getVentanaPrincipal().setDefaultCloseOperation(EXIT_ON_CLOSE);
        getVentanaPrincipal().setVisible(true);
    }

    @Override
    public void run() {
        while (getMiSistema().isEstaDibujando()) {
            dibujar();
        }
    }

    private void dibujar() { // Importante donde yo ire a trabajar

        Image imagen, imagen2;
        String mensaje, mensaje2,mensaje3;
        Color colorTablero = new Color(0, 29, 29);

        Canvas lienzo = getVentanaPrincipal().getLienzo();
        Graphics lapiz = lienzo.getGraphics();
        Graphics lapizInvisible = dobleBuffer.getGraphics();
        lapizInvisible.setColor(colorTablero);

        lapizInvisible.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        //imagen = new ImageIcon(this.getClass().getResource("/imagenes/fondo.png")).getImage();
        imagen = new ImageIcon(this.getClass().getResource("/imagenes/Foto.jpg")).getImage();
        lapizInvisible.drawImage(imagen, 0, 60, lienzo);

        lapizInvisible.setColor(Color.WHITE);
        Font font = new Font("Agency FB", Font.BOLD, 18);
        lapizInvisible.setFont(font);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        mensaje = hourdateFormat.format(date);
        lapizInvisible.drawString(mensaje, 390, 30);
        
        mensaje3=("VENTANILLA DE ATENCION");
        lapizInvisible.drawString(mensaje3, 5, 50);

        mensaje2 = ("TURNOS: \n" + cola.Mostrar());

        Image imagenPersonaje = miSistema.getImagen();
        if (cola.Mostrar() == "No hay clientes en cola") {
        } else {
            lapizInvisible.drawImage(imagenPersonaje, 200, 100, lienzo);
        }
        ventanaPrincipal.getjTextArea().setBackground(colorTablero);
        ventanaPrincipal.getjTextArea().setFont(font);
        ventanaPrincipal.getjTextArea().setForeground(Color.white);
        ventanaPrincipal.getjTextArea().setText(mensaje2);

        lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
    }

    public void comenzar() {
        //System.exit(0);
        miSistema.insertar(cola);
        miSistema.atender(cola);

    }

}
