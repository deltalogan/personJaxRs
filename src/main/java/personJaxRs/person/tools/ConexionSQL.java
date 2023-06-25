package personJaxRs.person.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

	private static String host = "localhost";

	private static String dataBaseName = "afip";

	private static String user = "root";

	private static String password = "qwe-7890";

	private static String servicePort = "3306";

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage().toString());
		}

		String url = "jdbc:mysql://" + host + ":" + servicePort + "/" + dataBaseName;

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {

			System.out.println(e.getMessage().toString());
		}

		return connection;
	}

	public static void main(String[] args) {

		try {
			Connection connection;

			connection = getConnection();

			System.out.println("Status Connection: ON " + connection);
			connection.close();
		} catch (SQLException e) {

			System.out.println(e.getMessage().toString());
		}
	}
}