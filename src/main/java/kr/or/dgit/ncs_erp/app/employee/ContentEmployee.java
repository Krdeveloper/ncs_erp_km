package kr.or.dgit.ncs_erp.app.employee;

import java.awt.Component;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import framework.ComboPanel;
import framework.RadioPanel;
import framework.SpinnerPanel;
import framework.TextFieldFormatPanel;
import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.DepartmentService;
import kr.or.dgit.ncs_erp.service.EmployeeService;
import kr.or.dgit.ncs_erp.service.TitleService;

public class ContentEmployee extends JPanel {

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private ComboPanel<String> pTitle;
	private SpinnerPanel pSalary;
	private RadioPanel pSex;
	private ComboPanel<String> pDeptName;
	private TextFieldFormatPanel pJoinDate;
	private List<Title> titleList;
	private List<Department> deptList;

	/**
	 * Create the panel.
	 */
	public ContentEmployee() {
		setLayout(new GridLayout(0, 1, 0, 10));

		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);
		//pNo.setLayout(new BoxLayout(pNo, BoxLayout.X_AXIS));

		pName = new TextFieldPanel();
		pName.setTitle("사원명");
		add(pName);

		pTitle = new ComboPanel<>();
		pTitle.setTitle("직책");
		add(pTitle);

		pSalary = new SpinnerPanel();
		pSalary.setValues(1500000, 1000000, 5000000, 100000);
		pSalary.setTitle("급여");
		add(pSalary);

		pSex = new RadioPanel();
		pSex.setRadioItems("남", "여");
		pSex.setTitle("성별");
		add(pSex);

		pDeptName = new ComboPanel<>();
		pDeptName.setTitle("부서");
		add(pDeptName);

		pJoinDate = new TextFieldFormatPanel();
		pJoinDate.setMaskPattern("####-##-##", '#');
		pJoinDate.setTfValue(String.format("%tF", new Date()));
		pJoinDate.setTitle("입사일");
		add(pJoinDate);
		
		setComboTitle();
		setComboDepartment();
		resetField();

	}

	private void setComboDepartment() {
		pDeptName.getTf().removeAllItems();
		deptList = DepartmentService.getInstance().selectDepartmentByAll();
		Vector<String> v = new Vector<>();
		v.removeAllElements();		
		for (int i = 0; i < deptList.size(); i++) {
			v.add(deptList.get(i).toCombo());
		}
		pDeptName.setComboData(v);

	}

	private void setComboTitle() {
		pTitle.getTf().removeAllItems();
		titleList = TitleService.getInstance().selectTitleByAll();
		Vector<String> v = new Vector<>();
		v.removeAllElements();		
		for (int i = 0; i < titleList.size(); i++) {
			v.add(titleList.get(i).toCombo());
		}
		pTitle.setComboData(v);

	}
	public void setEmpField(Employee employee){
		pNo.setTfValue(employee.getNo());
		pName.setTfValue(employee.getName());
		pTitle.setSelectedItem(employee.getTitle().getName());
		pDeptName.setSelectedItem(
				employee.getDepartment().getName());		
		pSalary.setValue(employee.getSalary());
		pJoinDate.setTfValue(employee.geteJoinDate());
		// System.out.println("====================");
		pSex.setSelectedItem(employee.isSex()?"남":"여");
		
	}

	public void resetField() {
		setEmployeeCode(); 	
		pSex.setSelectedItem(0);
		pDeptName.setSelectedItem(0);
		pTitle.setSelectedItem(0);
		pName.setTfValue("");
		pSalary.setValues(1500000, 1000000, 5000000, 100000);
		pJoinDate.setTfValue(String.format("%tF", new Date()));

	}

	private void setEmployeeCode() {
		List<Employee> list = EmployeeService.getInstance().selectEmployeeByAll();
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

	public TextFieldPanel getpName() {
		return pName;
	}

	public Employee getObject(){
		String no = pNo.getTfValue();
		String name = pName.getTfValue();
		String title = titleList.get(pTitle.getSelectedItemIdx()).getNo();
		int salary = (int) pSalary.getValue();
		boolean sex = pSex.getSelectedItem().equals("남")?true:false;
		String department = deptList.get(pDeptName.getSelectedItemIdx()).getNo();
		String joinDate = pJoinDate.getTfValue();
		return new Employee(no, name, new Title(title), salary, sex, new Department(department), joinDate);
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
