package kr.or.dgit.ncs_erp.app.employee;

import java.awt.Component;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import framework.ComboPanel;
import framework.RadioPanel;
import framework.SpinnerPanel;
import framework.TextFieldFormatPanel;
import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Employee;
import kr.or.dgit.ncs_erp.dto.Title;

public class ContentEmployee extends JPanel {

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private ComboPanel<Title> pTitle;
	private SpinnerPanel pSalary;
	private RadioPanel pSex;
	private ComboPanel<Department> pDeptName;
	private TextFieldFormatPanel pJoinDate;

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
		
		resetField();

	}

	public void resetField() {
		setDeliveryCode(); 	
		pSex.setSelectedItem(0);
		

	}

	private void setDeliveryCode() {
		pNo.setTfValue("E001");
		pNo.gettF().setEditable(false);
		
	}

	public TextFieldPanel getpNo() {
		return pNo;
	}

	public TextFieldPanel getpName() {
		return pName;
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
