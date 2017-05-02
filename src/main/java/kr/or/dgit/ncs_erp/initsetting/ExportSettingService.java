package kr.or.dgit.ncs_erp.initsetting;

import java.io.File;
import java.sql.Connection;

import javax.swing.JOptionPane;



public class ExportSettingService extends ServiceSetting {//백업 service
	private Connection connection;

	public ExportSettingService() {
		DBCon dbCon = new DBCon();
		connection = dbCon.getConnection();
	}

	@Override
	public void initSetting() {
		DataBaseDao.getInstance().selectUseDatabase(connection);
		
		File backupDir = new File(Config.EXPORT_DIR);
		if (backupDir.exists()) {//백업시에 그 파일이 존재한다면 파일을 삭제
			for (File file : backupDir.listFiles()) {
				file.delete();
				System.out.printf("%s If Exist Then Delete the Files Success! %n", file.getAbsolutePath());
			}
		}
		for (int i=0; i<Config.EXPORT_SQL.length; i++) {//백업
			TableDao.getInstance().executeExportData(connection, Config.EXPORT_SQL[i],  getFilePath(Config.TABLE_NAME[i], false), Config.TABLE_NAME[i]);
			System.out.println("BackUp Success!" + " Table["+Config.TABLE_NAME[i]+"]");
		}
				
		JdbcUtil.close(connection);
		JOptionPane.showMessageDialog(null, "백업 완료!!!!!");
	}

	

}