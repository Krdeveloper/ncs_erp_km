package framework;

import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.util.Vector;

@SuppressWarnings("serial")
public class ComboPanel<T> extends CompPanel {
	private JComboBox<T> tf;
	
	public ComboPanel() {
		pValue.setLayout(new GridLayout(1, 0, 0, 0));
		tf = new JComboBox<>();
		pValue.add(tf);
		
	}
	
	public void setComboData(Vector<T> items){
		for(T t : items){
			tf.addItem(t);
		}
	}
	
	public Object getSelectedItem(){
		return tf.getSelectedItem();
	}
	
	public void setSelectedItem(T item){
		tf.setSelectedItem(item);
	}
	
	public void setSelectedItem(int idx){
		tf.setSelectedIndex(idx);
	}

}
