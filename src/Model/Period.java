package Model;

import java.io.Serializable;
import java.util.Objects;

public class Period implements Comparable<Period>, Cloneable , Serializable{
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
		return "Period: year: " + beginYear + "-" + endYear + ", semester: " + semester;
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
		Period p = (Period)o;
		return p.beginYear == this.beginYear && 
				p.endYear == this.endYear && 
				p.semester == this.semester;
	}
	
	public int hashCode() {
		return Objects.hash(beginYear, endYear, semester);
	}
	
	public int compareTo(Period p) {
		if (this.beginYear < p.beginYear) {
			return -1;
		}
		else if (this.beginYear > p.beginYear) {
			return 1;
		}
		else {
			if (this.semester.ordinal() < p.semester.ordinal()) {
				return -1;
			}
			else if (this.semester.ordinal() > p.semester.ordinal()) {
				return 1;
			}
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Period newPeriod = new Period();
		newPeriod.beginYear = this.beginYear;
		newPeriod.endYear = this.endYear;
		newPeriod.semester = this.semester;
		return newPeriod;
	}
}
