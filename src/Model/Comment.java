package Model;

import java.io.Serializable;

public class Comment implements Serializable{
    
    public User author;
    
    public String text;
    
    public Date dateWritten;
    
    
    public Comment() {
    	
    }
    
    public Comment(User author, String text) {
    	this.author = author;
    	this.text = text;
    	this.dateWritten = new Date();
    }
    
    public Comment(User author, String text, Date dateWritten) {
    	this(author, text);
    	this.dateWritten = dateWritten;
    }
    

}
