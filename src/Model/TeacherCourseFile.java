package Model;

import java.io.Serializable;
import java.util.Objects;

public class TeacherCourseFile implements Comparable<TeacherCourseFile>, Cloneable , Serializable{
    
	public String name;

	public String data; 
    
	public TeacherCourseFile() {};
	
	public TeacherCourseFile(String name) {
		this.name = name;
	}
	
	public TeacherCourseFile(String name, String data) {
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
		TeacherCourseFile f = (TeacherCourseFile)o;
		return f.name.equals(this.name) && f.data.equals(this.data);
		
	}
	
	public int hashCode() {
		return Objects.hash(name, data);
	}
	
	public Object clone() throws CloneNotSupportedException {
		TeacherCourseFile newFile = new TeacherCourseFile();
		newFile.name = this.name;
		newFile.data = this.data;
		return newFile;
	}

	@Override
	public int compareTo(TeacherCourseFile teacherCourseFile) {
		return this.name.compareTo(teacherCourseFile.name);
	}

}
