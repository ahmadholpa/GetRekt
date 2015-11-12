package EventHandling;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private TeachingAssistant ta;
	
	// why cant do private List<CourseListener> XX; //?????
	private List<CourseListener> courseL;
	//private ArrayList<CourseListener> courseL;

	public Prof(String aName) {
		this.name = aName;
		this.students = new ArrayList<Student>();
		this.courseL= new ArrayList<CourseListener>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate=date;
		CourseEvent ce= new CourseEvent(this);
		
		// now update each one in the list with set midterm method
		for(CourseListener cl:courseL)
		{
			cl.midtermAnnounced(ce);
		}
		
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate=date;
		CourseEvent ce= new CourseEvent(this);
		
		
		// now update each one in the list
		for(CourseListener cl:courseL)
		{
			cl.midtermPostponed(ce);
		}
		
	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		//p.addStudent(s);
		//p.addStudent(s2);
		//p.setTA(ta);
	
		p.courseL.add(s);
		p.courseL.add(s2);
		p.courseL.add(ta);
		
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
