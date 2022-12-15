package Model;

import java.util.*;

public class Journal{
	
    public Period period;
    
    public HashMap<Course, Mark> courses; // courses and marks
    
    public Journal() {}

	public Journal(Period period, HashMap<Course, Mark> courses) {
		this.period = period;
		this.courses = courses;
	};
	
//	public showTotal() {
		// что можем туда написать?
//	}
}
