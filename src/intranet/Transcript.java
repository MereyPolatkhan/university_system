package intranet;

import java.util.Vector;

public class Transcript {
	
	public int numberOfFailedCourses;
	public Vector<Journal> journals;
	
	{
	if(numberOfFailedCourses >= 3)
		leaveUniversity();
	}

	private void leaveUniversity() {
		//removeUser?
	}
	
}
