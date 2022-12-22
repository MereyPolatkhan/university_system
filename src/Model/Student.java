package Model;

import java.io.Serializable;
import java.util.*;


import Config.*;

public class Student extends UserDecorator implements Serializable {
	private Map<Course, Mark> coursesMarks = new HashMap<Course, Mark>();
    public Period period;
    private Transcript transcript;
    public Organization organization;
    public StudentLevel level;
    public int year;
    public Department department;
    public Speciality speciality;
    private int scholarship;
    private Schedule schedule;
    private Journal journal;
    
    
    
    public Student(User user) {
    	super(user);
    }
    public Student(User user, String firstLastName, String login, String password) {
    	super(user, firstLastName, login, password);
    }
    
    public Student(User user, String firstLastName, 
    		String login, String password,
    		StudentLevel level, int year, 
    		Department department, Speciality speciality) {    
    	super(user, firstLastName, login, password);
    	this.level = level;
    	this.year = year;
    	this.department = department;
    	this.speciality = speciality;
    	this.transcript = new Transcript(new Vector<Attestation>());
    	if (level == StudentLevel.PhD) super.isResearcher = true;
    	else super.isResearcher = false;
    	
    	
    	
    } 

    public int getScholarship() {
    	return scholarship;
    }
    
    public Schedule getSchedule() {
    	Schedule schedule = new Schedule(new TreeMap<Lesson, Course>());
    	return schedule;
    }
    
    public Map<Course, Mark> getCoursesMarks(){
    	return this.coursesMarks;
    }
    
    public Transcript getTranscript() {
		return transcript;
    }
    
    public void setTranscript(Transcript transcript) {
    	this.transcript = transcript;
    }
    
    //                          Operations                                  

    
    /* 
     * @param course that student want to register
     * @return boolean expression that identifies course was added or not
     */
    public boolean registerCourse(Course course) {
    	if (Manager.approveCourseRegistration(this, course)) {
    		if (computeCreditsForThisSemester() + course.credits <= 21) {
    			this.coursesMarks.put(course, new Mark());
    			return true;
    		}
    	}
    	return false;
    }
    
    
    /* 
     * @return Integer number of credits of courses that student have for this semester 
     */
    private int computeCreditsForThisSemester() {
		int total = 0;
		for (Course course: this.coursesMarks.keySet()) {
			total += course.credits;
		}
		return total;
	}

    /* 
     * @param course that student wants know about teachers
     * @return Vector of Teachers with their info
     */
	public Vector<Teacher> getTeachers(Course course) {
    	return course.getTeachers();
    }

	 /* 
	  * @param course that student wants know about marks
	  * @return Vector of marks of exact course
	  */
    public Mark viewMarks(Course course) {
        return this.getCoursesMarks().get(course);
    }
    
    /* 
     * @return Vector of courses that student have current semester
     * 
     */
	public Vector<Course> viewCourses() {
		Vector<Course> studentCourses = new Vector<Course>();
		for (Course course: coursesMarks.keySet()) {
			studentCourses.add(course);
		}
		return studentCourses;
    }

	
	 /* 
	  * @param teacher that need to be rated
	  * @param double value of rate that student put
	  */
	 
    public void rateTeacher(Teacher teacher, Double point) {
    	teacher.teacherRate.value += point;
		teacher.teacherRate.count += 1;
		teacher.teacherRate.value /= teacher.teacherRate.count;
    }
  

    /* 
     * @param Diploma Project
     * @return boolean expression that identifies written Diploma Project or not
     */
    public boolean writeDiplomaProject(DiplomaProjects d) {
    	 return true;
    }
	
    

    /* 
     * @return double value of current GPA of student
     */
    public double getCurrentGPA() {
    	double gpa = 0;
    	for (Map.Entry<Course, Mark> entry: coursesMarks.entrySet()) {
    		gpa += entry.getValue().getTotal().getGpa();
    	}
    	return gpa / coursesMarks.size();
    }
    
    /* 
     * @return double value of general GPA of student
     */
    public double getGeneralGpa() {
    	double gpa = 0;
    	int cnt = 0;
    	for (Attestation a: this.transcript.attestations) {
    		gpa += a.getAttestationGPA();
    		cnt++;
    	}
    	return gpa / cnt * (1.0);
    }
    
    
    /*
     *  done + o Students can not have more than 21 credits
		o Students can not fail more than 3 times
		o FIT Students can not have FOGI courses (only as electives)
		done + o Mark consists of 1st, 2nd attestation, and final.
     */
    
    public String toString() {
    	return "Student: " + super.toString() + ", period: " + period + ", organization: " 
    				+ organization + ", level: " + level + ", year: " + year 
    				+ ", department: " + department + ", speciality: "  + speciality;
    }
    
    
    
    public boolean equals(Object o) {
    	if (!super.equals(o)) {
    		return false;
    	}
    	Student student = (Student)o;
    	
    	return 
    			student.year == this.year &&
    			student.scholarship == this.scholarship && 
    			student.level == this.level &&
    			student.period == this.period &&
    			student.transcript == this.transcript &&
    			student.organization == this.organization &&
    			student.department == this.department &&
    			student.speciality == this.speciality &&
    			student.schedule == this.schedule &&
    			student.coursesMarks == this.coursesMarks;
    }
    
    public int hashCode() {
    	return super.hashCode() + 
    			Objects.hash(coursesMarks, period, 
    					transcript, organization, 
    					level, year, 
    					department, speciality,
    					scholarship, schedule);
    }
    
    public int compareTo(UserDecorator user) {
    	if (super.compareTo(user) != 0) {
    		return super.compareTo(user);
    	}
    	Student s = (Student) user;
    	if (this.year < s.year) {
    		return -1;
    	}
    	if (this.year > s.year) {
    		return 1;
    	}
    	return 0;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	Student newStudent = new Student(user);
    	newStudent.period = (Period) this.period.clone();
    	newStudent.transcript = (Transcript) this.transcript.clone();
    	newStudent.organization = (Organization) this.organization.clone();
    	newStudent.level = this.level;
    	newStudent.year = this.year;
    	newStudent.department = (Department)this.department.clone();
    	newStudent.speciality = (Speciality)this.speciality.clone();
    	newStudent.scholarship = this.scholarship;
    	newStudent.schedule = (Schedule)this.schedule.clone();
    	
    	Map<Course, Mark> newCoursesMarks = new HashMap<Course, Mark>();
    	
    	for (Map.Entry<Course, Mark> entry: coursesMarks.entrySet()) {
    		newCoursesMarks.put((Course)entry.getKey().clone(), (Mark)entry.getValue().clone());
    	}
    	newStudent.coursesMarks = newCoursesMarks;
    	return newStudent;
    }

	public Journal getJournal() {
		return journal;
	}
    
    
    
}
