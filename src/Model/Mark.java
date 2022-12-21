package Model;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Comparable<Mark>, Cloneable, Serializable {
	private double firstAtt;
	private double secondAtt;
	private double finalAtt;
	
	public Mark() {};
	
	public Mark(double firstAtt, double secondAtt, double finalAtt) {
		this.setFirstAtt(firstAtt);
		this.setSecondAtt(secondAtt);
		this.setFinalAtt(finalAtt);
	}

	public double getFirstAtt() {
		return firstAtt;
	}

	public void setFirstAtt(double firstAtt) {
		this.firstAtt = firstAtt;
	}

	public double getSecondAtt() {
		return secondAtt;
	}

	public void setSecondAtt(double secondAtt) {
		this.secondAtt = secondAtt;
	}

	public double getFinalAtt() {
		return finalAtt;
	}

	public void setFinalAtt(double finalAtt) {
		this.finalAtt = finalAtt;
	}

	public Grade getTotal() {
		Grade total = new Grade();
		total.digitGrade = firstAtt + secondAtt + finalAtt;
		return total;
	}

	
	public String toString() {
		return "Mark: 1st :" +  firstAtt + ", 2nd att: " + secondAtt + ", final: " + finalAtt;  
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
		Mark m = (Mark)o;
		return m.finalAtt == this.finalAtt && 
				m.firstAtt == this.firstAtt && 
				m.secondAtt == this.secondAtt;
	}
	
	public int hashCode() {
		return Objects.hash(firstAtt, secondAtt, finalAtt);
	}
	
	public int compareTo(Mark mark) {
		return this.getTotal().compareTo(mark.getTotal());
	}
	
	public Object clone() throws CloneNotSupportedException {
		Mark newMark = new Mark();
		newMark.firstAtt = this.finalAtt;
		newMark.secondAtt = this.secondAtt;
		newMark.finalAtt = this.finalAtt;
		return newMark;
	}
	
	

}
