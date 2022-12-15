package Model;

import java.util.*;

import Config.*;

public class Student extends UserDecorator {
	private Map<Course, Mark> coursesMarks;
    public Period period;
    private Transcript transcrcipt;
    public Organization organization;
    public StudentLevel level;
    public int year;
    public Department department;
    public Speciality studentSpeciality;
    private int scholarship;
    private Schedule schedule;
    
    
    public Student(User user) {
    	super(user);
    }
    
    
    public Student(User user,
    		StudentLevel level, int year, 
    		Department department, Speciality studentSpeciality) {    
    	super(user);
    	this.level = level;
    	this.year = year;
    	this.department = department;
    	this.studentSpeciality = studentSpeciality;
    } 

    public int getScholarship() {
    	return scholarship;
    }
    
    public Schedule getSchedule() {
    	return schedule;
    }
    
    public Map<Course, Mark> getCoursesMarks(){
    	return this.coursesMarks;
    }
    
    public Transcript getTranscript() {
		return transcrcipt;
    }
    
    //                          Operations                                  

    public boolean registerCourse(Course course) {
    	if (Manager.approveCourseRegistration(this, course) 
    			&& Database.registrationCourses.contains(course)
    			&& computeCreditsForThisSemester() <= 21) {
    		this.coursesMarks.put(course, new Mark());
    		return true;
    	}
    	return false;
    }
    
    private int computeCreditsForThisSemester() {
		int total = 0;
		for (Course course: this.coursesMarks.keySet()) {
			total += course.credits;
		}
		return total;
	}


	public Vector<Teacher> getTeacherInfo(Course course) {
    	return course.getTeachers();
    }

    public Map<Course, Mark> viewMarks() {
        return this.getCoursesMarks();
    }
    
  
	public Vector<Course> viewCourses() {
		Vector<Course> studentCourses = new Vector<Course>();
		for (Course course: coursesMarks.keySet()) {
			studentCourses.add(course);
		}
		return studentCourses;
    }

    public boolean rateTeacher(Teacher teacher, Double rate) {
    	return teacher.teacherRates.add(rate);
    }
  


    public boolean writeDiplomaProject(DiplomaProjects d) {
    	 return DiplomaProjects.projects.add(d);
    }
	
    public double getGeneralGPA() {
    	double gpa = 0;
    	for (Map.Entry<Course, Mark> entry: coursesMarks.entrySet()) {
    		gpa += entry.getValue().getTotal().getGpa();
    	}
    	return gpa / coursesMarks.size();
    }
    
    /*
     *  done + o Students can not have more than 21 credits
		o Students can not fail more than 3 times
		o FIT Students can not have FOGI courses (only as electives)
		done + o Mark consists of 1st, 2nd attestation, and final.
     */
}
