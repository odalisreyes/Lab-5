import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * PROPOSITO: Es la clase que hace la conexion de SQL
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 3nd, 2017.
 *
 */
public class DBConnection {
	
	/* ATRIBUTOS */
	private String user = "root";
	private String pass = "NoGameNoLife1998";
	private static String db = "escalafon";
	static String url = "jdbc:mysql://localhost" + db;
	private Connection conn = null;

	

	/**
	 * Constructor de la clase
	 * Comprueba la conexion con la base de datos e ingresa los datos del host
	 */
	public DBConnection() {
		try {
			Class.forName("con.mysql.jdbc.Connection");
			conn = (Connection) DriverManager.getConnection(url, user, pass);
			if (conn != null) {
				System.out.println("Ok");
			}
		} catch (SQLException ex) {
			System.out.println("Error: " + ex);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	
	/**
	 * Get del Query
	 * 
	 * @param _query
	 * @return resultado de tipo ResultSet
	 */
	public ResultSet getQuery(String _query) {
		Statement state = null;
		ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * Set del Query
	 * 
	 * @param _query
	 */
	public void setQuery(String _query) {
		Statement state = null;
		try {
			state = (Statement) conn.createStatement();
			state.execute(_query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
