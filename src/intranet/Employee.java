package intranet;

import java.util.Vector;

public abstract class Employee extends UserDecorator {

	private double salary;
	
	private Vector<String> messages;
    
	
	
    public Employee(User user) {
		super(user);
	}

    public Employee(User user, double salary) {
    	super(user);
    	this.salary = salary;
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
    
    
}
