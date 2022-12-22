package Controller;

import View.LibrarianView;
import View.NewsView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Config.Database;
import Model.*;

public class LibrarianController extends UserController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Librarian model;
	public LibrarianView view;
	
	
	public LibrarianController(Librarian model, LibrarianView view) {
		this.model = model;
		this.view = view;
	}
	
	public Librarian createLibrarian() {
		Librarian librarian = (Librarian) UserFactory.createUser("Librarian");
		return librarian;
	}
	
	public static void giveBook() {
		Book book = new Book();
		System.out.println("Please provide book name: ");
		try {
			String bookName = br.readLine().trim();
			book.name = bookName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please provide book author: ");
		try {
			String bookAuthor = br.readLine().trim();
			book.author = bookAuthor;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Who wants " + book + "? Provide user login: ");
		try {
			String login = br.readLine().trim();
			for (User u: Database.users) {
				UserDecorator ud = (UserDecorator)u;
				if (ud.login.equals(login)) {
					if (Librarian.booksInLibrary.containsKey(book)) {
						Librarian.giveBook(book, u);
						System.out.println("book is given successfully");
						return;
					}
					System.out.println("Library doesnt have this book");
					return;
				}
			}
			System.out.println("User is not in the system");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void returnBook() {
		Book book = new Book();
		System.out.println("Please provide book name: ");
		try {
			String bookName = br.readLine().trim();
			book.name = bookName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please provide book author: ");
		try {
			String bookAuthor = br.readLine().trim();
			book.author = bookAuthor;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Who wants to return " + book + "? Provide user login: ");
		try {
			String login = br.readLine().trim();
			for (User u: Database.users) {
				UserDecorator ud = (UserDecorator)u;
				if (ud.login.equals(login)) {
					if (Librarian.borrowedBooks.get(u).containsValue(book)) {
						if (Librarian.returnBook(book, u)) {
							System.out.println("Successfully book returned");
							return;
						}
						System.out.println("Something not good happened");
						return;
					}
					System.out.println("User doesnt have this book");
					return;
				}
			}
			System.out.println("User is not in the system");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void addBookToLibrary() {
		Book book = new Book();
		System.out.println("Please provide book name: ");
		try {
			String bookName = br.readLine().trim();
			book.name = bookName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please provide book author: ");
		try {
			String bookAuthor = br.readLine().trim();
			book.author = bookAuthor;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Librarian.addBookToLibrary(book)) {
			System.out.println("Book added");
		}
		else {
			System.out.println("Book wasnt added, try pls again");
		}
	}
	
	
	public static void removeBookFromLibrary() {
		Book book = new Book();
		System.out.println("Please provide book name: ");
		try {
			String bookName = br.readLine().trim();
			book.name = bookName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please provide book author: ");
		try {
			String bookAuthor = br.readLine().trim();
			book.author = bookAuthor;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Librarian.addBookToLibrary(book)) {
			System.out.println("Book added");
		}
		else {
			System.out.println("Book wasnt added, try pls again");
		}
		
		if (Librarian.booksInLibrary.containsKey(book)) {
			if (Librarian.removeBookFromLibrary(book)) {
				System.out.println("Book is deleted");
				return;
			}
			System.out.println("Book wasnt deleted, try pls again");
			return;
		}
		System.out.println("Book is not in Library");
	}
	
	
	public void run() {
		try {
			System.out.println("Welcome Librarian " + model.firstLastName);
			menu: while (true) {
				System.out.println("What do you want to do?\n "
						+ "1) Give Book \n "
						+ "2) Return Book \n "
						+ "3) Add Book To Library \n "
						+ "4) Remove Book From Library \n "
						+ "5) print Library \n "
						+ "6) see news"
						+ "7) Exit");
				int choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					giveBook: while(true){
						giveBook();
						System.out.println("\n 1) give another Book \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue giveBook;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice == 2) {
					returnBook: while(true){
						returnBook();
						System.out.println("\n 1) return another Book  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue returnBook;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 3) {
					addBookToLibrary: while(true){
						addBookToLibrary();
						System.out.println("\n 1) add another Book To Library  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue addBookToLibrary;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 4) {
					removeBookFromLibrary: while(true){
						removeBookFromLibrary();
						System.out.println("\n 1) remove another Book From Library  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue removeBookFromLibrary;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 5) {
					showLib: while(true){
						LibrarianView.printBooks();
						System.out.println("\n 1) print Library  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue showLib;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 6) {
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
				
				
				else if (choice == 7) {
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
