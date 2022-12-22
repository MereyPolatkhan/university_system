package Model;


import java.io.Serializable;
import java.util.Vector;

import Config.Database;
public class Admin extends Employee implements Serializable{
	
	/*
	 * field to collect last use actions
	 */
	public static Vector<String> lastUserActions = new Vector<String>();

	 /*
     *  constructor to create admin 
     *  @param user 
     */
	public Admin(User user) {
		super(user);
	}
	
	
    
	 /*
     *  constructor to create admin 
     *  @param user
     *  @param First Last Name
     *  @param login
     *  @param password
     *  
     */ 
    public Admin(User user, String firstLastName, String login, String password) {
    	super(user, firstLastName, login, password);
    }
    
    /*
     *  constructor to create admin 
     *  @param user
     *  @param First Last Name
     *  @param login
     *  @param password
     *  @param salary
     *  
     */
    public Admin(User user, String firstLastName, String login, String password, double salary)  {
    	super(user, firstLastName, login, password);
    	super.setSalary(salary);
    }
    
	//                          Operations                                  
    
    /*
     * adding User to Database
     * @param user admin wants to add 
     * @return is added or not
     * */
    public static boolean addUser(User user) {
    	return Database.users.add(user);
    }
    
    
    /*
     * Removes User from Database 
     * @param user admin will delete
     * @return is removed or not
     * */
    public static boolean removeUser(User user) {
        return Database.users.remove(user);
    }
    
    
    /*
     * Gets user's last actions 
     * @return vector of actions
     * */
	public static  Vector<String> getLastActions() {
		return Admin.lastUserActions;
	}
	
	/*
	 * method to return info about admin
	 * @return String
	 */
    public String toString() {
    	return "Admin: " + super.toString();
    }
    

}
