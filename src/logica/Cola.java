/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author estudiantes
 */
public class Cola {
    private Nodo cajero;
    private Nodo primero;
    private Nodo ultimo;
    int tam=0;
    
    public Cola() {
        cajero=new Nodo ("Cajero",0,cajero);
        primero=cajero;
        ultimo=cajero;
        tam=0;
    }
    public boolean estaVacia (){
        return primero==cajero;
    }
    public int size (){
        return tam;
    }
    public String enqueue (String nombre){
        Nodo aux = new Nodo(nombre,(int)(Math.random()*8)+1,cajero);
        if (estaVacia()){
           primero=aux;
           cajero.setSiguiente(primero);
        }
        else{
            if(size()==1){
                 primero.setSiguiente(aux);
            }
            else{
                ultimo.setSiguiente(aux);
            }
        }
        ultimo=aux;
        return aux.getNombre()+ " "+ aux.getServicios()+ " ha ingresado a la cola";
    }
    public String enqueue (String nombre,int servicios){
        Nodo aux = new Nodo(nombre,servicios,cajero);
        if (estaVacia()){
           primero=aux;
           cajero.setSiguiente(primero);
        }
        else{
           if(size()==1){
                 primero.setSiguiente(aux);
            }
            else{
                ultimo.setSiguiente(aux);
            }
        }
        ultimo=aux;
        return aux.getNombre()+ " "+ aux.getServicios()+ " ha ingresado a la cola";
    }
    
    public String dequeue(){
        if (!estaVacia()){
            if (primero.getServicios()>3){
             enqueue(primero.getNombre(),primero.getServicios()-3);    
            }
            Nodo aux2=primero;
            Nodo aux = primero.getSiguiente();
            primero=aux;
            return "atendiendo a "+ aux2.getNombre()+ " "+aux2.getServicios();
        }
        else{
            return "Esperando....";
        }
    }
    public String Mostrar() {
        if (estaVacia()){
            return "No hay clientes en cola";
        }
        else{
            String cadena = "";
            Nodo aux = primero;
            while (aux!=cajero){
                cadena+=aux.getNombre() +" "+ aux.getServicios()+"\n";
                aux =aux.getSiguiente();
            }        
            return cadena;
        }
    }
}
