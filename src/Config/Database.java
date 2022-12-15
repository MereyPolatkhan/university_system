package Config;

import java.util.*;

import Model.*;

import java.time.LocalDate;
public final class Database {

	private final static String BASE_PATH = "C:\\Users\\USER\\eclipse-workspace\\FinalProject\\Database\\";
	private String path;
	private static Database INSTANCE;
	
	public static Vector<Student> students;
	public static Vector<Teacher> teachers;
	public static Vector<Manager> managers;
    public static Vector<Request> requests;
	public static Vector<News> news;
	public static Vector<Course> registrationCourses;
	public static Vector<User> users;
	public static Vector<String> lastUserActions;
	public static HashMap<Book, Integer> booksInLibrary;
	public static HashMap<User, Map<LocalDate, Book>> borrowedBooks;
	public static Vector<String> researchPapers;
	public static Vector<String> researchProjects;
	
	static {
		try {
			INSTANCE = new Database(BASE_PATH);
		}
		catch (Exception e) {
			throw new RuntimeException("Exception occured in creating Singleton Database Instance");
		}
	}
	
	private Database(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
    
	public static Database getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new Database(BASE_PATH);
		}
		return INSTANCE;
	}
    
}
