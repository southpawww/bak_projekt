package bp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author marek
 */
public class DatabaseConnection {

    //Connection to Database
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","marek","marek");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}
     //close connection
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}