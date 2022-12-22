package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Teacher extends Employee implements Serializable{
	
	public Vector<Course> courses;
	public HashMap<Course, Vector<TeacherCourseFile>> courseFiles;

	public Rate teacherRate;
        
    public Department department;
    public TeacherLevel teacherLevel;
    
    {
    	courses = new Vector<Course>();
    	courseFiles = new HashMap<Course, Vector<TeacherCourseFile>>();
    	teacherRate = new Rate(0,0);
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
    /* 
     * @return all the courses teaching by the Teacher
     */
    public Vector<Course> viewCourses() {
    	return this.courses;
    }
    
    /* 
     * @return Students which can be taught by the teacher
     */
    public HashSet<Student> viewStudents() { // use LINQ !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	HashSet<Student> students = new HashSet<Student>();
    	for (Course course: this.courses) {
    		for (Student student: course.getStudents()) {
    			students.add(student);
    		}
    	}
    	return students;
    }

    /* 
     * @param student that need to put mark
     * @param course that need to put mark
     * @param digit mark
     * @return putting Mark to exact Student, picking for Course for what Mark is put
     * 
     */
    public boolean putMark(Student student, Course course, Mark mark) {
    	if (student.getCoursesMarks().containsKey(course)) {
    		student.getCoursesMarks().put(course, mark);
    		return true;
    	}
    	return false;
    }
    
    
    /* 
     * @param student that need to put attendance
     * @param course that need to put attendance
     * @param boolean expression that identifies student attended or not
     * @return attendance put or not
     */
    public boolean putAttendance(LocalDate date, Student student, Course course, double mark) {
	    
	   	Map<Course, TreeMap<LocalDate, Pair<Boolean, Double>>> coursesAttendancePoints = student.getJournal().courseAttendanceAndPoints;
	   	TreeMap<LocalDate, Pair<Boolean, Double>> courseAtt = coursesAttendancePoints.get(course);
	   	
	   	Pair<Boolean, Double> markAtt = new Pair(true, mark);
	   	courseAtt.put(date, markAtt);
	   	return true;
	    
    }
    
    /* 
  * @param course that need to be added
  * @param file that need to be added exact course
  * @return boolean expression that identifies added the file or not
  * 
  */
    public boolean addCourseFile(Course course, TeacherCourseFile teacherCourseFile) {
    	Vector<TeacherCourseFile> teacherCourseFiles = courseFiles.get(course);
    	teacherCourseFiles.add(teacherCourseFile);
    	courseFiles.put(course, teacherCourseFiles);
    	return true;
    }
    
    
    /* 
     * @param course that need to be deleted
     * @param file that need to be deleted from exact course
     * @return boolean expression that identifies deleted the file or not
     */
    public boolean deleteCourseFile(Course course, TeacherCourseFile teacherCourseFile) {
    	Vector<TeacherCourseFile> teacherCourseFiles = courseFiles.get(course);
    	if (teacherCourseFiles.isEmpty()) {
    		return false;
    	}
    	teacherCourseFiles.remove(teacherCourseFile);
    	courseFiles.put(course, teacherCourseFiles);
    	return true;
    }
    
    
    /* 
     * getting rating of this teacher
     * @return rating
     */
    public double getRateValue() {
    	return this.teacherRate.value;
    }
    
    public String toString() {
    	return "Teacher: " + super.toString() + ", courses: " + courses + ", rating: " + this.teacherRate.value + ", department: " + department + ", level: " + teacherLevel;
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
    	
    	HashMap<Course, Vector<TeacherCourseFile>> newCourseFiles = new HashMap<Course, Vector<TeacherCourseFile>>();
    	for (Map.Entry<Course, Vector<TeacherCourseFile>> entry: this.courseFiles.entrySet()) {
    		Vector<TeacherCourseFile> newFiles = new Vector<TeacherCourseFile>();
    		for (TeacherCourseFile f: entry.getValue()) {
    			newFiles.add((TeacherCourseFile) f.clone());
    		}
    		newCourseFiles.put((Course) entry.getKey().clone(), newFiles);
    	}
    	newTeacher.courseFiles = newCourseFiles;
    	
    
    	newTeacher.teacherRate = (Rate) this.teacherRate.clone();
    	return newTeacher;
    }
}
