package Model;

import java.io.Serializable;
import java.util.*;

public class Organization implements Serializable {
	public static Vector<Organization> organizations = new Vector<Organization>();
	public String name;
    
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
		return "Organization: " + name + ", head: " + head + ", members: " + members + ", contacts: " + instagramAccLink + " and "  + telegramAccLink;
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
		Organization org = (Organization)o;
		return org.name.equals(this.name) && 
				org.head.equals(this.head) && 
				org.instagramAccLink.equals(this.instagramAccLink) &&
				org.telegramAccLink.equals(this.telegramAccLink) && 
				org.members.equals(this.members);
	}
	
	public int hashCode() {
		return Objects.hash(name, head, instagramAccLink, telegramAccLink, members);
	}
	
	public int compareTo(Organization o) {
		return this.name.compareTo(o.name);
	}
	public Object clone() throws CloneNotSupportedException {
		Organization newOrg = new Organization();
		newOrg.name = this.name;
		newOrg.head = (Student) this.head.clone();
		newOrg.instagramAccLink = this.instagramAccLink;
		newOrg.telegramAccLink = this.telegramAccLink;
		Vector<User> newMembers = new Vector<User>();
		for (User u: this.members) {
			UserDecorator ud = (UserDecorator)u;
			newMembers.add(ud);
		}
		newOrg.members = newMembers;
		return newOrg;
	}
}
