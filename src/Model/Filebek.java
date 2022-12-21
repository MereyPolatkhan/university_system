package Model;

import java.io.Serializable;
import java.util.Objects;

public class Filebek implements Comparable<Filebek>, Cloneable , Serializable{
    
	public String name;

	public String data; 
    
	public Filebek() {};
	
	public Filebek(String name) {
		this.name = name;
	}
	
	public Filebek(String name, String data) {
		this.name = name;
		this.data = data;
	}
	
	public String toString() {
		return "File: name: " + name + ", data: " + data;
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
		Filebek f = (Filebek)o;
		return f.name.equals(this.name) && f.data.equals(this.data);
		
	}
	
	public int hashCode() {
		return Objects.hash(name, data);
	}
	
	public Object clone() throws CloneNotSupportedException {
		Filebek newFile = new Filebek();
		newFile.name = this.name;
		newFile.data = this.data;
		return newFile;
	}

	@Override
	public int compareTo(Filebek filebek) {
		return this.name.compareTo(filebek.name);
	}

}
