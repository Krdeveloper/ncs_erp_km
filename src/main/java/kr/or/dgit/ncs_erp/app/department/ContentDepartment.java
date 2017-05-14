package kr.or.dgit.ncs_erp.app.department;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.DepartmentService;
import kr.or.dgit.ncs_erp.service.TitleService;

public class ContentDepartment extends JPanel {

	private TextFieldPanel pNo;
	private TextFieldPanel pDeptName;
	private TextFieldPanel pFloor;

	public ContentDepartment() {
		setLayout(new GridLayout(0, 1, 0, 0));

		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);

		pDeptName = new TextFieldPanel();
		pDeptName.setTitle("부서명");
		add(pDeptName);
		
		pFloor = new TextFieldPanel();
		pFloor.setTitle("위치");
		add(pFloor);
		
		resetField();

	}

	public void resetField() {
		setDepartmentNo(); 
		pDeptName.setTfValue("");
		pFloor.setTfValue("");
		pDeptName.gettF().requestFocus();

	}

	
	
	private void setDepartmentNo() {
		List<Department> list = DepartmentService.getInstance().selectDepartmentByAll();
		if(list.size()==0){
			pNo.setTfValue("1");    
		}else{
			pNo.setTfValue(String.valueOf(list.size()+1));
			pNo.gettF().setEditable(false);
		}
		
	}

	public TextFieldPanel getpNo() {
		return pNo;
	}

	public TextFieldPanel getpDeptName() {
		return pDeptName;
	}

	public TextFieldPanel getpFloor() {
		return pFloor;
	}

	public Department getObject() {
		String no = pNo.getTfValue();
		String deptName = pDeptName.getTfValue();
		int floor = Integer.parseInt(pFloor.getTfValue());
		return new Department(no, deptName, floor);

	}

	public void setObject(Object[] departmentObj) {// take data from table
		// TODO Auto-generated method stub
		pNo.setTfValue(String.valueOf(departmentObj[0]));
		pDeptName.setTfValue(String.valueOf(departmentObj[1]));
		pFloor.setTfValue(String.valueOf(departmentObj[2]));

	}

	public boolean isEmpty() {

		for (Component c : getComponents()) {
			if (c instanceof TextFieldPanel) {
				TextFieldPanel tfp = (TextFieldPanel) c;
				if (tfp.isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
}
