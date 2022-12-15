package intranet;

import java.util.Vector;

public class Transcript {
	
	public int numberOfFailedCourses;
	public Vector<Journal> journals;
	
	public Transcript(){
		numberOfFailedCourses = 0;
	}
	
	public Transcript(Vector<Journal> journals){
		this();
		this.journals = journals;
	}
	
	{
	if(numberOfFailedCourses >= 3)
		leaveUniversity();
	}

	private void leaveUniversity() {
		//removeUser?
	}
}
