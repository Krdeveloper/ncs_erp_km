package kr.or.dgit.ncs_erp.initsetting;



public abstract class ServiceSetting {
	
    protected static String getFilePath(String tableName, boolean isImport) {
        StringBuilder sb = new StringBuilder();
        sb.append(isImport ? Config.IMPORT_DIR : Config.EXPORT_DIR).append(tableName).append(".txt");
        return sb.toString().replace("\\", "/");
    }   

	public abstract void initSetting();
}
