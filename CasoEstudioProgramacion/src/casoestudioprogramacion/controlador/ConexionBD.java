package casoestudioprogramacion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private static Connection conexion;

	public ConexionBD() {
		conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://mysql-seriestv.alwaysdata.net:3306/"
					+ "seriestv_bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
					+ "&serverTimezone=UTC", "seriestv", "INTRODUCTORIOi15");
			
			
			if (conexion != null) {
				System.out.println("Conexión exitosa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
			}	
	}
	/**
	 * 
	 * @return la conexión a la bd
	 */
	public Connection getConnection() {
		return conexion;
	}
	
	/**
	 * Termina la conexión a ala base de datos
	 */
	public void desconect() {
		conexion = null;
		if (conexion == null) {
			System.out.println("La base de datos se ha desconectado");
		}
	}
/**
	public void getDatos(){
    try{
    	Statement st = 
	    String query = "SELECT * FROM seriestvitems ";
	    rs = st.excuteQuery(query);
	
	    
	    while(rs.nex()){
	        }
	    }catch(Exception e){
	    e.printStackTrace();
    
	    }
    }
   */

}