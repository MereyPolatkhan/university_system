package intranet;


/**
* @generated
*/
public class Librarian  extends Employee {
    
    /**
    * @generated
    */
    private Set<Book> books;
    
    /**
    * @generated
    */
    private Vector<User, Book> borrowedBooks;
    
    /**
    * @generated
    */
    private Librarian INSTANCE;
    
    
    /**
    * @generated
    */
    private Database database;
    
    /**
    * @generated
    */
    private Book book;
    
    

    /**
    * @generated
    */
    public Set<Book> getBooks() {
        return this.books;
    }
    
    /**
    * @generated
    */
    public Set<Book> setBooks(Set<Book> books) {
        this.books = books;
    }
    
    
    /**
    * @generated
    */
    public Vector<User, Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }
    
    /**
    * @generated
    */
    public Vector<User, Book> setBorrowedBooks(Vector<User, Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    
    
    /**
    * @generated
    */
    private Librarian getINSTANCE() {
        return this.INSTANCE;
    }
    
    /**
    * @generated
    */
    private Librarian setINSTANCE(Librarian  INSTANCE) {
        this.INSTANCE = INSTANCE;
    }
    
    
    
    /**
    * @generated
    */
    public Book getBook() {
        return this.book;
    }
    
    /**
    * @generated
    */
    public Book setBook(Book book) {
        this.book = book;
    }
    
    
    /**
    * @generated
    */
    public Database getDatabase() {
        return this.database;
    }
    
    /**
    * @generated
    */
    public Database setDatabase(Database database) {
        this.database = database;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    private boolean giveBook() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    private boolean getBook() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public Librarian getInstance() {
        //TODO
        return null;
    }
    
    
}
