
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mtcer
 */
public class ConnectionFactory {
    private static String dir= "jdbc:mariadb://localhost:3307/guia3_ejercicio4";
    private static String user= "root";
    private static String pass= "";
    private static ConnectionFactory con= null;
    
    private ConnectionFactory(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar drivers. Verifique si importo la libreria mariadb " + ex.getMessage());
        }
    }
    
    //METODO PARA CONECTARSE A LA BASE DE DATOS
    public static Connection getConexion(){ //PUBLICO SINO NO LO PUEDO LLAMAR DEL MAIN
    Connection conBase= null;
    if(con==null){
    con= new ConnectionFactory();
        try {
            conBase= DriverManager.getConnection(dir, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con base de datos" + ex.getMessage());
        }
    }
      return conBase; //EL METODO DEVUELVE LA CONEXION A LA BASE, VER QUE ES TIPO CONNECTION Y NO CONEXION  
    }
    
    //METODO PARA DAR BAJA A EMPLEADO
   
    
}
