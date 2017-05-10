package framework;
import java.awt.GridLayout;

import javax.swing.JTextField;

public class TextFieldPanel extends CompPanel {
	private JTextField tF;

	/**
	 * Create the panel.
	 */
	public TextFieldPanel() {
		pValue.setLayout(new GridLayout(1, 0,0,0));
		
		tF = new JTextField();
		pValue.add(tF);
		

	}
	public void setTfValue(String value){
		tF.setText(value);
	}
	
	public String getTfValue(){
		return tF.getText().trim();
	}
	
	public JTextField gettF() {
		return tF;
	}
	public boolean isEmpty(){
		boolean result = false;
		if(tF.getText().equals("")){
			tF.requestFocus();
			result = true;
			
		}
		return result;
	}

}
