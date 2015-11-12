package Addressbook;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PopUpWindow extends JDialog implements ActionListener{
	private AddressBook aBook;
	
	private JLabel aName, aNumber, anAddress;
	private JTextField nameField, numberField, addressField;
	private JButton okButton, cancelButton;
	private JPanel labelPanel, textPanel;
	
	public PopUpWindow(Frame owner, String title, boolean modal, AddressBook bk, String mode){
		super(owner,title,modal);
		aBook = bk;
		buildDialogWindow(aBook, mode);
		//fix
		/*okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				okButtonClicked();
			}
		});
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				cancelButtonClicked();
			}
		});*/
		
		setSize(300,300);
		setLocationRelativeTo(owner);
	} //end of constructor
	
	public void buildDialogWindow(AddressBook aBook, String mode){
		//Label Side -- vertical layout
		labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.Y_AXIS));
		
		aName = new JLabel("Name:");
		aName.setHorizontalAlignment(JLabel.LEFT); 
		labelPanel.add(aName);

		anAddress = new JLabel("Address:");
		anAddress.setHorizontalAlignment(JLabel.LEFT); 
		labelPanel.add(anAddress);
		
		aNumber = new JLabel("Number:");
		aNumber.setHorizontalAlignment(JLabel.LEFT); 
		labelPanel.add(aNumber);

		//TextField Side -- vertical layout
		textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
		
		//check whether add or edit
		if(mode == "Add"){
			nameField = new JTextField("");
			addressField = new JTextField("");
			numberField = new JTextField("");
		} else {  //edit mode
			//*******************************
			//needs to pull information of a buddy to be displayed
			
			/*nameField = new JTextField(aBook->aBuddy.getName());
			addressField = new JTextField(aBook->aBuddy.getAddress());
			numberField = new JTextField(aBook->aBuddy.getNum());*/
		}
		textPanel.add(nameField);
		textPanel.add(addressField);
		textPanel.add(numberField);
		
		//Putting Label & TextField sides together -- horizontal layout
		getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
		getContentPane().add(labelPanel);
		getContentPane().add(textPanel);
		
		okButton = new JButton("OK");
		getContentPane().add(okButton);
		cancelButton = new JButton("Cancel");
		getContentPane().add(cancelButton);
	} //end of buildDialogWindow
	
	private void okButtonClicked(){
		//**********************************************
		//need to push information of a buddy to book & GUI
		
		/*aBook.setName(nameField.getText());
		aBook.setAddress(addressField.getText());
		aBook.setNum(Integer.parseInt(numberField.getText()));
		aBook.*/
		dispose();
	} //end of okButtonClicked
		
	private void cancelButtonClicked(){
		dispose();
	} //end of cancelButtonClicked

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
