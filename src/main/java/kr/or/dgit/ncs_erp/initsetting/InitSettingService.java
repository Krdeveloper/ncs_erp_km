package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;

import javax.swing.JOptionPane;



public class InitSettingService extends ServiceSetting {//초기화
	private Connection connection;
	
	public InitSettingService() {
		DBCon dbCon = new DBCon();
		connection = dbCon.getConnection();
	}

	public void initSetting() {
		createDataBase();	// database 생성(ncs_erp_km)
		createTable(); 	// table 생성(title, department, employee)	
		createUser(); 		// user 생성(user_ncs)	
		JdbcUtil.close(connection);
		JOptionPane.showMessageDialog(null, "초기화 완료!!!!!");
	}

	

	private void createDataBase() {
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.createDatabase(connection);
		dao.selectUseDatabase(connection);
	}

	private void createTable() {
		TableDao dao = TableDao.getInstance();
		for (int i = 0; i < Config.TABLE_NAME.length; i++) {
			dao.createTable(connection, Config.CREATE_SQL_TABLE[i], Config.TABLE_NAME[i]);
		}
	}

	
	
	private void createUser() {
		UserDao.getInstance().createUserAndGrant(connection);
	}

}
