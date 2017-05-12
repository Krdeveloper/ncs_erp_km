package kr.or.dgit.ncs_erp.app.employee;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Employee;

public class TableEmployee extends JPanel {
	private JTable table;
	private List<Employee> employeeList;

	public JTable getTable() {
		return table;
	}

	public TableEmployee() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		
	}

	public void setTableData() {// set table
		// TODO Auto-generated method stub
		table.setModel(new DefaultTableModel(getRowData(), getColumn()));
	}

	protected Object[][] getRowData() {
		List<Employee> listForTable = new ArrayList<Employee>(employeeList);
		Object[][] datas = new Object[listForTable.size()][];
		for(int i=0; i<datas.length; i++){
			datas[i] = listForTable.get(i).toArray();
		}
		return datas;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	protected String[] getColumn(){//table column
	      return new String[]{"번호","사원명","직책","급여","성별","부서","입사일"};
	}
}
