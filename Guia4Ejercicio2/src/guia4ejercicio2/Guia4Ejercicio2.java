
package guia4ejercicio2;

import factory.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author mtcer
 */
public class Guia4Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection prueba= ConnectionFactory.getConexion();
       // Metodos.agregarEmpleados(22345871, "Hitachi", "Minako", 2, true, prueba);
       //Metodos.listarHerramientas(5, prueba);
       // Metodos.darBajaEmpleado(33487645, prueba);
       Metodos.listaHerramientas(prueba);

    }
    
}
