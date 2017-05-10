package kr.or.dgit.ncs_erp.app.department;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;

public class TableDepartment extends JPanel {
	protected List<Department> list;
	protected JTable table;
	
	public TableDepartment() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setViewportView(table);
	}

	public void setTableData() {
		table.setModel(new DefaultTableModel(getRowData(),getColumn()));			
	}
	
			

	
	private Object[] getColumn() {
		return new String[]{"번호","직책"};
	}

	private Object[][] getRowData() {
		List<Department> listForTable = new ArrayList<Department>(list);
		Object[][] datas = new Object[listForTable.size()][];
		for(int i=0; i<datas.length; i++){
			datas[i] = listForTable.get(i).toArray();
		}
		return datas;
	}

	public JTable getTable() {
		return table;
	}

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}
	
	
	
	
}
