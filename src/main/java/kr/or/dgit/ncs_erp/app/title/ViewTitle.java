package kr.or.dgit.ncs_erp.app.title;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.TitleService;


public class ViewTitle extends JFrame implements ActionListener {
	protected List<Title> list;
	private TableTitle pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentTitle pContent;
	

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

			

		});

		getContentPane().add(pTable);
		
		setTable();
		setVisible(true);
		
	}

	

	

	

	private void setTable() {
		list = TitleService.getInstance().selectTitleByAll();
		pTable.setList(list);
		pTable.setTableData();
		
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

	
}

