package kr.or.dgit.ncs_erp.app.department;

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


public class ViewDepartment extends JFrame implements ActionListener {
	protected List<Title> list;
	private TableDepartment pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	protected ContentDepartment pContent;
	

	public ViewDepartment() throws HeadlessException {
		setTitle("직책 관리");
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
				/*-------------not yet--------------*/

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

	
}

