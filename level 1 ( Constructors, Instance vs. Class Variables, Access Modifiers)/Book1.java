// Create Book1 class with attributes title, author, price, and availability and make a method to borrow book.
public class Book1 {
    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; 
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (available) {
            available = false; // Update availability status
            System.out.println("The book \"" + title + "\" by " + author + " has been borrowed.");
            return true;
        } else {
            System.out.println("Sorry, the book \"" + title + "\" by " + author + " is currently unavailable.");
            return false;
        }
    }

    // Public method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs" + price);
        if (available) {
            System.out.println("Available: Yes");
        } else {
            System.out.println("Available: No");
        }
    }

    public static void main(String[] args) {
        // Creating a book instance
        Book book = new Book("Ramayana", "Valmiki", 2353);

        // Display book information before borrowing
        System.out.println("Book Details:");
        book.displayInfo();

        // Borrowing the book
        System.out.println("\nAttempting to borrow the book...");
        book.borrowBook();

        // Display book information after borrowing
        System.out.println("\nBook Details After Borrowing:");
        book.displayInfo();

        // Trying to borrow the book again
        System.out.println("\nAttempting to borrow the book again...");
        book.borrowBook();
    }
}
