package intranet;

import java.util.*;

public class Librarian extends Employee {

	
	public Librarian(User user) {
		super(user);
	}
	
    public Librarian(User user, double salary) {
		super(user, salary);
	}

    
    //                          Operations                                  
    public boolean giveBook(Book book, User user) { // to user
    	if (Database.books.remove(book)) {
    		Vector<Book> userBooks = Database.borrowedBooks.get(user);
    		if (userBooks.add(book)) {
    			Database.borrowedBooks.put(user, userBooks);
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
    
    public boolean returnBook(Book book, User user) { // from User
		Vector<Book> userBooks = Database.borrowedBooks.get(user);
		if (userBooks.remove(book)) {
			Database.borrowedBooks.put(user, userBooks);
			return Database.books.add(book);
		}
		return false;
    }
    
    
}



