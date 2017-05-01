package kr.or.dgit.ncs_erp.initsetting;

import java.sql.Connection;


public class ImportSettingService extends ServiceSetting{
	private Connection connection;
	
	public ImportSettingService() {
		DBCon dbCon = new DBCon();
		connection = dbCon.getConnection();
	}


	@Override
	public void initSetting() {
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.selectUseDatabase(connection);
		
		for(int i=0; i<Config.TABLE_NAME.length; i++){
			TableDao.getInstance().executeImportData(connection, getFilePath( Config.TABLE_NAME[i], true), Config.TABLE_NAME[i]);
		}		
		JdbcUtil.close(connection);
	}
	
	
}

