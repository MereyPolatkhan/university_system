package Model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Comparable<Book>, Cloneable, Serializable{

    public String name;
    
    public String author;

    public Book() {
    } 
    
    public Book(String name, String author) {
    	this.name = name;
    	this.author = author;
    }
    
    public String toString() {
    	return "book: " + name + ", author: " + author;
    }
	
    public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Book b = (Book)o;
		return b.name.equals(this.name) && b.author.equals(this.author);
    }
    
    public int hashCode() { 
    	return Objects.hash(name, author);
    }
    
    public Object clone() {
    	Book newBook = new Book();
    	newBook.name = this.name;
    	newBook.author = this.author;
    	return newBook;
    }

	@Override
	public int compareTo(Book b) {
		return this.name.compareTo(b.name);
	}
}
