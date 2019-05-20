package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/magenta?characterEncoding=latin1&useConfigs=maxPerformance","root","-098poiu");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Unable to establish connection.");
		}
		return con;
	}
}
