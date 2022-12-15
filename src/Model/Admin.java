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

}
