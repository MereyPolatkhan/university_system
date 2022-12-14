package intranet;

import java.util.Vector;

public class Admin {
    private static Admin INSTANCE;


    static {
        try {
            INSTANCE = new Admin();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating Singleton Admin Instance");
        }
    }
    
    private Admin() {}

    public static Admin getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Admin();
        }
        return INSTANCE;
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
