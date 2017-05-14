package kr.or.dgit.ncs_erp.app.title;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.TitleService;

public class ContentTitle extends JPanel {
	private JTextField textField;
	private TextFieldPanel pNo;
	private TextFieldPanel pTitle;
	
	

	public ContentTitle() {
		setLayout(new GridLayout(0, 1, 0, 0));

		pNo = new TextFieldPanel();
		pNo.setTitle("번호");
		add(pNo);

		pTitle = new TextFieldPanel();
		pTitle.setTitle("직책명");
		add(pTitle);
		
		resetField();

	}

	public void resetField() {
		setTitleNo(); 
		pTitle.setTfValue("");
		pTitle.gettF().requestFocus();

	}

	
	private void setTitleNo() {		
		List<Title> list = TitleService.getInstance().selectTitleByAll();
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
		return pTitle;
	}

	public Title getObject() {
		String no = pNo.getTfValue();
		String name = pTitle.getTfValue();
		return new Title(no, name);

	}

	
	public void setObject(Object[] supplyCompanyObj) {// take data from table
		// TODO Auto-generated method stub
		pNo.setTfValue(String.valueOf(supplyCompanyObj[0]));
		pTitle.setTfValue(String.valueOf(supplyCompanyObj[1]));

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
