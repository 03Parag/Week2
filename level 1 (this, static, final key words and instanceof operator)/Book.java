// Create Book class to check if a book is an instanceof library
public class Book {
    // Static variable for the library name
    private static String libraryName = "City Library";

    // Final variable for the book's ISBN
    private final String isbn;

    // Instance variables for the book's title and author
    private String title;
    private String author;

    // Parameterized constructor to initialize the book details
    public Book(String title, String author, String isbn) {
        this.title = title; 
        this.author = author; 
        this.isbn = isbn; // Assigning the final variable
    }

    // Method to display the library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        if (this instanceof Book) { // Check if the object is an instance of Book
            System.out.println("Library Name: " + libraryName);
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }

    // Method to set the library name
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static void main(String[] args) {
        // Set a library name
        Book.setLibraryName("Bhopal Library");

        // Create book objects
        Book book1 = new Book("Ramayana", "Valmiki", "123-4567890123");
        Book book2 = new Book("Bhagwad Gita", "Maharishi Vedavyasa", "456-1234567890");

        // Display the library name
        Book.displayLibraryName();
        System.out.println();

        // Display details of each book
        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
    }
}
