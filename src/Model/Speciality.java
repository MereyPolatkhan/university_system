package Model;

import java.io.Serializable;
import java.util.Objects;

public class Speciality implements Comparable<Speciality>, Cloneable, Serializable{
	public String name;
	public String description;
	
	public Speciality() {}

	public Speciality(String name) {
		this.name = name;
	}
	
	public Speciality(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	public String toString() {
		return "Speciality: name: " + name + ", description: " + description;
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
		Speciality s = (Speciality)o;
		return s.name.equals(this.name) && s.description.equals(this.description);
		
	}
	
	public int hashCode() {
		return Objects.hash(name, description);
	}
	
	public int compareTo(Speciality s) {
		return this.name.compareTo(s.name);
	}
	public Object clone() throws CloneNotSupportedException {
		Speciality newSpec = new Speciality();
		newSpec.name = this.name;
		newSpec.description = this.description;
		return newSpec;
	}
}
