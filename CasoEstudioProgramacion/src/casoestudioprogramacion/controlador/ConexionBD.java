package casoestudioprogramacion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    public static void conectarMySQL() {
        Connection conn = null;
        System.out.println("Método conectar MySQL");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql-seriestv.alwaysdata.net:3306/"
                    + "seriestv_bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
                    + "&serverTimezone=UTC", "seriestv", "INTRODUCTORIOi15");
            if (conn != null){
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }
}