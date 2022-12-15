package intranet;

import java.util.HashMap;

public class Journal{
	
    public Period period;
    HashMap<Course, Mark> courses;
    
    public Double showTotal(Course course) {
    	return courses.get(course).digitGrade;
    }
	
}
