package kr.or.dgit.ncs_erp.initsetting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class TableDao {
	private static TableDao instance = new TableDao();

	private TableDao() {
	}

	public static TableDao getInstance() {
		return instance;
	}

	public void createTable(Connection connection, String sql, String tblName) {
		try (PreparedStatement pstmt= connection.prepareStatement(sql);){
			pstmt.execute();
			System.out.printf("CREATE TABLE(%s) Success! %n", tblName);
		} catch (SQLException e) {
			System.out.printf("CREATE TABLE(%s) Fail! %n", tblName);
			e.printStackTrace();
		} 
	}	

	
	
	public void executeExportData(Connection connection, String sql, String tablePath, String tableName) {
		try (PreparedStatement pstmt= connection.prepareStatement(sql);	ResultSet rs = pstmt.executeQuery();){
			String res= createBackupToString(rs, tableName);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(tablePath)));){
				bw.write(res);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
		} 
	}

	private String createBackupToString(ResultSet rs, String tableName){
		StringBuilder sb = new StringBuilder();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= colCount; i++) {
					sb.append(rs.getObject(i)+",");
				}
				sb.replace(sb.length()-1, sb.length(), "");//마지막 , 제거
				sb.append("\n");
			}
			sb.replace(sb.length()-1, sb.length(), "");	//마지막 \n 제거
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public void executeImportData(Connection connection, String tablePath, String tableName) {
		String sql = String.format(Config.IMPORT_SQL, tablePath, tableName);
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n", tableName, pstmt.getUpdateCount());
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} 
	}
}
