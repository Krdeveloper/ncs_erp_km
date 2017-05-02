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
	
	public void createDatabase(Connection connection) {//db 생성 method 만약 그 db가 이미 존재한다면 drop하고 생성
		try {
			pstmt = connection.prepareStatement("CREATE DATABASE " + Config.DB_NAME);//db생성 쿼리준비
			pstmt.execute(); //쿼리 실행
			System.out.printf("CREATE DATABASE(%s) Success! %n", Config.DB_NAME);
		} catch (SQLException e) {
			if (e.getErrorCode()==1007){//db가 존재하고 있다면 follow this error
				System.out.printf("DATABASE(%s) Exist! %n", Config.DB_NAME);
				dropDatabase(connection);//db가 존재하고 있으니 drop
				createDatabase(connection);//db 생성
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	private void dropDatabase(Connection connection) {//db를 drop시키는 method
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

	public void selectUseDatabase(Connection connection) {//db 사용
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
