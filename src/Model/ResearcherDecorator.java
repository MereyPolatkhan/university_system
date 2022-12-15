package Model;

import java.util.Vector;

import Config.Database;

public class ResearcherDecorator extends UserDecorator implements Researcher {
	
	protected Researcher researcher;
	
	public int hIndex;
	
	public Vector<String> researchPapers;
	
	public Vector<String> researchProjects;

	public ResearcherDecorator(User user) {
		super(user);
	}
    
	public ResearcherDecorator(User user, int hIndex) {
		super(user);
		this.hIndex = hIndex;
	}
    
    //                          Operations                                  
    	
	
	@Override
	public boolean doResearch() {
		return true;
	}

	@Override
	public boolean addResearchPaper(String paper) {
		return Database.researchPapers.add(paper);
	}

	@Override
	public boolean addResearchProject(String project) {
		return Database.researchPapers.add(project);
	}


    
}
