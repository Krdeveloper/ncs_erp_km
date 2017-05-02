package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class UserDao {
	private static UserDao instance = new UserDao();
	
	private PreparedStatement pstmt;
	
	private UserDao() {}

	public static UserDao getInstance() {
		return instance;
	}

	public void createUserAndGrant(Connection connection) {//user에 select, insert, update, delete 권한부여 및 생성
		String sql = "grant select, insert, update, delete on " + Config.DB_NAME+ ".* to ? identified by ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, Config.PJT_USER);
			pstmt.setString(2, Config.PJT_PASSWD);
			pstmt.execute();
			System.out.printf("Create User(%s) Success! %n", Config.PJT_USER);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}