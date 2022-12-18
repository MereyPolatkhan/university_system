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
    
	public String toString() {
		
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
	}
	
	public int hashCode() {
		
	}
	
	public int compareTo() {
		
	}
	public Object clone() throws CloneNotSupportedException {
		
	}
}
