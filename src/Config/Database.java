package Config;

import java.util.*;

import Model.*;

import java.time.LocalDate;
public final class Database {
	
	// make serialization on Database.INSTANCE;
	// сериализировать все векторы
	// по поводу REGEX я думаю создать синглтон класс который как MATH class
	// по остальным вопросам Пакита ответила и я записал у себя на draft paper;
	// guess i need win and wish more energy for Pakite

	private final static String BASE_PATH = "C:\\Users\\USER\\eclipse-workspace\\FinalProject\\Database\\";
	private String path;
	private static Database INSTANCE;
	
    public static Vector<Request> requests;
	public static Vector<News> news;
	public static Vector<Course> registrationCourses;
	public static Vector<User> users;
	public static Vector<String> lastUserActions;
	public static HashMap<Book, Integer> booksInLibrary;
	public static HashMap<User, Map<LocalDate, Book>> borrowedBooks;
	public static Vector<String> researchPapers;
	public static Vector<String> researchProjects;
	public static Vector<Organization> organizations;
	
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
	
	public static Vector<Teacher> getTeachersFromDB() {
		Vector<Teacher> teachers = new Vector<Teacher>();
		for (User u: Database.users) {
			if (u instanceof Teacher) {
				teachers.add((Teacher)u);
			}
 		}
		return teachers;
	}
	
	public static Vector<Manager> getManagersFromDB() {
		Vector<Manager> managers = new Vector<Manager>();
		for (User u: Database.users) {
			if (u instanceof Manager) {
				managers.add((Manager)u);
			}
 		}
		return managers;
	}
 
	public static Vector<Student> getStudentsFromDB() {
		Vector<Student> students = new Vector<Student>();
		for (User u: Database.users) {
			if (u instanceof Student) {
				students.add((Student)u);
			}
 		}
		return students;
	}
    
	public static Vector<Admin> getAdminsFromDB() {
		Vector<Admin> admins = new Vector<Admin>();
		for (User u: Database.users) {
			if (u instanceof Admin) {
				admins.add((Admin)u);
			}
 		}
		return admins;
	}
	
	public static Vector<Librarian> getLibrariansFromDB() {
		Vector<Librarian> librarians = new Vector<Librarian>();
		for (User u: Database.users) {
			if (u instanceof Librarian) {
				librarians.add((Librarian)u);
			}
 		}
		return librarians;
	}
	
	public static Vector<Employee> getEmployeeFromDB() {
		Vector<Employee> employees = new Vector<Employee>();
		for (User u: Database.users) {
			if (u instanceof Employee) {
				employees.add((Employee)u);
			}
 		}
		return employees;
	}
    
}
