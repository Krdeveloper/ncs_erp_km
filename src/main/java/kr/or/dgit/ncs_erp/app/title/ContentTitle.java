package kr.or.dgit.ncs_erp.app.title;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.dto.Title;

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
		setDeliveryCode(); 
		pTitle.setTfValue("");
		pTitle.gettF().requestFocus();

	}

	
	private void setDeliveryCode() {
		/*---------------not yet----------------*/
		
		pNo.setTfValue("T001");               
		pNo.gettF().setEditable(false);
	     
		
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

	public void setObject(Title item) {
		pNo.setTfValue(item.getNo());
		pTitle.setTfValue(item.getName());

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
