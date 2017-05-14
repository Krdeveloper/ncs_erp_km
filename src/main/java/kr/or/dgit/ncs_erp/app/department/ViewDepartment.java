package kr.or.dgit.ncs_erp.app.department;

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
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.DepartmentService;
import kr.or.dgit.ncs_erp.service.TitleService;


public class ViewDepartment extends JFrame implements ActionListener {
	protected List<Department> list;
	private TableDepartment pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentDepartment pContent;
	protected JPopupMenu popUp;
	

	public ViewDepartment() throws HeadlessException {
		setTitle("부서 관리");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setBounds(500, 200, 700, 500);

		pContent = new ContentDepartment();
		getContentPane().add(pContent);

		JPanel pBtn = new JPanel();
		getContentPane().add(pBtn);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		pTable = new TableDepartment();
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
				Object[] deptObj = getTableData();   
				pContent.setObject(deptObj);
				btnAdd.setText("수정");				
			}
			if (e.getActionCommand().equals("삭제")){
				Object[] deptObj = getTableData();   
				pContent.setObject(deptObj);
				DepartmentService.getInstance().deleteDepartmentItem(new Department(pContent.getpNo().getTfValue()));
				list=DepartmentService.getInstance().selectDepartmentByAll();
				pTable.setList(list);;
				pTable.setTableData();
				pContent.resetField();				
				
			}			
		}
	};
	
	private Object[] getTableData() {//each data in the table
		int cnt = pTable.getTable().getColumnCount();
		System.out.println(cnt);
		int tableRowData = pTable.getTable().getSelectedRow();
		System.out.println(tableRowData);
		Object[] obj = new Object[cnt];
		for(int i=0; i<cnt; i++){
			obj[i] = pTable.getTable().getValueAt(tableRowData, i);
		}      
		return obj;
	}
	private void setTable() {
		list = DepartmentService.getInstance().selectDepartmentByAll();
		pTable.setList(list);
		pTable.setTableData();
	}
	

	public TableDepartment getpTable() {
		return pTable;
	}

	public ContentDepartment getpContent() {
		return pContent;
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
				DepartmentService.getInstance().insertDepartmentItem(pContent.getObject());
				list = DepartmentService.getInstance().selectDepartmentByAll();
				pTable.setList(list);
				pTable.setTableData();
				pContent.resetField();
			}
		}else if (e.getActionCommand().equals("수정")) {
			DepartmentService.getInstance().updateDepartmentItem(pContent.getObject());   
			list = DepartmentService.getInstance().selectDepartmentByAll();
			pTable.setList(list);
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

