package kr.or.dgit.ncs_erp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_erp.initsetting.ExportSettingService;
import kr.or.dgit.ncs_erp.initsetting.ImportSettingService;
import kr.or.dgit.ncs_erp.initsetting.InitSettingService;
import kr.or.dgit.ncs_erp.initsetting.ServiceSetting;



public class ErpApp  extends JFrame implements ActionListener {	
	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackup;
	private JButton btnRestore;
	private JButton btnDepartment;
	private JButton btnTitle;
	private JButton btnEmployee;
	private ServiceSetting create=null;

	public ErpApp() {
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		
		
		btnTitle = new JButton("직책");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		
		btnDepartment = new JButton("부서");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
		
		btnEmployee = new JButton("사원");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		contentPane.add(btnInit);

		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		contentPane.add(btnBackup);
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		contentPane.add(btnRestore);
		
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {//사원
			actionPerformedBtnEmployee(e);
		}
		if (e.getSource() == btnDepartment) {//부서
			actionPerformedBtnDepartment(e);
		}
		if (e.getSource() == btnTitle) {//직책
			actionPerformedBtnTitle(e);
		}		
		if (e.getSource() == btnInit) {//초기화
			actionPerformedBtnInit(e);			
		}
		if (e.getSource() == btnBackup) {//백업
			actionPerformedBtnBackUp(e);			
		}
		if (e.getSource() == btnRestore) {//복원
			actionPerformedBtnRestore(e);			
			
		}
		
	}
	
	private void actionPerformedBtnRestore(ActionEvent e) {
		create = new ImportSettingService();
		create.initSetting();
	}

	private void actionPerformedBtnBackUp(ActionEvent e) {
		create = new ExportSettingService();
		create.initSetting();
	}

	private void actionPerformedBtnInit(ActionEvent e) {		
		create = new InitSettingService();
		create.initSetting();
	}	
	
	protected void actionPerformedBtnTitle(ActionEvent e) {
		
	}
	protected void actionPerformedBtnDepartment(ActionEvent e) {
		
	}
	protected void actionPerformedBtnEmployee(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		ErpApp main = new ErpApp();
		main.setVisible(true);
	}
}