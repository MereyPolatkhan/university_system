package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import Model.*;

public class Database implements Serializable{
	public static Vector<Course> registrationCourses;
	public static Vector<User> users;
	

	private final static String BASE_PATH = "C:\\Users\\USER\\eclipse-workspace\\FinalProject\\Database\\";
	private static Database INSTANCE;
	
	

	static {
		if (new File(BASE_PATH + "users.ser").exists()) {
			try {
				deserializeUsers();
			} catch (Exception e) {
				System.out.println("Error in serializing");
				e.printStackTrace();
			}
		}
		else {
			users = new Vector<User>();
		}
		
		if (new File(BASE_PATH + "courses.ser").exists()) {
			try {
				deserializeCourses();
			} catch (Exception e) {
				System.out.println("Error in serializing");
				e.printStackTrace();
			}
		}
		else {
			registrationCourses = new Vector<Course>();
		}
		
	}
	
	private Database() {}
	
	
	public static Database getINSTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}
	
	public static void serializeAll() {
		serializeUsers();
		serializeCourses();
	}
	
	public static void serializeUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(BASE_PATH + "users.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Database.users);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deserializeUsers() {
		try {
			FileInputStream fis = new FileInputStream(BASE_PATH + "users.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Database.users = (Vector<User>) ois.readObject();
			fis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void serializeCourses() {
		try {
			FileOutputStream fos = new FileOutputStream(BASE_PATH + "courses.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Database.registrationCourses);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deserializeCourses() {
		try {
			FileInputStream fis = new FileInputStream(BASE_PATH + "courses.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Database.registrationCourses = (Vector<Course>) ois.readObject();
			fis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	

}


// make serialization on Database.INSTANCE;
// сериализировать все векторы сразу
// по поводу REGEX я думаю создать синглтон класс который как MATH class
// по остальным вопросам Пакита ответила и я записал у себя на draft paper;
