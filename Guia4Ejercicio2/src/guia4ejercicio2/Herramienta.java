
package guia4ejercicio2;

/**
 *
 * @author mtcer
 */
public class Herramienta {
    private int ID_herramienta;
    private String nombre;
    private String descripcion; 
    private int stock;
    private int disponible;

    public Herramienta(int ID_herramienta, String nombre, String descripcion, int stock, int disponible) {
        this.ID_herramienta = ID_herramienta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.disponible = disponible;
    }

    public Herramienta(String nombre, String descripcion, int stock, int disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.disponible = disponible;
    }
    
    public Herramienta(){}

    public int getID_herramienta() {
        return ID_herramienta;
    }

    public void setID_herramienta(int ID_herramienta) {
        this.ID_herramienta = ID_herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString(){
        return "ID_herramienta: "+ ID_herramienta + "\nNombre: "+ nombre + "\nDescripcion: "+ descripcion+ "\nStock: "+ stock+ 
               "\nDisponible: "+ disponible;
    }
}
