package intranet;

import java.util.*;

public class Teacher extends Employee {
	
	public Vector<Course> courses;
	public HashMap<Course, Vector<File>> courseFiles;

        
    public Department department;
    public TeacherLevel teacherLevel;
    public double teacherRate;
    
    {
    	courses = new Vector<Course>();
    	courseFiles = new HashMap<Course, Vector<File>>();
    }
    
    public Teacher(User user) {
    	super(user);
    }
    
    public Teacher(User user, double salary) {
    	super(user);
    	this.setSalary(salary);
    } 
    
    public Teacher(User user, double salary, Department department, TeacherLevel teacherLevel, double teacherRate) {
    	this(user, salary);
    	this.department = department;
    	this.teacherLevel = teacherLevel;
    	this.teacherRate = teacherRate;
    } 
    
    public Teacher(User user, double salary, Department department, TeacherLevel teacherLevel, double teacherRate, Vector<Course> courses) {
    	this(user, salary, department, teacherLevel, teacherRate);
    	this.courses = courses;
    } 
    
    
    //                          Operations                                  
    
    public Vector<Course> viewCourses() {
    	return this.courses;
    }
    
    
    public HashSet<Student> viewStudents() { // use LINQ !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	HashSet<Student> students = new HashSet<Student>();
    	for (Course course: this.courses) {
    		for (Student student: course.getStudents()) {
    			students.add(student);
    		}
    	}
    	return students;
    }

    private boolean putMark(Student student, Course course, Mark mark) {
    	try {
    		student.setMark(course, mark);
    		return true;
    	} catch (Exception e) {
    		throw new RuntimeException("Exception in putting mark");
    		return false;
    	}
    }
    
    private boolean addCourseFile(Course course, File file) {
    	Vector<File> files = courseFiles.get(course);
    	files.add(file);
    	courseFiles.put(course, files);
    	return true;
    }
    
    private boolean deleteCourseFile(Course course, File file) {
    	Vector<File> files = courseFiles.get(course);
    	if (files.isEmpty()) {
    		return false;
    	}
    	files.remove(file);
    	courseFiles.put(course, files);
    	return true;
    }
    
    
}
