import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private String user = "root";
	private String pass = "NoGameNoLife1998";
	private static String db = "escalafon";
	static String url = "jdbc:mysql://localhost" + db;
	private Connection conn = null;

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
