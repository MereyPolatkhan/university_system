package Model;

import java.util.*;

public class Organization {
	public String name ;
    
	public Student head; 
	public Vector<User> members;
   
	public String instagramAccLink;
	public String telegramAccLink;
	
	public Organization() {}
	
	public Organization(String name) {
		this.name = name;
	}
	
	public Organization(String name, Student head, 
			Vector<User> members, 
			String instagramAccLink,
			String telegramAccLink) {
		this.name = name;
		this.head = head;
		this.members = members;
		this.instagramAccLink = instagramAccLink;
		this.telegramAccLink = telegramAccLink;
	}	

	public String toString() {
		
	}
	
	public boolean equals(Object o) {
		
	}
	
	public int hashCode() {
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
	
	public int compareTo() {
		
	}
	public Object clone() throws CloneNotSupportedException {
		
	}
}
