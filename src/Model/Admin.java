package Model;


import java.io.Serializable;
import java.util.Vector;

import Config.Database;

public class Admin extends Employee implements Serializable{
	public static Vector<String> lastUserActions = new Vector<String>();

	public Admin(User user) {
		super(user);
	}
    
    
    public Admin(User user, String firstLastName, String login, String password) {
    	super(user, firstLastName, login, password);
    }
	
    public Admin(User user, String firstLastName, String login, String password, double salary)  {
    	super(user, firstLastName, login, password);
    	super.setSalary(salary);
    }
    
	//                          Operations                                  
    
    public static boolean addUser(User user) {
    	return Database.users.add(user);
    }
    
    public static boolean removeUser(User user) {
        return Database.users.remove(user);
    }

	public static  Vector<String> getLastActions() {
		return Admin.lastUserActions;
	}
	

    public String toString() {
    	return "Admin: " + super.toString();
    }
    

}
