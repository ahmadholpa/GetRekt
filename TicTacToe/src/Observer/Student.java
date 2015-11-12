package Observer;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}

	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Prof o= (Prof) arg0;
		String s= (String)arg1;

		if(s.equals("soon"))
		{
			this.study(o.getMidterm());
			System.out.println("OMG OMG PANIC BUTTON ACTIVATED");
		}else if( s.equals("later"))
		{
			this.party(o.getMidterm());
			System.out.println("Parrttyy all night");
		}
		//System.out.println("wtheck");


	}
}
