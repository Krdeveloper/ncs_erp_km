package kr.or.dgit.ncs_erp.app.title;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs_erp.dto.Title;

public class TableTitle extends JPanel{
	private JTable table;
	private List<Title> list;
	public TableTitle() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	protected void setTableData(){
		table.setModel(new DefaultTableModel(getRowData(), getColumn()));
	}

	private Vector getColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	private Vector getRowData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
