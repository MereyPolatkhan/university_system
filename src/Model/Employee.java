package Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Employee extends UserDecorator implements Serializable {

	private double salary;
	
	private Vector<String> messages = new Vector<String>();
    
	{
		messages = new Vector<String>();
	}
	
    public Employee(User user) {
		super(user);
	}

    public Employee(User user, double salary) {
    	super(user);
    	this.salary = salary;
    }
    
    public Employee(User user, String firstLastName) {
    	super(user, firstLastName);
    }
    
    public Employee(User user, String firstLastName, double salary) {
    	super(user, firstLastName);
    	this.salary = salary;
    }
    
    public Employee(User user, String firstLastName, String password)  {
    	super(user, firstLastName, password);
    }
    
    public Employee(User user, String firstLastName, String login, String password)  {
    	super(user, firstLastName, login, password);
    }
    
    public Employee(User user, String firstLastName, String login, String password, boolean isResearcher)  {
    	super(user, firstLastName, login, password, isResearcher);
    }
        
    
    

    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    //                          Operations                                 
    
    public void writeMessage(String message, Employee e) {
    	e.getMessages().add(message);	
    }


	public Vector<String> getMessages() {
		return messages;
	}
    
	public String toString() {
		return "Employee: " + super.toString() + "salary: " + salary;
	}
    
	public boolean equals(Object o) {
		if (!super.equals(o)) {
			return false;
		}
		
		Employee e = (Employee)o;
		return 
				e.salary == this.salary;
	}
	
	public int hashCode() {
		return super.hashCode() + Objects.hash(salary, messages);
	}
	
	public int compareTo(UserDecorator user) {
		if (super.compareTo(user) != 0) {
			return super.compareTo(user);
		}
		Employee e = (Employee) user;
		if (this.salary  < e.salary) {
			return -1;
		}
		else if (this.salary > e.salary) {
			return 1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Employee newEmp = new Employee(user);
		newEmp.salary = this.salary;
		Vector<String> newMessages = new Vector<String>();
		// String immutable so i can make newEmp.messages = this.messages;
		for (String s: this.messages) {
			newMessages.add(s);
		}
		newEmp.messages = newMessages;
		return newEmp;
	}
}
