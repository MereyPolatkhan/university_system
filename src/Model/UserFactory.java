package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserFactory {


	public static User createUser(String who, String firstLastName, String login, String password) {
		if ("Teacher".equalsIgnoreCase(who)) {
			return new Teacher(new BasicUser(), firstLastName, login, password);
		}
		else if ("Manager".equalsIgnoreCase(who)) {
			return new Manager(new BasicUser(), firstLastName, login, password);
		}
		else if ("Admin".equalsIgnoreCase(who)) {
			return new Admin(new BasicUser(), firstLastName, login, password);
		}
		else if ("Librarian".equalsIgnoreCase(who)) {
			return new Librarian(new BasicUser(), firstLastName, login, password);
		}
		else if ("Student".equalsIgnoreCase(who)) {
			return new Student(new BasicUser(), firstLastName, login, password);
		}
		else return new BasicUser(firstLastName, login, password);
	}
	
	public static User createUser(String who) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Provide First Last name: ");
		String firstLastName = "";
		try {
			firstLastName = br.readLine().trim();
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
		System.out.println("Provide login: ");
		String login = "";
		try {
			login = br.readLine().trim();
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
		System.out.println("Provide password: ");
		String password = "";
		try {
			password = br.readLine().trim();
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
			
		return UserFactory.createUser(who, firstLastName, login, password);
	}
	
	public static User createUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String who = "User";
		
		System.out.println("Provide who do u wanna create: 1.Teacher\n2.Manager\n3.Admin\n4.Librarian\n5.Student");
		int num = 0;
		try {
			num = Integer.parseInt(br.readLine());
			if (num == 1) who = "Teacher";
			if (num == 2) who = "Manager";
			if (num == 3) who = "Admin";
			if (num == 4) who = "Librarian";
			if (num == 5) who = "Student";
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write int type");
			e.printStackTrace();
		}
		
		return UserFactory.createUser(who);
		
	}
    
}
