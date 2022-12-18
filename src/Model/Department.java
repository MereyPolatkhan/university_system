package Model;

import java.util.Objects;
import java.util.Vector;

public class Department {
	public String name;
    
	public Vector<Speciality> specialities;
	
	public Department() {};

	public Department(String name) {
		this.name = name;
	};

	
	public Department(String name, Vector<Speciality> specialities) {
		this(name);
		this.specialities = specialities;
	}

	public String toString() {
		return "Department: name: " + name + ", specialities: " + specialities; 
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
		Department d = (Department)o;
		return d.name.equals(this.name) && d.specialities.equals(this.specialities);
	}
	
	public int hashCode() {
		return Objects.hash(name, specialities);
	}
	
	public int compareTo(Department d) {
		return this.name.compareTo(d.name);
	}
	public Object clone() throws CloneNotSupportedException {
		Department newDep = new Department();
		newDep.name = this.name;
		
		Vector<Speciality> newSpecialities = new Vector<Speciality>();
		for (Speciality s: this.specialities) {
			newSpecialities.add((Speciality) s.clone());
		}
		newDep.specialities = newSpecialities;
		return newDep;
	}

}
