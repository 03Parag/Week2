// Create MovieTicket class to manage movie ticket booking
public class MovieTicket {
    // Attributes of the movie ticket class
    private String movieName;
    private int seatNumber;
    private double price;
    // Constructor to initialize the movie name, seat number and price
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        // Default: No seat assigned yet
        this.seatNumber = -1; 
        // Default: Price not set
        this.price = 0.0;     
    }
    // Method to book a ticket
    public void bookTicket(int seatNumber, double price) {
        if (this.seatNumber != -1) {
            System.out.println("Ticket is already booked for this seat!  Seat Number: " + this.seatNumber);
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            System.out.println("Ticket booked successfully!");
        }
    }
    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        if (seatNumber == -1) {
            System.out.println("Seat Number: Not booked yet.");
            System.out.println("Price: Not available.");
        } else {
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
    public static void main(String[] args) {
        // Create a MovieTicket object 
        MovieTicket ticket = new MovieTicket("The Exorcist");
        // Display ticket details before booking
        System.out.println("Before Booking:");
        ticket.displayTicketDetails();
        // Book the ticket
        ticket.bookTicket(25, 12.5);
        // Display ticket details after booking
        System.out.println("\nAfter Booking:");
        ticket.displayTicketDetails();
        // Attempt to book the ticket again
        System.out.println("\nTrying to book the ticket again:");
        ticket.bookTicket(30, 15.0);
    }
}
