package Model;

import java.util.*;
import java.util.Map.Entry;

import Config.Database;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian extends Employee {

	
	public Librarian(User user) {
		super(user);
	}
	
    public Librarian(User user, double salary) {
		super(user, salary);
	}

    
    
    //                          Operations                   
    
    public static boolean giveBook(Book book, User user) { 
    	HashMap<User, Map<LocalDate, Book>> booksBorrowed = Database.borrowedBooks;
    	if (Librarian.removeBookFromLibrary(book)) {
    		Map<LocalDate, Book> userBooks = booksBorrowed.get(user);
    		userBooks.put(LocalDate.now().plusMonths(6), book);
    		booksBorrowed.put(user, userBooks);
    		return true;
    	}
    	return false;
    }
    
    public static boolean returnBook(Book book, User user) { 
    	Map<LocalDate, Book> userBooks = Database.borrowedBooks.get(user);
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
    	HashMap<Book, Integer> booksInLib = Database.booksInLibrary;
    	
    	if (booksInLib.containsKey(book)) {
    		booksInLib.put(book, booksInLib.get(book) + 1);
    	}
    	else { 
    		booksInLib.put(book, 1);
    	}
    	return true;
    }
    
    public static boolean removeBookFromLibrary(Book book) {
    	HashMap<Book, Integer> booksInLib = Database.booksInLibrary;
    	
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
    
    
}



