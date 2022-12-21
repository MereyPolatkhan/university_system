package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Teacher extends Employee implements Serializable{
	
	public Vector<Course> courses;
	public HashMap<Course, Vector<Filebek>> courseFiles;

	public Rate teacherRate;
        
    public Department department;
    public TeacherLevel teacherLevel;
    
    {
    	courses = new Vector<Course>();
    	courseFiles = new HashMap<Course, Vector<Filebek>>();
    }
    
    public Teacher(User user) {
    	super(user);
    }
    
    public Teacher(User user, String firstLastName, String login, String password) {
    	super(user, firstLastName, login, password);
    }
    
    public Teacher(User user,  String firstLastName, String login, String password,
    		double salary, Department department, TeacherLevel teacherLevel, Rate rate) {
    	super(user, firstLastName, login, password);
    	this.setSalary(salary);
    	this.department = department;
    	this.teacherLevel = teacherLevel;
    	this.teacherRate = rate;
    	
    	if (teacherLevel == TeacherLevel.ASSISTANT_PROFESSOR  || 
    		teacherLevel == TeacherLevel.ASSOCIATE_PROFESSOR || 
    		teacherLevel == TeacherLevel.PROFESSOR) {
    		super.isResearcher = true;
    	}
    	else super.isResearcher = false;
    	
    	
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
    
    public boolean putAttendance(Student student, Course course, boolean isAttended) {
    	Map<Course, TreeMap<LocalDate, Pair<Boolean, Double>>> coursesAttendancePoints = student.getJournal().courseAttendanceAndPoints;
    	TreeMap<LocalDate, Pair<Boolean, Double>> courseAtt = coursesAttendancePoints.get(course);
    	
    }
    
    
    public boolean addCourseFile(Course course, Filebek filebek) {
    	Vector<Filebek> filebeks = courseFiles.get(course);
    	filebeks.add(filebek);
    	courseFiles.put(course, filebeks);
    	return true;
    }
    
    public boolean deleteCourseFile(Course course, Filebek filebek) {
    	Vector<Filebek> filebeks = courseFiles.get(course);
    	if (filebeks.isEmpty()) {
    		return false;
    	}
    	filebeks.remove(filebek);
    	courseFiles.put(course, filebeks);
    	return true;
    }
    
    public double getRateValue() {
    	return this.teacherRate.value;
    }
    
    public String toString() {
    	return "Teacher: " + super.toString() + ", courses: " + courses + ", rating: " + getRateValue() + ", department: " + department + ", level: " + teacherLevel;
    }
    
    public boolean equals(Object o) {
    	if (!super.equals(o)) {
    		return false;
    	}
    	Teacher teacher = (Teacher)o;
    	return 
    			teacher.courses == this.courses &&
    			teacher.courseFiles == this.courseFiles &&
    			teacher.teacherRate == this.teacherRate &&
    			teacher.department == this.department &&
    			teacher.teacherLevel == this.teacherLevel; 
    }
    
    public int hashCode() {
    	return super.hashCode() + 
    			Objects.hash(courses, courseFiles, 
    					teacherRate, department, 
    					teacherLevel);
    }
    
    public int compareTo(UserDecorator user) {
    	if (super.compareTo(user) != 0) {
    		return super.compareTo(user);
    	}
    	Teacher t = (Teacher)user;
    	if (this.getRateValue() < t.getRateValue()) { 
    		return -1;
    	}
    	else if (this.getRateValue() > t.getRateValue()) {
    		return 1;
    	}
    	return 0;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	Teacher newTeacher = new Teacher(user);
    	newTeacher.department = (Department) this.department.clone();
    	newTeacher.teacherLevel = this.teacherLevel;
    	
    	Vector<Course> newCourses = new Vector<Course>();
    	for (Course c: this.courses) {
    		newCourses.add((Course) c.clone());
    	}
    	newTeacher.courses = newCourses;
    	
    	HashMap<Course, Vector<Filebek>> newCourseFiles = new HashMap<Course, Vector<Filebek>>();
    	for (Map.Entry<Course, Vector<Filebek>> entry: this.courseFiles.entrySet()) {
    		Vector<Filebek> newFiles = new Vector<Filebek>();
    		for (Filebek f: entry.getValue()) {
    			newFiles.add((Filebek) f.clone());
    		}
    		newCourseFiles.put((Course) entry.getKey().clone(), newFiles);
    	}
    	newTeacher.courseFiles = newCourseFiles;
    	
    
    	newTeacher.teacherRate = (Rate) this.teacherRate.clone();
    	return newTeacher;
    }
}
