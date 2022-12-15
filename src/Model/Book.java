package Model;

public class Book {

    public String name;
    
    public String description;

    public Book() {} 
    
    public Book(String name) {
    	this.name = name;
    	this.description = "Undefined";
    }
    public Book(String name, String description) {
    	this(name);
    	this.description = description;
    }
	
}
