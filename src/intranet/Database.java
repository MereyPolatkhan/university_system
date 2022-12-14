package intranet;

import java.util.Vector;

public class Database {

	
	private static Database INSTANCE;
	
	public static Vector<Student> students;
	public static Vector<Teacher> teachers;
	public static Vector<Manager> managers;
    public static Vector<Request> requests;
	public static Vector<News> news;
	public static Vector<Course> registrationCourses;
	public static Vector<User> users;
	public static Vector<String> lastUserActions;
	
	
	static {
		try {
			INSTANCE = new Database();
		}
		catch (Exception e) {
			throw new RuntimeException("Exception occured in creating Singleton Database Instance");
		}
	}
	
	private Database() {}
    
	public static Database getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}
    
}
