package Controller;

import java.io.Serializable;

import Config.Database;
import View.NewsView;

public class UserController implements Serializable {
	public void save() {
		Database.serializeAll();
	}
	
	public void exit() {
		System.out.println("Bye bye");
		save();
	}
	
	public void seeNews() {
		NewsView.printNews();
	}
	
}
