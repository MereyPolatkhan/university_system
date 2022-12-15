package Model;


public class Period {
    public int beginYear;
    public int endYear;
    public Semester semester;
    
    public Period() {};
    
	public Period(int beginYear, int endYear, Semester semester) {
		super();
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.semester = semester;
	}
    
	
}
