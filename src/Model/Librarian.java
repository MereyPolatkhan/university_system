package Model;

import java.util.*;
import java.util.Map.Entry;

import Config.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian extends Employee implements Serializable {

	public static HashMap<Book, Integer> booksInLibrary;
	public static HashMap<User, Map<LocalDate, Book>> borrowedBooks;
	static {
		if (new File(Database.getPath() + "books.ser").exists()) {
			try {
				deserializeBooksInLib();
			} catch (Exception e) {
				System.out.println("Error in serializing");
				e.printStackTrace();
			}
		}
		else {
			booksInLibrary = new HashMap<Book, Integer>();
		}
		
		if (new File(Database.getPath() + "borrowed.ser").exists()) {
			try {
				deserializeBorrowed();
			} catch (Exception e) {
				System.out.println("Error in serializing");
				e.printStackTrace();
			}
		}
		else {
			borrowedBooks = new HashMap<User, Map<LocalDate, Book>>();
		}
	}
	

	public static void serializeBooksInLib() {
		try {
			FileOutputStream fos = new FileOutputStream(Database.getPath() + "books.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Librarian.booksInLibrary);
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
	
	public static void deserializeBooksInLib() {
		try {
			FileInputStream fis = new FileInputStream(Database.getPath() + "books.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Librarian.booksInLibrary = (HashMap<Book, Integer>) ois.readObject();
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
	

	public static void serializeBorrowed() {
		try {
			FileOutputStream fos = new FileOutputStream(Database.getPath() + "borrowed.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Librarian.borrowedBooks);
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
	
	public static void deserializeBorrowed() {
		try {
			FileInputStream fis = new FileInputStream(Database.getPath() + "borrowed.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Librarian.borrowedBooks = (HashMap<User, Map<LocalDate, Book>>) ois.readObject();
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
	
		
	
	
	
	public Librarian(User user) {
		super(user);
	}
	
    public Librarian(User user, String firstLastName, String login, String password) {
    	super(user, firstLastName, login, password);
    }
	
    public Librarian(User user, String firstLastName, String login, String password, double salary)  {
    	super(user, firstLastName, login, password);
    	super.setSalary(salary);
    }
    
    
    //                          Operations                   
    
    public static boolean giveBook(Book book, User user) { 
    	HashMap<User, Map<LocalDate, Book>> booksBorrowed = Librarian.borrowedBooks;
    	if (Librarian.removeBookFromLibrary(book)) {
    		Map<LocalDate, Book> userBooks = booksBorrowed.get(user);
    		userBooks.put(LocalDate.now().plusMonths(6), book);
    		booksBorrowed.put(user, userBooks);
    		return true;
    	}
    	return false;
    }
    
    public static boolean returnBook(Book book, User user) { 
    	Map<LocalDate, Book> userBooks = Librarian.borrowedBooks.get(user);
    	if (userBooks.containsValue(book)) {
    		for (Entry<LocalDate, Book> entry: userBooks.entrySet()) {
    			if (entry.getValue() == book) {
    				LocalDate deadline = entry.getKey();
    				long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    				if (daysBetween > 30 * 6) {
    					System.out.println("Your duration exceeded 6 months");
    					return false;
    				}
    				else {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean addBookToLibrary(Book book) {
    	HashMap<Book, Integer> booksInLib = Librarian.booksInLibrary;
    	
    	if (booksInLib.containsKey(book)) {
    		booksInLib.put(book, booksInLib.get(book) + 1);
    	}
    	else { 
    		booksInLib.put(book, 1);
    	}
    	return true;
    }
    
    public static boolean removeBookFromLibrary(Book book) {
    	HashMap<Book, Integer> booksInLib = Librarian.booksInLibrary;
    	
    	if (booksInLib.containsKey(book)) {
    		if (booksInLib.get(book) >= 2) {
    			booksInLib.put(book, booksInLib.get(book) - 1);
    		}
    		else {
    			booksInLib.remove(book);
    		}
    		return true;
    	}
    	return false;
    }
    
    
    public String toString() {
    	return "Librarian: " + super.toString();
    }
    
    
}



