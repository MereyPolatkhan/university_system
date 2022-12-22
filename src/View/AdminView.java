package View;

import Config.Database;
import Model.*;

public class AdminView {
	public static void printAllUsers() {
		if (Database.users.size() == 0) {
			System.out.println("Empty");
		}
		for (User u: Database.users) {
			UserDecorator ud = (UserDecorator)u;
			System.out.println(ud);
		}
	}
}
