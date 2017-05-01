package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DataBaseDao {
	private PreparedStatement pstmt;
	
	private static DataBaseDao instance = new DataBaseDao();

	private DataBaseDao() { }

	public static DataBaseDao getInstance() {
		return instance;
	}
	
	public void createDatabase(Connection connection) {
		try {
			pstmt = connection.prepareStatement("CREATE DATABASE " + Config.DB_NAME);
			pstmt.execute();
			System.out.printf("CREATE DATABASE(%s) Success! %n", Config.DB_NAME);
		} catch (SQLException e) {
			if (e.getErrorCode()==1007){
				System.out.printf("DATABASE(%s) Exist! %n", Config.DB_NAME);
				dropDatabase(connection);
				createDatabase(connection);
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	private void dropDatabase(Connection connection) {
		try {
			pstmt = connection.prepareStatement("DROP DATABASE IF EXISTS " + Config.DB_NAME);
			pstmt.execute();
			System.out.printf("DROP DATABASE(%s) Success! %n", Config.DB_NAME);
		} catch (SQLException e) {
			System.out.printf("DROP DATABASE(%s) Fail! %n", Config.DB_NAME);
		} finally {
			JdbcUtil.close(pstmt);
		}		
	}

	public void selectUseDatabase(Connection connection) {
		try{
			pstmt = connection.prepareStatement("USE " + Config.DB_NAME);
			pstmt.execute();
			System.out.printf("USE DATABASE(%s) Selected Success! %n", Config.DB_NAME);
		} catch (SQLException e) {
			System.out.printf("USE DATABASE(%s) Selected Fail! %n", Config.DB_NAME);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}		
	}	

}
