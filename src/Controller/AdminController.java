package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Config.Database;
import Model.*;
import View.*;

public class AdminController extends UserController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Admin model;
	public AdminView view;
	
	public AdminController(Admin model, AdminView view) {
		this.model = model;
		this.view = view;
	}
	
	
	public static void addUser() {
		User u = UserFactory.createUser();
		Admin.addUser(u);
		System.out.println("User Created Succesfully");

	}
	
	public static void removeUser() {
		try {
			System.out.println("Provide login: ");
			String login = br.readLine();
			for (User user: Database.users) {
				UserDecorator ud = (UserDecorator)user;
				if (login.equals(ud.login)) {
					if (Admin.removeUser(user)) {
						System.out.println("User deleted successfully");
						return;
					}
					System.out.println("I guess user is not in DB");
					return;
				}
			}
			System.out.println("User not deleted ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewLastActions() {
		for (String actions: Admin.getLastActions()) {
			System.out.println(actions);
		}
	}
	
	
	
	
	public void run() {
		try {
			System.out.println("Welcome Admin " + model.firstLastName);
			menu: while (true) {
				System.out.println("What do you want to do?\n "
						+ "1) Add user \n "
						+ "2) remove user \n "
						+ "3) view last actions \n "
						+ "4) print users \n "
						+ "5) see news \n"
						+ "6) Exit");
				int choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					addUser: while(true){
						addUser();
						System.out.println("\n 1) add another User\n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue addUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice == 2) {
					removeUser: while(true){
						removeUser();
						System.out.println("\n 1) remove another User  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue removeUser;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 3) {
					viewLastActions: while(true){
						viewLastActions();
						System.out.println("\n 1) view Last Actions  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewLastActions;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 4) {
					print: while(true){
						AdminView.printAllUsers();
						System.out.println("\n 1) print users  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue print;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 5) {
					seeNews: while(true){
						seeNews();
						System.out.println("\n 1) see News \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue seeNews;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 6) {
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
}
