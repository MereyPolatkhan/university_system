package intranet;

import java.util.HashMap;

public class Journal{
	
    public Period period;
    HashMap<Course, Mark> courses;
    
    public Journal() {}
    
    public Journal(Period period, HashMap<Course, Mark> courses ) {
    	this.period = period;
    	this.courses = courses;
    }
    
    public Double showTotal(Course course) {
    	return courses.get(course).digitGrade;
    }
	
}
 
