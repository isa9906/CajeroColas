
package logica;

/**
 * @author Isabel Pérez
 */
public class Nodo {
   private String nombre;
   private int servicios;
   private Nodo siguiente;
   
  public Nodo (String nombre,int servicios,Nodo siguiente){
      this.nombre=nombre;
      this.servicios=servicios;
      this.siguiente=siguiente;
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getServicios() {
        return servicios;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
 
}
