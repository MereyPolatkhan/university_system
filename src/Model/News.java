package Model;


import java.util.*;

public class News {
    
   
    public String header;
    
    public String description;
    
    public Vector<Comment> comments;
        
    public News() {
    	
    }
    
    public News(String header, String description) {
    	this.header = header;
    	this.description = description; 
    }

    public News(String header, String description, Vector<Comment> comments) {
    	this(header, description); 
    	this.comments = comments;
    }
    
    public static void writeNewsComment(Comment com, News news) {
    	news.comments.add(com);
    }
    
    public void writeNewsComment(Comment com) {
    	this.comments.add(com);
    }

}

