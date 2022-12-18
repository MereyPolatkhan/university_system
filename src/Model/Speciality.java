package Model;



public class Speciality {
	public String name;
	public String description;
	
	public Speciality() {}

	public Speciality(String name, String description) {
		this.name = name;
		this.description = description;
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
