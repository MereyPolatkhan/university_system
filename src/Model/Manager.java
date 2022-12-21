package Model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import Config.Database;

public class Manager extends Employee implements ManageNews, Serializable{

	public static Vector<Request> requests = new Vector<Request>();
	
    public ManagerTypes type;    
    public Department department;
    
    
    public Manager(User user) {
		super(user);
    }
    
    
    public Manager(User user, String firstLastName, String login, String password)  {
    	super(user, firstLastName, login, password);
    }
    
    public Manager(User user, String firstLastName, String login, String password, 
    		double salary, ManagerTypes type, Department department) {
    	super(user, firstLastName, login, password);
    	this.setSalary(salary);
    	this.type = type;
    	this.department = department;
    }
    
    
    
    public static boolean approveCourseRegistration(Student student, Course course) {
        Vector<Course> prerequisites = course.prerequisites;
        Vector<Attestation> attestations = student.getTranscript().attestations;
        
        if (!Database.registrationCourses.contains(course)) {
        	System.out.println("this course doesnt exist in registration courses\nPlease try again");
        	return false;
        }
        
        for (Course prereq: prerequisites) {
        	for (Attestation attestation: attestations) {
        		HashMap<Course, Mark> courseAndMarks = (HashMap<Course, Mark>) attestation.courses;
        		if (courseAndMarks.containsKey(course)) {
        			System.out.println("Student has already studied this course");
        			return false;
        		}
        		if (courseAndMarks.containsKey(prereq)) {
        			if (courseAndMarks.get(prereq).getTotal().digitGrade < 50) {
        				System.out.println("Student failed this course");
        				return false;
        			}
        		}
        	}
        }
        System.out.println("Manager approved registration)");
        return true;
    }
    
    public static boolean addCourseForRegistration(Course course) {
        return Database.registrationCourses.add(course);
    }
    
    public static void createStatisticalReportOnAcademicPerformance(Student student) {
    	double meanGpa = student.getGeneralGpa();
    	double minGpa = 5, maxGpa = 0;
    	Vector<Double> attestationGPAs = new Vector<Double>();
    	for (Attestation a: student.getTranscript().attestations) {
    		double gpa = a.getAttestationGPA();
    		minGpa = Math.min(minGpa, gpa);
    		maxGpa = Math.max(maxGpa, gpa);
    		attestationGPAs.add(gpa);
    	}
    	double stdDevGpa = Transcript.standardDeviation(attestationGPAs, meanGpa);
    	System.out.println("GPA: mean=" + meanGpa + ", std dev=" + stdDevGpa + ", min=" + minGpa + ", max=" + maxGpa);
   
    
    	double meanScore = 0;
    	Vector<Double> scores = new Vector<Double>();
    	double minScore = 101, maxScore = -1;
    	
    	Vector<Attestation> studentAttestations = student.getTranscript().attestations;
    	for (Attestation att: studentAttestations) {
    		for (Map.Entry<Course, Mark> entry: att.courses.entrySet()) {
    			scores.add(entry.getValue().getTotal().digitGrade);
    		}
    	}
    	for (double d: scores) {
    		meanScore += d;
    		minScore = Math.min(minScore, d);
    		maxScore = Math.max(maxScore, d);
    	}
    	meanScore = meanScore / scores.size();
    	double stdDevScore = Transcript.standardDeviation(scores, meanScore);
       	System.out.println("Score: mean=" + meanScore + ", std dev=" + stdDevScore + ", min=" + minScore + ", max=" + maxScore);
        
    }
    
    public Vector<Student> viewInfoAboutStudents(HowToSort howToSort) throws CloneNotSupportedException {
    	Vector<Student> copiedForSorting = new Vector<Student>();
    	for (Student s:  Database.getStudentsFromDB()) {
    		copiedForSorting.add((Student) s.clone());
    	}
        if (howToSort == HowToSort.YEAR) {
        	Collections.sort(copiedForSorting, new StudentYearComparator());
        }
        else if (howToSort == HowToSort.GPA) {
        	Collections.sort(copiedForSorting, new GPAComparator());
        }
        
        return copiedForSorting;
    }
    
    public Vector<Teacher> viewInfoAboutTeachers(HowToSort howToSort) throws CloneNotSupportedException {
    	Vector<Teacher> copiedForSorting = new Vector<Teacher>();
    	for (Teacher t: Database.getTeachersFromDB()) {
    		copiedForSorting.add((Teacher) t.clone());
    	}
    	
        if (howToSort == HowToSort.RATE) {
        	Collections.sort(copiedForSorting, new RateComparator());
        }
        else if (howToSort == HowToSort.SALARY) {
        	Collections.sort(copiedForSorting, new SalaryComparator());
        }
        return copiedForSorting;
    }
    
    public Vector<Request> viewSignedRequests() {
        Vector<Request> signed = new Vector<Request>();
        for (Request request: Manager.requests) {
        	if (request.signedByDean == true || request.signedByRector == true) {
        		signed.add(request);
        	}
        }
        return signed;
    }
    
    public static boolean assignCoursesToTeachers(Vector<Course> courses, Vector<Teacher> teachers) {
    	boolean isAtLeastOneCourseAdded= true;
    	
        for (Teacher teacher: teachers) {
        	isAtLeastOneCourseAdded = teacher.courses.addAll(courses);
        }
        
        return isAtLeastOneCourseAdded;
    }

	@Override
	public boolean addNews(News news) {
		return News.news.add(news);
	}

	@Override
	public boolean deleteNews(News news) {
		return News.news.remove(news);
	}

	
	
    
    public String toString() {
    	return "Manager: " + super.toString() + ", type: " + type + ", department: " + department;
    }
    
    public boolean equals(Object o) {
    	if (!super.equals(o)) {
    		return false;
    	}
    	
    	Manager manager = (Manager)o;
    	return manager.type == this.type && manager.department == this.department;
    }
    
    public int hashCode() {
    	return super.hashCode() + Objects.hash(type, department);
    }
    
    
    public Object clone() throws CloneNotSupportedException {
    	Manager newMan = new Manager(user);
    	newMan.type = this.type;
    	newMan.department = (Department)this.department.clone();
    	return newMan;
    }
    
}










