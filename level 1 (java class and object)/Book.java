// Create Book class to display the book details like title, author and price
public class Book {
    // Attributes of the book 
    private String title;
    private String author;
    private int price;
    // Constructor to initialize the title,author and price
    public Book (String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Method to display the title, author and price of the book
    public void displayDetails() { 
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Price: " + price);
    }
    public static void main(String[]args) {
        // Create a book using the given details
        Book book1 = new Book("Ramayana", "Valmiki", 2363);
        // Display the details of the book
        book1.displayDetails();
    }    
}
           