package kr.or.dgit.ncs_erp.initsetting;

import java.io.File;
import java.sql.Connection;



public class ExportSettingService extends ServiceSetting {
	private Connection connection;

	public ExportSettingService() {
		DBCon dbCon = new DBCon();
		connection = dbCon.getConnection();
	}

	@Override
	public void initSetting() {
		DataBaseDao.getInstance().selectUseDatabase(connection);
		
		File backupDir = new File(Config.EXPORT_DIR);
		if (backupDir.exists()) {
			for (File file : backupDir.listFiles()) {
				file.delete();
				System.out.printf("%s Delete Exist File Success! %n", file.getAbsolutePath());
			}
		}
		for (int i=0; i<Config.EXPORT_SQL.length; i++) {
			TableDao.getInstance().executeExportData(connection, Config.EXPORT_SQL[i],  getFilePath(Config.TABLE_NAME[i], false), Config.TABLE_NAME[i]);
			System.out.println("BackUp Success!" + " Table["+Config.TABLE_NAME[i]+"]");
		}
				
		JdbcUtil.close(connection);
	}

	

}