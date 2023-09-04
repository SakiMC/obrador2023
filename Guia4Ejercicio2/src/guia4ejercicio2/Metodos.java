
package guia4ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mtcer
 */
public class Metodos {
    public static void agregarEmpleados(int dni, String apellido, String nombre, int acceso,boolean estado, Connection con){
    String sql= "INSERT INTO empleado (dni, apellido, nombre, acceso, estado) VALUES "+
            " ("+dni+ ", '"+ apellido+ "', '"+ nombre+"', "+acceso+ ", "+estado+");";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            int resultado= ps.executeUpdate();//MANDAMOS EL MENSAJE
            JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente. Fila modificada "+ resultado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar empleado "+ ex.getMessage());
        }
    }
        
    public static void insertarHerramientas(String nombre, String descripcion, int stock, int disponible, Connection con) {
        String sql = "INSERT INTO herramienta (nombre, descripcion, stock, disponible) VALUES ('" + nombre + "', '" + descripcion + "', " + stock + ", " + disponible + ");";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            int resultado = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Herramienta agregada a base de datos. Fila modificada "+ resultado);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar herramienta"+ ex.getMessage());
        }

    }
        
    
    public void  listarHerramientasPorStock(int stock, Connection con){
        try {
            System.out.println("Herramientas con stock mayor o igual a "+ stock);
            System.out.println("----------------------------------------------");
            String sql= "SELECT * FROM herramienta WHERE stock>="+stock+";";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet listaHerramientas= ps.executeQuery();
            while(listaHerramientas.next()){
                System.out.println("Herramienta: "+ listaHerramientas.getString("nombre"));
                System.out.println("ID_herramienta: " + listaHerramientas.getInt("ID_herramienta"));
                System.out.println("Descripción: "+ listaHerramientas.getString("descripcion"));
                System.out.println("Stock: "+ listaHerramientas.getInt("stock"));
                System.out.println("Disponible para prestamo: "+ listaHerramientas.getInt("disponible"));
                System.out.println("------------------------------------------");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar herramientas" + ex.getMessage());
        }
 
    }
    
    
        
    public static List<Herramienta>  listaHerramientas( Connection con){
        Herramienta h= null;
         List <Herramienta> lista= new ArrayList<>();
        try {
            System.out.println("Listado de herramientas");
            System.out.println("----------------------------------------------");
            String sql= "SELECT * FROM herramienta";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet listaHerramientas= ps.executeQuery();
            while(listaHerramientas.next()){
                h= new Herramienta();
                h.setID_herramienta(listaHerramientas.getInt("ID_herramienta"));
                h.setDescripcion(listaHerramientas.getString("descripcion"));
                h.setNombre(listaHerramientas.getString("nombre"));
                h.setStock(listaHerramientas.getInt("stock"));
                h.setDisponible(listaHerramientas.getInt("disponible"));
                lista.add(h);
                System.out.println(h);
   
                System.out.println("------------------------------------------");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar herramientas" + ex.getMessage());
        }
    return lista;
    }
    
    
    public static void darBajaEmpleado(int dni, Connection con){
        try {
            System.out.println("Para no afectar la base de datos se cambiara el estado del empleado a inactivo (0)");
            System.out.println("----------------------------------------------");
            String sql= "UPDATE empleado SET estado=0 WHERE dni="+dni+";";
            PreparedStatement pst= con.prepareStatement(sql);
            int rdo= pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se registro como inactivo al empleado DNI "+dni+ ". Filas afectadas="+ rdo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modfiicar estado del empleado"+  ex.getMessage());
        }
    
    
    }
                
    }

