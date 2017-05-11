package kr.or.dgit.ncs_erp;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



import kr.or.dgit.ncs_erp.initsetting.ConnectionFactory;
import kr.or.dgit.ncs_erp.initsetting.DBCon;

public class DataBaseTest {
	private static Connection connection;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = ConnectionFactory.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection = null;
	}

	/*@Test
	public void aTestDBConnection() {
		Assert.assertNotNull(connection);
	}

	@Test
	public void bTestDBExists() throws SQLException {
		String sql = "SELECT 1 FROM Information_schema.SCHEMATA WHERE SCHEMA_NAME = 'ncs_erp_km'";
		int result = getQueryResult(sql);
		Assert.assertEquals(1, result);
	}

	@Test
	public void cTestEmployeeTableExists() throws SQLException {
		String sql = "SELECT 1 FROM Information_schema.tables WHERE TABLE_SCHEMA = 'ncs_erp_km' and table_name = 'employee'";
		int result = getQueryResult(sql);
		Assert.assertEquals(1, result);
	}

	@Test
	public void dTestDepartmentTableExists() throws SQLException {
		String sql = "SELECT 1 FROM Information_schema.tables WHERE TABLE_SCHEMA = 'ncs_erp_km' and table_name = 'department'";
		int result = getQueryResult(sql);
		Assert.assertEquals(1, result);
	}

	@Test
	public void eTestTitleTableExists() throws SQLException {
		String sql = "SELECT 1 FROM Information_schema.tables WHERE TABLE_SCHEMA = 'ncs_erp_km' and table_name = 'title'";
		int result = getQueryResult(sql);
		Assert.assertEquals(1, result);
	}

	private int getQueryResult(String sql) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			result = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return result;
	}*/
}
