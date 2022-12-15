package Model;

import java.util.*;

public class Teacher extends Employee {
	
	public Vector<Course> courses;
	public HashMap<Course, Vector<File>> courseFiles;

        
    public Department department;
    public TeacherLevel teacherLevel;
    public Vector<Double> teacherRates;
    
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
    
    public Teacher(User user, double salary, Department department, TeacherLevel teacherLevel) {
    	this(user, salary);
    	this.department = department;
    	this.teacherLevel = teacherLevel;
    } 
    
    public Teacher(User user, double salary, Department department, TeacherLevel teacherLevel, Vector<Course> courses) {
    	this(user, salary, department, teacherLevel);
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

    public boolean putMark(Student student, Course course, Mark mark) {
    	if (student.getCoursesMarks().containsKey(course)) {
    		student.getCoursesMarks().put(course, mark);
    		return true;
    	}
    	return false;
    }
    
    public boolean addCourseFile(Course course, File file) {
    	Vector<File> files = courseFiles.get(course);
    	files.add(file);
    	courseFiles.put(course, files);
    	return true;
    }
    
    public boolean deleteCourseFile(Course course, File file) {
    	Vector<File> files = courseFiles.get(course);
    	if (files.isEmpty()) {
    		return false;
    	}
    	files.remove(file);
    	courseFiles.put(course, files);
    	return true;
    }
    
    public double computeTeacherRate() {
    	double sum = 0;
    	
    	for (double d: this.teacherRates) {
    		sum += d;
    	}
    	return sum / this.teacherRates.size();
    }
}
