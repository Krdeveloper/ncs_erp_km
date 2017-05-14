package kr.or.dgit.ncs_erp.app.employee;

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
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.service.EmployeeService;

public class ViewEmployee extends JFrame implements ActionListener {
	protected List<Employee> list;
	private TableEmployee pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentEmployee pContent;
	private JPopupMenu popUp;

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
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()== MouseEvent.BUTTON3){
					popUp.show(pTable, e.getX(), e.getY());
				}
			}		

		});
		popUp = createPopUp();
		getContentPane().add(pTable);
		
		setTable();
		setVisible(true);
	}

	

	private JPopupMenu createPopUp() {
		JPopupMenu menu = new JPopupMenu();		
		JMenuItem update = new JMenuItem("수정");
		update.addActionListener(menuListener);
		JMenuItem del = new JMenuItem("삭제");
		del.addActionListener(menuListener);
		menu.add(update);
		menu.add(del);
		return menu;
	}
	
	ActionListener menuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")){
				showFieldFromTable();
				btnAdd.setText("수정");				
			}
			if (e.getActionCommand().equals("삭제")){
				System.out.println("================================");
				showFieldFromTable();
				EmployeeService.getInstance().deleteEmployeeItem(new Employee(pContent.getpNo().getTfValue()));
				list=EmployeeService.getInstance().selectEmployeeByAll();
				pTable.setEmployeeList(list);
				pTable.setTableData();
				pContent.resetField();				
				
			}			
		}
		
	};

	
	private void setTable() {
		list = EmployeeService.getInstance().selectEmployeeByAll();
		pTable.setEmployeeList(list);
		pTable.setTableData();
		
	}
	public void showFieldFromTable(){//수정 클릭시 필드에 선택된table 값 띄우기 (ref)
		String selectedCode = (String) pTable.getTable().getValueAt(pTable.getTable().getSelectedRow(), 0);      
		int selectedIdx = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getNo().equals(selectedCode)){
				selectedIdx=i;
				break;
			}
		}      
		Employee employee = list.get(selectedIdx);
		pContent.setEmpField(employee);      

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
		if (e.getActionCommand().equals("추가")) {
			if (isValidcheck()) {// 공백 체크
				JOptionPane.showMessageDialog(null, "입력해야될 값이 있습니다. 확인하세요");
			} else {
				EmployeeService.getInstance().insertEmployeeItem(pContent.getObject());
				list = EmployeeService.getInstance().selectEmployeeByAll();
				pTable.setEmployeeList(list);
				pTable.setTableData();
				pContent.resetField();
			}
		}else if (e.getActionCommand().equals("수정")) {
			EmployeeService.getInstance().updateEmployeeItem(pContent.getObject());   
			list = EmployeeService.getInstance().selectEmployeeByAll();
			pTable.setEmployeeList(list);
			pTable.setTableData();
			btnAdd.setText("추가");
			pContent.resetField();//필드초기화
		}
	}

	private boolean isValidcheck() {
		return pContent.isEmpty();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.resetField();
		
	}		
	
	
}
