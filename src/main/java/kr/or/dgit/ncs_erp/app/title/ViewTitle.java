package kr.or.dgit.ncs_erp.app.title;

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

import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.TitleService;


public class ViewTitle extends JFrame implements ActionListener {
	protected List<Title> list;
	private TableTitle pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentTitle pContent;
	private JPopupMenu popUp;

	public ViewTitle() throws HeadlessException {
		setTitle("직책 관리");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setBounds(500, 200, 700, 500);

		pContent = new ContentTitle();
		getContentPane().add(pContent);

		JPanel pBtn = new JPanel();
		getContentPane().add(pBtn);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		pTable = new TableTitle();
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
				Object[] titleObj = getTableData();   
				pContent.setObject(titleObj);
				btnAdd.setText("수정");				
			}
			if (e.getActionCommand().equals("삭제")){
				Object[] titleObj = getTableData();   
				pContent.setObject(titleObj);
				TitleService.getInstance().deleteTitleItem(new Title(pContent.getpNo().getTfValue()));
				list=TitleService.getInstance().selectTitleByAll();
				pTable.setList(list);;
				pTable.setTableData();
				pContent.resetField();				
				
			}			
		}
	};

	private void setTable() {
		list = TitleService.getInstance().selectTitleByAll();
		pTable.setList(list);
		pTable.setTableData();
		
	}


	public TableTitle getpTable() {
		return pTable;
	}



	public ContentTitle getpContent() {
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
				TitleService.getInstance().insertTitleItem(pContent.getObject());
				list = TitleService.getInstance().selectTitleByAll();
				pTable.setList(list);
				pTable.setTableData();
				pContent.resetField();
			}
			
		}else if (e.getActionCommand().equals("수정")) {
			TitleService.getInstance().updateTitleItem(pContent.getObject());   
			list = TitleService.getInstance().selectTitleByAll();
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

