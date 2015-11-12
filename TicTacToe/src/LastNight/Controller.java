import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private View view;
	private Model model;
	public Controller()
	{
		view= new View();
		model= new Model();
		this.view.buttonVL1(new ButtonCL1());
		
		view.setVisible(true);
	}
	
	class ButtonCL1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().matches("button"+0))
			{
				view.getButtons(0).setText("yolo");
				view.getButtons(0).setEnabled(false);
				view.getRect();
			}
		}
	
	}
	
	public static void main(String args[])
	{
		Controller c= new Controller();
		
	}


}

