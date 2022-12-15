package Model;

import java.util.Vector;

public class BasicUser implements User {
    
    public String fullName;
    public int id;
    public String login ;
    public boolean isResearcher;

    public BasicUser() {

    }
    public BasicUser(String fullName, int id, String login) {
        this.fullName = fullName;
        this.id = id;
        this.login = login;
    }

    public BasicUser(String fullName, int id, String login, boolean isResearcher) {
        this(fullName, id, login);
        this.isResearcher = isResearcher;
    }



    //                          Operations

    public boolean authenticate() {
        try {
            Admin instance = Admin.getINSTANCE();
            if (instance.addUser(this)) {
                return true;
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Exception occured when getting INSTANCE of Admin");
        }
        return false;
		
    }
    
    public void writeCommentInNews(String text, News news) {
    	Comment com = new Comment(this, text);
    	News.writeNewsComment(com, news);
    }
    

    public Vector<News> viewNews() {
        return News.news;
    }
    
}
