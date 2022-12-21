package Model;

import java.io.Serializable;
import java.util.Objects;


public class Grade implements Comparable<Grade>, Cloneable , Serializable {
	public double digitGrade;
	
	public Grade() {};
	
	public Grade(double digitGrade) {
		this.digitGrade = digitGrade;
	}
	
	public String getLetterGrade() {
	     if (digitGrade < 50) return "F";
	    else if (digitGrade < 55) return "D";
	    else if (digitGrade < 60) return "D+";
	    else if (digitGrade < 65) return "C-";
	    else if (digitGrade < 70) return "C";
	    else if (digitGrade < 75) return "C+";
	    else if (digitGrade < 80) return "B-";
	    else if (digitGrade < 85) return "B";
	    else if (digitGrade < 90) return "B+";
	    else if (digitGrade < 95) return "А";
	    return "А+";
	}	  
	
	public double getGpa() {
	     if (digitGrade < 50) return 0;
	    else if (digitGrade < 55) return 1;
	    else if (digitGrade < 60) return 1.33;
	    else if (digitGrade < 65) return 1.67;
	    else if (digitGrade < 70) return 2;
	    else if (digitGrade < 75) return 2.33;
	    else if (digitGrade < 80) return 2.67;
	    else if (digitGrade < 85) return 3;
	    else if (digitGrade < 90) return 3.33;
	    else if (digitGrade < 95) return 3.67;
	    return 4;
	}
	
	public String getTraditionalGrade() {
	    if (digitGrade < 0 || digitGrade > 100) return "undefined";
	    else if (digitGrade < 50) return "Failure";
		else if(digitGrade < 75) return "Satisfactory";
		else if(digitGrade < 90) return "Good";
		return "Excellent";
	}

	
	public String toString() {
		return "Grade: " + digitGrade + ", " + getLetterGrade() + ", " + getGpa() + ", " + getTraditionalGrade();
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
		Grade g = (Grade)o;
		return g.digitGrade == this.digitGrade;
	}
	
	public int hashCode() {
		return Objects.hash(digitGrade);
	}
	
	public int compareTo(Grade grade) {
		if (this.digitGrade < grade.digitGrade) {
			return -1;
		}
		else if (this.digitGrade > grade.digitGrade) {
			return 1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Grade newGrade = new Grade();
		newGrade.digitGrade = this.digitGrade;
		return newGrade;
	}
	
	
}
