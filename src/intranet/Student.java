package intranet;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student extends UserDecorator {
	
	private HashMap<Course, Mark> currentCoursesMarks;
    public Period period;
    private Transcript transcrcipt;
    public Organization organization;
    public StudentLevel level;
    public int year;
    public Department department;
    public Speciality studentSpeciality;
    private int scholarship;
    private Schedule schedule;
    public double generalGPA;
    
    public int getScholarship() {
    	return scholarship;
    }
    public Schedule getSchedule() {
    	return schedule;
    }
    
    public void setMark(Course course, Mark mark) {
    	currentCoursesMarks.put(course, mark);
    } 
    
    public Student(User user) {
		super(user);
	}
    
    public Student(User user, Department department, Speciality studentSpeciality, StudentLevel level, int year) {
    	super(user);
    	this.department = department;
    	this.studentSpeciality = studentSpeciality;
    	this.level = level;
    	this.year = year;
    } 

    //                          Operations                                  

    public boolean registerCourse(Course course) {
    	try {
    		String definition = "Course name " + course.getCourseName();
        	new RequestFromStudent("Register for course", definition, this);
        	return true;
    	} catch (Exception e) {
    		throw new RuntimeException("Exception in registration for course");
    	}
    	  // Student creates request and add to requests Vector (send to Manager)
    	  // Request constructor / Request(String header, String definition, BasicUser sender)
    	  // But now we cannot convert Student to BasicUser, so I create subclass RequestFromStudent
    }
    
    public Vector<Teacher> getTeacherInfo(Course course) {
    	return course.getTeachers();
    }

    public HashMap<Course, Mark> viewMarks() {
        return currentCoursesMarks;
    }
    
    public Transcript viewTranscript() {
        //TODO
        return transcrcipt;
    }
  
	public Vector<Course> viewCourses() {
    	  return Datebase.courses.stream()
    		    	.filter(c->c.equals(currentCoursesMarks.keySet()))
    		    	.collect(Collectors.toCollection(Vector::new));
    }

    public boolean rateTeacher(Teacher teacher, Double rate) {
    	try {
    		if(this.viewCourses().stream()
        			.anyMatch(c->c.getTeachers().contains(teacher)))
    			teacher.setTeacherRate(rate);
        	return true;
    	} catch (Exception e) {
    		throw new RuntimeException("Exception in rating teacher");
    	}
    }
  
    public Transcript getTranscript() {
		return transcrcipt;
    }

    public boolean writeDiplomaProject(DiplomaProjects d) {
    	 DiplomaProjects.projects.add(d);
    	 return true;
    }
}
