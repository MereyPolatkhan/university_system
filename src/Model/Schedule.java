package Model;

import java.util.Map;
import java.util.Vector;

public class Schedule {
	
	public int totalCredits;
	public Vector<Course> courses;
	Map<Course, Lesson> schedule;

    public void generateSchedule() {// type need to be Schedule
//    	this.courses.stream()
//    	.sorted(new ComparatorCoursesByWeekDays);
        for(Course course : courses) {
        	
        	Teacher t = course.getTeachers().stream()
        			.filter(t->t.)
        			;
        	//print all possible lessons
        	course.allPossibleLessons.toString();
        	
        	//student enter/select time and teacher
        	//check if there another course at that time
        	if(course.allPossibleLessons) // ???
        	
        	//save schedule in a collection / Vector<Vector<Course>> schedule(7);
        }
    }
    
    // add some fields to Course class:
    // 	• all possible lessons

}

/*
 * class Course{
 * public Map<Teacher, Lesson> allPossibleLessons;
 * }
 */

