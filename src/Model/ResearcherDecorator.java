package Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;


import Config.*;

public class ResearcherDecorator extends UserDecorator implements Serializable {
	
	{
		super.isResearcher = true;
		super.researchPapers = new Vector<String>();
		super.researchProjects = new Vector<String>();
	}
	
	public ResearcherDecorator(User user) {
		super(user);
		
	}
    
	public ResearcherDecorator(User user, int hIndex) {
		this(user);
		super.hIndex = hIndex;
	}
	
	public boolean registerCourse(Course course) {
		Student s = (Student)user;
		return s.registerCourse(course);
	}
	
//    public ResearcherDecorator(User user, String firstLastName, String login, String password, int hIndex) {
//    	super(user, firstLastName, login, password);
//    	this.hIndex = hIndex;
//    }
    
    //                          Operations                                  
    	
	
	public boolean doResearch() {
		System.out.println("Yes I can make research");
		return true;
	}
	public boolean addResearchPaper(String paper) {
		return researchPapers.add(paper);
	}

	public boolean addResearchProject(String project) {
		return researchPapers.add(project);
	}    
	
	public String toString() {
		return "Researcher: " + super.toString() + ", h-index: " + hIndex + ", research papers: " + researchPapers + ", research projects: " + researchProjects; 
	}
	
	public boolean equals(Object o) {
		if (!super.equals(o)) {
			return false;
		}
		
		ResearcherDecorator researcher = (ResearcherDecorator)o;
		return researcher.hIndex == this.hIndex && 
				researcher.researchPapers.equals(this.researchPapers) &&
				researcher.researchProjects.equals(this.researchProjects);
	}
	
	public int hashCode() {
		return super.hashCode() + 
				Objects.hash(hIndex, researchPapers, researchProjects);
	}
	
	public int compareTo(ResearcherDecorator researcher) {
		if (this.hIndex < researcher.hIndex) {
			return -1;
		}
		else if (this.hIndex > researcher.hIndex) {
			return 1;
		}
		return 0;
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		ResearcherDecorator newResearcher = new ResearcherDecorator(user);
		newResearcher.hIndex = this.hIndex;
		
		Vector<String> newPapers = new Vector<String>();
		Vector<String> newProjects = new Vector<String>();

		for (String s: this.researchPapers) {
			newPapers.add(s);
		}
		
		for (String s: this.researchProjects) {
			newProjects.add(s);
		}
		
		newResearcher.researchPapers = newPapers;
		newResearcher.researchProjects = newProjects;
		return newResearcher;
	}
}
