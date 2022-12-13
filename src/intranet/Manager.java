package intranet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class Manager extends Employee implements ManageNews {

    public ManagerTypes type;    
    public Department department;
    
    
    public Manager(User user) {
		super(user);
    }
    
    public Manager(User user, ManagerTypes type, Department department) {
    	super(user);
    	this.type = type;
    	this.department = department;
    }
    
    
    
    public boolean approveCourseRegistration(Student student, Course course) {
        Vector<Course> prerequisites = course.prerequisites;
        Vector<Journal> journals = student.getTranscript();
        
        for (Course prereq: prerequisites) {
        	for (Journal journal: journals) {
        		HashMap<Course, Mark> courseAndMarks = journal.courses;
        		if (courseAndMarks.containsKey(prereq)) {
        			if (courseAndMarks.get(prereq).getTotal().getDigitGrade() < 50) {
        				return false;
        			}
        		}
        		else {
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public boolean addCourseForRegistration(Course course) {
        try {
        	Database.courses.add(course);
        	return true;
        } catch (Exception e) {
        	throw new RuntimeException("Exception in adding course for registration");
        	return false;
        }
    }
    
    public Report createStatisticalReport(Course course) {
        Report courseReport = new Report();
        
        return courseReport;
    }
    
    public Report createStatisticalReport(Teacher teacher) {
    	Report teacherReport = new Report();
    	
    	return teacherReport;
    }
    
    public Vector<Student> viewInfoAboutStudents(HowToSort howToSort) {
    	Vector<Student> copiedForSorting = (Vector<Student>) Database.students.clone();
        if (howToSort == HowToSort.ALPHABETICALLY) {
        	Collections.sort(copiedForSorting, new AlphabeticallyComparator());
        }
        else if (howToSort == HowToSort.GPA) {
        	Collections.sort(copiedForSorting, new GPAComparator());
        }
        
        return copiedForSorting;
    }
    
    public Vector<Teacher> viewInfoAboutTeachers(HowToSort howToSort) {
    	Vector<Teacher> copiedForSorting = (Vector<Teacher>) Database.teachers.clone();
        if (howToSort == HowToSort.RATE) {
        	Collections.sort(copiedForSorting, new RateComparator());
        }
        else if (howToSort == HowToSort.SALARY) {
        	Collections.sort(copiedForSorting, new SalaryComparator());
        }
        return copiedForSorting;
    }
    
    public Vector<Request> viewRequests() {
        Vector<Request> signed = new Vector<Request>();
        for (Request request: Database.requests) {
        	if (request.signedByDean == true || request.signedByRector == true) {
        		signed.add(request);
        	}
        }
        return signed;
    }
    
    public boolean assignCourseToTeachers() {
        //TODO
        return false;
    }    
    
}
