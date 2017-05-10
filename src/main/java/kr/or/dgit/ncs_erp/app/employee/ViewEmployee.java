package kr.or.dgit.ncs_erp.app.employee;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.dto.Title;
import javax.swing.border.EmptyBorder;

public class ViewEmployee extends JFrame implements ActionListener {
	protected List<Employee> list;
	private TableEmployee pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentEmployee pContent;
	

	public ViewEmployee(){
		setTitle("사원 관리");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setBounds(500, 200, 700, 500);

		pContent = new ContentEmployee();
		pContent.setBorder(new EmptyBorder(0, 0, 0, 100));
		getContentPane().add(pContent);

		JPanel pBtn = new JPanel();
		getContentPane().add(pBtn);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		pTable = new TableEmployee();
		pTable.getTable().addMouseListener(new MouseAdapter() {

			

		});

		getContentPane().add(pTable);

		
	}

	
	

	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		
	}

	private boolean isValidcheck() {
		return pContent.isEmpty();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.resetField();
		
	}	

	
	public String setNoName() {
		
		return "E%03d";
	}
	
}
