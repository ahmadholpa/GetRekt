package Addressbook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/*
 * 
 * 
 * 
 * 1
 */
public class AddBookGui extends JFrame implements ActionListener{
	private volatile AddressBook book1;
	private JPanel mainPanel,secPanel;
	private JMenuBar menuBar;
	private JMenu menu, menu2;
	private JMenuItem create, save, addBud, removeBud, displayBud, editBud;
	private JTextField box1, box2, box3;
	private BuddyInfo b1,b2,b3,bn;
	private ListDemo LD;
	private JList<String> countryList;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private JButton addButton, removeButton, editButton;
	private JList buddyNames;
	private JScrollPane scrollPane;
	
	public AddBookGui(){
		//jLDemo

		
		b1=new BuddyInfo("Ahmad","riverside",613261);
		b2=new BuddyInfo("Kd","KK",613261);
		b3=new BuddyInfo("Ud","UU",613261);
		book1 = new AddressBook("book1");
		book1.addBuddy(book1,b1);
		book1.addBuddy(book1,b2);
		book1.addBuddy(book1,b3);
		LD= new ListDemo(book1);
		
		//setup mainPanel
		mainPanel = new JPanel();
		layout = new GridBagLayout();
		mainPanel.setLayout(layout);
		constraints = new GridBagConstraints();
		getContentPane().add(mainPanel);
		//getContentPane().add(secPanel);
		
		secPanel= new JPanel();
		secPanel.setLayout(new BorderLayout());
		
		
		//Create Menu//
		menuBar = new JMenuBar();
		menu = new JMenu("Address Book");
		menu2 = new JMenu("Buddy Options");
		
		//menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuBar.add(menu2);
		this.setJMenuBar(menuBar);
		
		//add items to menu AddressBook
		create = new JMenuItem("New Entry");
		save = new JMenuItem("Save Book");
		menu.add(create);
		menu.add(save);            
		
		//add items to menu Buddy Options
		addBud = new JMenuItem("Add");
		removeBud = new JMenuItem("Remove");
		displayBud = new JMenuItem("Display");
		editBud = new JMenuItem("Edit it");
		menu2.add(displayBud);
		menu2.add(addBud);
		menu2.add(removeBud);
		menu2.add(editBud);
		
		
		// adding JTExt
		box1 = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 4;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.insets = new Insets(5,5,5,5);
		layout.setConstraints(box1, constraints);
		mainPanel.add(box1);
		//box2= new JTextField("box2");
		//mainPanel.add(box2,BorderLayout.SOUTH);
		//box3= new JTextField("box3");
		//mainPanel.add(box3,BorderLayout.SOUTH);
		
		//adding Buttons
		//Add Button - Display
		addButton = new JButton("Add");
		addButton.setMnemonic('A');
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(10,10,10,10);
		constraints.ipadx = 3;
		constraints.ipady = 3;
		layout.setConstraints(addButton, constraints);
		mainPanel.add(addButton);
		
		//Add Button - Function
		/*addButton.addActionListener(new ActionListener(){ 
			actionPerformed("Add"));
		}*/
		
		removeButton = new JButton("Remove");
		removeButton.setMnemonic('R');
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(10,10,10,10);
		constraints.ipadx = 3;
		constraints.ipady = 3;
		layout.setConstraints(removeButton, constraints);
		mainPanel.add(removeButton);
		
		editButton = new JButton("Edit");
		editButton.setMnemonic('E');
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(10,10,10,10);
		layout.setConstraints(editButton, constraints);
		constraints.ipadx = 3;
		constraints.ipady = 3;
		mainPanel.add(editButton);
		
		//Add Scroll Panel
		buddyNames = new JList(book1.getContactNames());
		scrollPane = new JScrollPane(buddyNames, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 4;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 10;
		constraints.weighty = 1;
		constraints.insets = new Insets(5,5,5,5);
		layout.setConstraints(scrollPane, constraints);
		mainPanel.add(scrollPane);
		
		
		//Add ACTIONLISTENER
		displayBud.addActionListener(this);
		addBud.addActionListener(this);
		create.addActionListener(this);
		save.addActionListener(this);
		removeBud.addActionListener(this);
		editBud.addActionListener(this);
		
		// adding JList
		/*DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");

        //create the list
        countryList = new JList<>(listModel);
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = countryList.getSelectedValuesList();
                    System.out.println(selectedValuesList);
                }
            }
        });

        
        mainPanel.add(countryList);*/
   

    } //end of constructor
		
	// New Entery will pop new window ! the others still down
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Display")){
			box1.setText(book1.printContacts());
			System.out.println("Display clicked\n"+book1.printContacts());
		} else if (e.getActionCommand().equals("Add")){
			bn = new BuddyInfo("Josh","SKY",89798798);
			book1.addBuddy(book1, bn);
			System.out.println("Added into bookAddress");
		} else if (e.getActionCommand().equals("Save Book")){
			System.out.println("Book Saved");
		} else if(e.getActionCommand().equals("New Entry")){
			// should have a window to enter new entry
			//book1 = new AddressBook(box1.getText());
			addBuddy();
		}else if(e.getActionCommand().equals("Edit it")){
			//LD.createAndShowGUI(book1);
			/*secPanel.add(new JScrollPane(countryList),BorderLayout.PAGE_END);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setTitle("JList Example");
	        this.setSize(200, 200);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);*/
			
			editBuddy();
		}
		
	}// end actionPerformed
	
	private void addBuddy(){
		//BuddyInfo aNewBuddy = new BuddyInfo();
		//book1.addBuddy(book, newBuddy);
		
		PopUpWindow dialog = new PopUpWindow(this,"New Buddy Details", true, book1, "Add");
		dialog.setVisible(true);
	}
	
	private void editBuddy(){
		//BuddyInfo selectedBuddy;
		//int selectedIndex = book1.getBuddyList().getSelectedIndex();
		
		/*if (selectedIndex >= 0) {
			if (selectedBuddy == null)
				return;*/
			PopUpWindow dialog = new PopUpWindow(this,"Edit Buddy Details", true, book1, "Edit");
			dialog.setVisible(true);
		
	}
	
	public static void main(String args[]){
		//Create gui and set main frame parameters
		AddBookGui gui = new AddBookGui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 500);
		gui.setVisible(true);
		gui.setTitle("AddressBook");
		
	}// end main
	
}// end class

