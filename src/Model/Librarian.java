package Model;

import java.util.*;
import java.util.Map.Entry;

import Config.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian extends Employee implements Serializable {

	public static HashMap<Book, Integer> booksInLibrary = new HashMap<Book, Integer>();
	public static HashMap<User, Map<LocalDate, Book>> borrowedBooks = new HashMap<User, Map<LocalDate, Book>>();

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



