package intranet;

import java.util.Vector;

public class Admin {
    private static Admin INSTANCE;
    private Vector<User> users;
    private Vector<String> lastActions;


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

    boolean addUser(User user) {
        try {
            users.add(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Exception in inserting to users vector");
        }
    }
    
    boolean removeUser(User user) {
        try {
            users.remove(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Exception in deleting from users vector");
        }
    }

	public Vector<String> getLastActions() {
		return lastActions;
	}

}
