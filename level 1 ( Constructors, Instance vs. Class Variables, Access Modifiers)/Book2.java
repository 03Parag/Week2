// Base class
public class Book2 {
    // Attributes
    public String ISBN;
    protected String title;
    private String author;

    // Parameterized constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Method to set the author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to get the author name
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass
class EBook extends Book {
    private double fileSize; // Size in MB

    // Parameterized constructor
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    // Method to display eBook details
    public void displayEBookDetails() {
        // Accessing public and protected members from the parent class
        System.out.println("ISBN: " + ISBN); // Public member
        System.out.println("Title: " + title); // Protected member
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Author: " + getAuthor());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Book instance
        Book book = new Book("978-3-16-148410-0", "Ramayana", "Valmiki");
        book.displayBookDetails();

        System.out.println("\nCreating an EBook...");
        EBook eBook = new EBook("978-0-345-39180-3", "Bhagavad Gita", "Maharishi Vedvyasa", 2.5);
        eBook.displayEBookDetails();
    }
}
