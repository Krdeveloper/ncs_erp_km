package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {

	private Connection connection;
	
	
	public DBCon() {
		try {			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "rootroot");
		} catch (SQLException e) {
			System.err.println("연결 실패 - 사용자 정보 및 드라이버를 찾을 수 없음");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			new DBCon();
		}
		return connection;
	}
	
}
