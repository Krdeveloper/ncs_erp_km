package kr.or.dgit.ncs_erp.initsetting;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class DbApp  extends JFrame implements ActionListener {	
	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackup;
	private JButton btnRestore;

	public DbApp() {
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);

		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		
		contentPane.add(btnInit);
		contentPane.add(btnBackup);
		contentPane.add(btnRestore);
	}

	public void actionPerformed(ActionEvent e) {
		ServiceSetting create = null;
		if (e.getSource() == btnRestore) {
			create = new ImportSettingService();
		} else if (e.getSource() == btnBackup) {
			create = new ExportSettingService();
		} else if (e.getSource() == btnInit) {
			create = new InitSettingService();
			
		}
		create.initSetting();
	}
	
	public static void main(String[] args) {
		DbApp main = new DbApp();
		main.setVisible(true);
	}
	
}