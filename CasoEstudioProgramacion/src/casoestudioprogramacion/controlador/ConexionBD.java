package casoestudioprogramacion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
	private static Connection conexion;

	/**
	 * 
	 */
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
	 * Termina la conexi�n a ala base de datos
	 */
	public void desconect() {
		conexion = null;
		if (conexion == null) {
			System.out.println("La base de datos se ha desconectado");
		}
	}
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public ResultSet consultarSerie(String codigo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM seriestvitems WHERE Codigo = ?";

		try {
			ConexionBD dbConexion = new ConexionBD();
			Connection con = dbConexion.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, codigo);
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return rs;

	}
	
	


}