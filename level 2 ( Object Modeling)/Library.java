import java.util.ArrayList;

// Library Class
class Library {
    // Attributes of library
    private ArrayList<Book> books;

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void displayBooks() {
        System.out.println("Library contains the following books:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

// Book Class
class Book {
    // Attributes of book
    private String title;
    private String author;

    // Constructor to initialize the book
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Main {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("Ramayana", "Valmiki");
        Book book2 = new Book("Bhagwad Gita", "Maharishi Vedvyasa");
        Book book3 = new Book("Mahabharata", "Maharishi Vedvyasa");

        // Create libraries
        Library library1 = new Library();
        Library library2 = new Library();

        // Add books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

        // Display books in each library
        System.out.println("Library 1:");
        library1.displayBooks();

        System.out.println("\nLibrary 2:");
        library2.displayBooks();
    }
}
