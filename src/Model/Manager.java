package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import Config.Database;

public class Manager extends Employee implements ManageNews {

    public ManagerTypes type;    
    public Department department;
    
    
    public Manager(User user) {
		super(user);
    }
    
    public Manager(User user, double salary) {
    	super(user);
    	this.setSalary(salary);
    }
    
    public Manager(User user, String firstLastName) {
    	super(user, firstLastName);
    }
    
    
    public Manager(User user, String firstLastName, double salary) {
    	super(user, firstLastName, salary);
    }
    
    public Manager(User user, String firstLastName, String password)  {
    	super(user, firstLastName, password);
    }
    
    public Manager(User user, String firstLastName, String login, String password)  {
    	super(user, firstLastName, login, password);
    }
    
    public Manager(User user, String firstLastName, double salary, ManagerTypes type, Department department) {
    	this(user, firstLastName, salary);
    	this.type = type;
    	this.department = department;
    }
    
    
    
    public static boolean approveCourseRegistration(Student student, Course course) {
        Vector<Course> prerequisites = course.prerequisites;
        Vector<Journal> journals = student.getTranscript().journals;
        
        for (Course prereq: prerequisites) {
        	for (Journal journal: journals) {
        		HashMap<Course, Mark> courseAndMarks = journal.courses;
        		if (courseAndMarks.containsKey(prereq)) {
        			if (courseAndMarks.get(prereq).getTotal().digitGrade < 50) {
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
        return Database.registrationCourses.add(course);
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
    	Vector<Student> copiedForSorting = (Vector<Student>) Database.getStudentsFromDB().clone();
        if (howToSort == HowToSort.ALPHABETICALLY) {
        	Collections.sort(copiedForSorting, new StudentYearComparator());
        }
        else if (howToSort == HowToSort.GPA) {
        	Collections.sort(copiedForSorting, new GPAComparator());
        }
        
        return copiedForSorting;
    }
    
    public Vector<Teacher> viewInfoAboutTeachers(HowToSort howToSort) {
    	Vector<Teacher> copiedForSorting = (Vector<Teacher>) Database.getTeachersFromDB().clone();
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
        for (Request request: Database.requests) {
        	if (request.signedByDean == true || request.signedByRector == true) {
        		signed.add(request);
        	}
        }
        return signed;
    }
    
    public boolean assignCoursesToTeachers(Vector<Course> courses, Vector<Teacher> teachers) {
    	boolean isAtLeastOneCourseAdded= true;
    	
        for (Teacher teacher: teachers) {
        	isAtLeastOneCourseAdded = teacher.courses.addAll(courses);
        }
        
        return isAtLeastOneCourseAdded;
    }

	@Override
	public boolean addNews(News news) {
		return Database.news.add(news);
	}

	@Override
	public boolean deleteNews(News news) {
		return Database.news.remove(news);
	}

	@Override
	public boolean editNews(News oldNews, News newNews) {
		if (Database.news.remove(oldNews)) {
			return Database.news.add(newNews);
		}
		return false;
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










