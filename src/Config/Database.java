package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;

import Model.*;

public final class Database {
	public static Vector<Request> requests = new Vector<Request>();
	public static Vector<News> news = new Vector<News>();
	public static Vector<Course> registrationCourses = new Vector<Course>();
	public static Vector<User> users = new Vector<User>();
	public static Vector<String> lastUserActions = new Vector<String>();
	public static HashMap<Book, Integer> booksInLibrary = new HashMap<Book, Integer>();
	public static HashMap<User, Map<LocalDate, Book>> borrowedBooks = new HashMap<User, Map<LocalDate, Book>>();
	public static Vector<String> allResearchPapers = new Vector<String>();
	public static Vector<String> allResearchProjects = new Vector<String>();
	public static Vector<Organization> organizations = new Vector<Organization>();
	public static Vector<Department> depatments = new Vector<Department>();

	private final static String BASE_PATH = "C:\\Users\\USER\\eclipse-workspace\\FinalProject\\Database\\";
	private static Database INSTANCE;
	private String path;
	
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
//		if (INSTANCE == null) {
//			INSTANCE = new Database(BASE_PATH);
//		}
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
	
	public static Vector<ResearcherDecorator> getResearchersFromDB() {
		Vector<ResearcherDecorator> researchers = new Vector<ResearcherDecorator>();
		for (User u: Database.users) {
			if (u instanceof ResearcherDecorator) {
				researchers.add((ResearcherDecorator)u);
			}
		}
		return researchers;
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
	
	public static void serialize() {
		try (FileOutputStream fs = new FileOutputStream(Database.getINSTANCE().getPath() + "datas.txt")){                                
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(Database.getINSTANCE());
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void deserialize() {
		try (FileInputStream fis = new FileInputStream(Database.getINSTANCE().getPath() + "datas.txt")) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			INSTANCE = (Database) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Error with deserializing");
	}
}


// make serialization on Database.INSTANCE;
// сериализировать все векторы сразу
// по поводу REGEX я думаю создать синглтон класс который как MATH class
// по остальным вопросам Пакита ответила и я записал у себя на draft paper;
