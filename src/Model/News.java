package Model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Config.Database;

public class News implements Serializable {
	public static Vector<News> news;
   
	

	static {
		if (new File(Database.getPath()+ "news.ser").exists()) {
			try {
				deserializeNews();
			} catch (Exception e) {
				System.out.println("Error in serializing");
				e.printStackTrace();
			}
		}
		else {
			news = new Vector<News>();
		}
	}
	
	public static void serializeNews() {
		try {
			FileOutputStream fos = new FileOutputStream(Database.getPath()+ "news.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(News.news);
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
	
	public static void deserializeNews() {
		try {
			FileInputStream fis = new FileInputStream(Database.getPath()+ "news.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			News.news = (Vector<News>) ois.readObject();
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

