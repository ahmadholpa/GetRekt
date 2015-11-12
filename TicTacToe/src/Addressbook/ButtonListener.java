package Addressbook;

import javax.swing.*;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonListener implements ActionListener {

	private JButton button1;
	private JMenuItem display;
	public ButtonListener(JMenuItem display,JButton button1){
		this.button1 = button1;
		this.display = display;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
