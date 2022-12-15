package Model;

import java.util.Vector;

public class Admin extends Employee{

	public Admin(User user) {
		super(user);
	}
	
    public Admin(User user, double salary) {
		super(user, salary);
	}

	//                          Operations                                  

    public boolean addUser(User user) {
    	return Database.users.add(user);
    }
    
    public boolean removeUser(User user) {
        return Database.users.remove(user);
    }

	public Vector<String> getLastActions() {
		return Database.lastUserActions;
	}

}
