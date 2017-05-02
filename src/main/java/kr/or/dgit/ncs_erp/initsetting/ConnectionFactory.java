package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ConnectionFactory instance = new ConnectionFactory();
	
	public static Connection getInstance(){
		return instance.createConnection();
	}
	private Connection createConnection(){
		Connection connection = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/ncs_erp_km";
			String user = "user_ncs";
			String password = "user_ncs";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error:Unable to Connection DataBase");
		}
		return connection;
	}
	private ConnectionFactory(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("MySQL Driver not Found!!");
			System.exit(-1);
		}
	}
}
