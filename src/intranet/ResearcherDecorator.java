package intranet;


/**
* @generated
*/
public class ResearcherDecorator extends UserDecorator implements Researcher {
    
    /**
    * @generated
    */
    private Researcher researcher;
    
    /**
    * @generated
    */
    private int hIndex;
    
    /**
    * @generated
    */
    private Vector<String> researchPapers;
    
    /**
    * @generated
    */
    private Vector<String> researchProjects;
    
    
    

    /**
    * @generated
    */
    protected Researcher getResearcher() {
        return this.researcher;
    }
    
    /**
    * @generated
    */
    protected Researcher setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    
    /**
    * @generated
    */
    public int getHIndex() {
        return this.hIndex;
    }
    
    /**
    * @generated
    */
    public int setHIndex(Integer hIndex) {
        this.hIndex = hIndex;
    }
    
    
    /**
    * @generated
    */
    public Vector<String> getResearchPapers() {
        return this.researchPapers;
    }
    
    /**
    * @generated
    */
    public Vector<String> setResearchPapers(Vector<String> researchPapers) {
        this.researchPapers = researchPapers;
    }
    
    
    /**
    * @generated
    */
    public Vector<String> getResearchProjects() {
        return this.researchProjects;
    }
    
    /**
    * @generated
    */
    public Vector<String> setResearchProjects(Vector<String> researchProjects) {
        this.researchProjects = researchProjects;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public boolean doResearch() {
        //TODO
        return false;
    }
    
    
}
