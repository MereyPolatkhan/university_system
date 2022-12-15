package Model;

import java.util.Vector;

public class UserDecorator implements User {

    protected User user;
    
    
    public UserDecorator(User user) {
    	this.user = user;
    }
    
    //                          Operations                                  
    
    public boolean authenticate() {
        return this.user.authenticate();
    }
    public void writeCommentInNews(String text, News news) {
        this.user.writeCommentInNews(text, news);
    }
    
    public Vector<News> viewNews() {
        return this.viewNews();
    }
 
    
}
