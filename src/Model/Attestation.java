package Model;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public class Attestation implements Comparable<Attestation>, Cloneable , Serializable{
	
    public Period period;
    
    public Map<Course, Mark> courses; 
    
    public Attestation() {
    	courses = new HashMap<Course, Mark>();
    }

    public Attestation(Period period) { 
    	this();
    	this.period = period;
    }
    
	public Attestation(Period period, HashMap<Course, Mark> courses) {
		this.period = period;
		this.courses = courses;
	}
	
	
	public double getAttestationGPA() {
		int credits = 0;
		double total = 0;
		for (Map.Entry<Course, Mark> entry: this.courses.entrySet()) {
			credits += entry.getKey().credits;
			total += entry.getValue().getTotal().getGpa();
		}
		return total / credits * (1.0);
	}

	
	public String toString() {
		return "Journal: period: " + period + ", courses: " + courses;
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
		
		Attestation j = (Attestation)o;
		return this.period.equals(j.period) && this.courses.equals(j.courses);
	}
	
	public int hashCode() {
		return Objects.hash(period, courses);
	}	
	
	
	public Object clone() throws CloneNotSupportedException {
		Attestation newJournal = new Attestation();
		newJournal.period = (Period) this.period.clone();
		for (Map.Entry<Course, Mark> entry: this.courses.entrySet()) {
			newJournal.courses.put((Course) entry.getKey().clone(), (Mark) entry.getValue().clone());
		}
		return newJournal;
	}

	@Override
	public int compareTo(Attestation attestation) {
		return this.period.compareTo(attestation.period);
	}

	
}
