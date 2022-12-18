package Model;


import java.util.Vector;

import Config.Database;

public class Admin extends Employee{

	public Admin(User user) {
		super(user);
	}
	
    public Admin(User user, double salary) {
		super(user, salary);
	}

    public Admin(User user, String firstLastName) {
    	super(user, firstLastName);
    }
    
    public Admin(User user, String firstLastName, double salary) {
    	super(user, firstLastName, salary);
    }
    
    public Admin(User user, String firstLastName, String password)  {
    	super(user, firstLastName, password);
    }
    
    public Admin(User user, String firstLastName, String login, String password)  {
    	super(user, firstLastName, login, password);
    }
    
	//                          Operations                                  
    
    public static boolean addUser(User user) {
    	return Database.users.add(user);
    }
    
    public static boolean removeUser(User user) {
        return Database.users.remove(user);
    }

	public static  Vector<String> getLastActions() {
		return Database.lastUserActions;
	}
	
    
    public String toString() {
    	return "Admin: " + super.toString();
    }

}
