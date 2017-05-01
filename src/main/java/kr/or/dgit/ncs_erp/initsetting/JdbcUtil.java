package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtil {
	
	public static void close(Statement pstmt, Connection connection){
		close(pstmt);
		close(connection);
	}
	
	public static void close(ResultSet rs, Statement pstmt, Connection connection){
		close(rs);
		close(pstmt);
		close(connection);
	}
	
	public static void close(Statement pstmt){
		if (pstmt != null){
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public static void close(ResultSet rs){
		if (rs != null){
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public static void close(Connection connection) {
		if (connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}
