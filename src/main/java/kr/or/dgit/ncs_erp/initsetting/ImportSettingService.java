package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;

import javax.swing.JOptionPane;


public class ImportSettingService extends ServiceSetting{//복원 service
	private Connection connection;
	
	public ImportSettingService() {
		DBCon dbCon = new DBCon();
		connection = dbCon.getConnection();
	}


	@Override
	public void initSetting() {//복원
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.selectUseDatabase(connection);
		
		for(int i=0; i<Config.TABLE_NAME.length; i++){//Config.TABLE_NAME에 있는 table 돌림
			TableDao.getInstance().executeImportData(connection, getFilePath( Config.TABLE_NAME[i], true), Config.TABLE_NAME[i]);
		}		
		JdbcUtil.close(connection);
		JOptionPane.showMessageDialog(null, "복원 완료!!!!!");
	}
	
	
}

