package kr.or.dgit.ncs_erp.app.title;

import java.awt.BorderLayout;
import java.util.ArrayList;
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

	private Object[] getColumn() {
		return new String[]{"번호","직책"};
	}

	private Object[][] getRowData() {
		List<Title> listForTable = new ArrayList<Title>(list);
		Object[][] datas = new Object[listForTable.size()][];
		for(int i=0; i<datas.length; i++){
			datas[i] = listForTable.get(i).toArray();
		}
		return datas;
	}

	public JTable getTable() {
		return table;
	}
	

	public List<Title> getList() {
		return list;
	}

	public void setList(List<Title> list) {
		this.list = list;
	}
	
	
	
	
}
