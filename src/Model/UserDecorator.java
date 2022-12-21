package Model;

import java.io.Serializable;
import java.util.Vector;

public abstract class UserDecorator extends BasicUser implements User, Serializable {

    protected User user;
    
    
    public UserDecorator(User user) {
    	super();
    	this.user = user;
    }
    
    public UserDecorator(User user, String firstLastName) {
    	super(firstLastName);
    	this.user = user;
    }

    public UserDecorator(User user, String firstLastName, String password) {
    	super(firstLastName, password);
    	this.user = user;
    }
    
    public UserDecorator(User user, String firstLastName, String login, String password) {
    	super(firstLastName, login, password);
    	this.user = user;
    }
    
    public UserDecorator(User user, String firstLastName, String login, String password, boolean isResearcher) {
    	super(firstLastName, login, password, isResearcher);
    	this.user = user;
    }
    
    
    //                          Operations                                  
   

	@Override
	public boolean authenticate(String login, String password) {
		this.user.authenticate(login, password);
		return false;
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		this.user.changePassword(oldPassword, newPassword);
		return false;
	}    
    
    @Override
    public void writeCommentInNews(String text, News news) {
        this.user.writeCommentInNews(text, news);
    }
    
    @Override
    public Vector<News> viewNews() {
        return this.viewNews();
    }

}
