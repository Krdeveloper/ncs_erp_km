package kr.or.dgit.ncs_erp.app.department;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;

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
		setDeliveryCode(); 
		pDeptName.setTfValue("");
		pDeptName.gettF().requestFocus();

	}

	
	
	private void setDeliveryCode() {
		/*---------------not yet----------------*/
		
		pNo.setTfValue("D001");               
		pNo.gettF().setEditable(false);
		
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

	/*public Department getObject() {
		String no = pNo.getTfValue();
		String deptName = pDeptName.getTfValue();
		return new Department(no, deptName);

	}*/

	public void setObject(Department item) {
		/*not yet*/

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
