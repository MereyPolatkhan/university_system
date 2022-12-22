package View;

import java.util.Map;
import java.util.Map.Entry;

import Model.Book;
import Model.Librarian;

public class LibrarianView {
	public static void printBooks() {
		for (Entry<Book, Integer> entry: Librarian.booksInLibrary.entrySet()) {
			System.out.println(entry.getKey() + " -------- " + entry.getValue());
		}
	}
}
