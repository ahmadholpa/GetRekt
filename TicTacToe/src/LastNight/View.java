import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame{
	
	private JButton JB[];
	
	public View()
	{
		this.setLayout(new GridLayout(3,3));
		this.setSize(500,500);
		JB= new JButton[9];
		for(int i=0;i<9;i++)
		{
			JB[i]= new JButton("-");
			JB[i].setActionCommand("button"+i);
			JB[i].setEnabled(true);
			this.add(JB[i]);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		

	}
	public void buttonVL1(ActionListener AL)
	{
		for(int i=0;i<9;i++)
		{
			JB[i].addActionListener(AL);
		}
	}
	
	public JButton getButtons(int i)
	{
		return JB[i];
	}
	public void getRect()
	{
		JOptionPane.showMessageDialog(null,"GG NOOB");
		
	}
}
