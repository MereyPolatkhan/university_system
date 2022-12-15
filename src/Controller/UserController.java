package Controller;

import java.io.Serializable;

import Model.User;

public class UserController implements Serializable{
	
	public User user;
	
	public UserController(User user) {
		this.user = user;
	}
	
	public boolean verifyLogin(String login, String password) {
		return user.getLogin().equals(login) && user.getPassword().equals(password);
	}

}
