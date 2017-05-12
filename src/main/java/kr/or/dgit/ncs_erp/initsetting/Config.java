package kr.or.dgit.ncs_erp.initsetting;

public class Config {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static final String DB_NAME = "ncs_erp_km"; //생성할 db명
	public static final String PJT_USER = "user_ncs"; //생성할 user명
	public static final String PJT_PASSWD = "user_ncs"; //password
	
	public static final String[] TABLE_NAME = { "title","department", "employee"}; //생성할 table명
	
	public static final String EXPORT_DIR = System.getProperty("user.dir")+ "\\BackupFiles\\"; //백업 폴더
	public static final String IMPORT_DIR = System.getProperty("user.dir")+ "\\DataFiles\\"; //복원 폴더
	
	public static final String IMPORT_SQL="LOAD DATA LOCAL INFILE '%s' IGNORE INTO TABLE %s character set 'UTF8' fields TERMINATED by ','";
	
	/*------------*/
	public static final String[] EXPORT_SQL = {//각 테이블의 데이타들을 백업하기 위한 쿼리
			"select tcode, tname from title", 
			"select dcode, dname, floor from department",
			"select eno, ename, salary, dno, gender, joindate,title from employee"
	};
	/*----------*/

	public static final String[] CREATE_SQL_TABLE={
			/*직책*/
			"CREATE TABLE title ("
			+ "tcode int(11)  NOT NULL,"
			+ "tname VARCHAR(10) null,"	
			+ "primary key (tcode))"
			,
			/*부서*/
			"CREATE TABLE department ("
			+ "dcode         int(11)  not NULL ,"
			+ "dname   char(10) not NULL, "
			+ "floor       INT(11) NULL, "			
			+ "primary key (dcode))"
			,
			/*사원*/
			"CREATE TABLE employee ("
			+ "eno		  INT(11) not null,  "
			+ "ename      VARCHAR(20) NOT NULL,  "
			+ "salary      INT(11) NULL,  "
			+ "dno    INT(11) NULL,  "
			+ "gender TINYINT(1) NULL,  "
			+ "joindate DATE NULL,  "
			+ "title int(11),  "
			+ "primary key(eno), "
			+ "FOREIGN KEY (dno) REFERENCES department (dcode)     ON UPDATE CASCADE,   "
			+ "FOREIGN KEY (title)        REFERENCES title (tcode)       ON UPDATE CASCADE  )    "   		
								
	};
	
	
			  
}
