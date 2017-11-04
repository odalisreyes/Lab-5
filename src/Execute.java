import java.sql.ResultSet;

/**
 * @author javia
 *
 */
public class Execute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection conexion = new DBConnection();
		ResultSet resultado;
		
		resultado = conexion.getQuery("select * from test");

	}

}
