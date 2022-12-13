package intranet;

import java.util.*;


public class Course {
	public String courseName;
	public int code;
	public int credits;	
	public Vector<Course> prerequisites;
	public int ects;
	public Department department;
	public Speciality intendedSpeciality;
	public String info;
    public ElectiveCourseType type;
    public Map<Date, Lesson> lessons;

    
    public Course() {}
    
    public Course(String courseName, int code, int credits) {
    	this.courseName = courseName;
    	this.code = code;
    	this.credits = credits;
    	this.prerequisites = new Vector<Course>();
    	this.ects = 5;
    	this.department = null;
    	this.intendedSpeciality = null;
    	this.info = "undefined";
    	this.type = ElectiveCourseType.UNDEFINED;
    }
    
    public Course(String courseName, 
    		int code, 
    		int credits, 
    		Vector<Course> prerequisites, 
    		int ects, 
    		Department department, 
    		Speciality intendedSpeciality, 
    		String info, 
    		ElectiveCourseType type, 
    		Map<Date, Lesson> lessons) {
    	
    	this(courseName, code, credits);
    	this.prerequisites = prerequisites;
    	this.ects = ects;
    	this.department = department;
    	this.intendedSpeciality = intendedSpeciality;
    	this.type = type;
    	this.lessons = lessons;
   
    }
    
    
    //                          Operations                                  
    
    public Vector<Student> getStudents() {
    	Vector<Student> courseStudents = new Vector<Student>();
    	Database db = Database.getINSTANCE();
    	for (Student student: db.students) {
    		if (student.coursesMarks.contains(this)) {
    			courseStudents.add(student);
    		}
    	}
    	return courseStudents;
    }

    public Vector<Teacher> getTeachers() {
    	Vector<Teacher> courseTeachers = new Vector<Teacher>();
    	Database db = Database.getINSTANCE();
    	for (Teacher teacher: db.teachers) {
    		if (teacher.courses.contains(this)) {
    			courseTeachers.add(teacher);
    		}
    	}
    	return courseTeachers;
    }
    
    
}
