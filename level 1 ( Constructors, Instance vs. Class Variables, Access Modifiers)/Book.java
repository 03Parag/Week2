// Create Book class to make both default and parameterized constructors
public class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs" + price);
    }

    public static void main(String[] args) {
        // Creating a book with default constructor
        Book defaultBook = new Book();
        defaultBook.displayInfo();

        // Creating a book with parameterized constructor
        Book parameterBook = new Book("Ramayana", "Valmiki", 2353);
        parameterBook.displayInfo();
    }
}
