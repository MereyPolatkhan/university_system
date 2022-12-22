package Model;

import java.io.Serializable;
import java.util.*;

import Config.Database;


public class Course  implements Serializable{
	public String courseName;
	public int code;
	public int credits;	
	public Vector<Course> prerequisites;
	public int ects;
	public Department department;
	public Speciality intendedSpeciality;
	public String info;
    public ElectiveCourseType type;
    public Set<Lesson> lessons;

    
    public Course() {}
    
    public Course(String courseName, int code, int credits) {
    	this.courseName = courseName;
    	this.code = code;
    	this.credits = credits;
    	this.prerequisites = new Vector<Course>();
    	this.ects = 5;
    	this.department = new Department();
    	this.intendedSpeciality = new Speciality();
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
    		Set<Lesson> lessons) {
    	
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
    	for (Student student: Database.getStudentsFromDB()) {
    		if (student.getCoursesMarks().containsKey(this)) {
    			courseStudents.add(student);
    		}
    	}
    	return courseStudents;
    }

    public Vector<Teacher> getTeachers() {
    	Vector<Teacher> courseTeachers = new Vector<Teacher>();
    	for (Teacher teacher: Database.getTeachersFromDB()) {
    		if (teacher.courses.contains(this)) {
    			courseTeachers.add(teacher);
    		}
    	}
    	return courseTeachers;
    }
    
    
	public String toString() {
		return "Course: name: " + courseName + ", code: " + code + 
				", credits: " + credits + ", prerequisites: " + prerequisites + 
				", ects: " + ects + ", department: " + department + 
				", intended specialty: " + intendedSpeciality + 
				", info: " + info + 
				", elective type: " + type + " ";
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Course c = (Course)o;
		return 
				c.code == this.code &&
				c.credits == this.credits &&
				c.ects == this.ects &&
				c.type == this.type && 
				c.courseName.equals(this.courseName)&&
//				c.department.equals(this.department) && 
//				c.intendedSpeciality.equals(this.intendedSpeciality)&& 
				c.info.equals(this.info) && 
				c.prerequisites.equals(this.prerequisites) &&
				c.lessons.equals(this.lessons);
	}
	
	public int hashCode() {
		return Objects.hash(courseName, code, credits, 
				prerequisites, ects, department, intendedSpeciality,
				info, type, lessons);
	}
	
	public int compareTo(Course c) {
		if (this.code < c.code) {
			return -1;
		}
		else if (this.code > c.code) {
			return 1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Course newCourse = new Course();
		newCourse.courseName = this.courseName;
		newCourse.code = this.code;
		newCourse.credits = this.credits;
		
		Vector<Course> newPrereqs = new Vector<Course>();
		for (Course c: this.prerequisites) { 
			newPrereqs.add((Course) c.clone());
		}
		newCourse.prerequisites = newPrereqs;
		newCourse.ects = this.ects;
		newCourse.department = (Department) this.department.clone();
		newCourse.intendedSpeciality = (Speciality) this.intendedSpeciality.clone();
		newCourse.info = this.info;
		newCourse.type = this.type;
		
		Set<Lesson> newLessons = new HashSet<Lesson>();
		for (Lesson lesson: this.lessons) {
			newLessons.add((Lesson) lesson.clone());
		}
		newCourse.lessons = newLessons;
		return newCourse;
	}
    
    
}
