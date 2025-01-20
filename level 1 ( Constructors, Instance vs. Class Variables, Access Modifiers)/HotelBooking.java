// Create HotelBooking class with attributes guestName, roomType, and nights and use default, parameterized, and copy constructors to initialize bookings
public class HotelBooking {
    // Attributes
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        guestName = "Unknown Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    // Method to display booking details
    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }

    public static void main(String[] args) {
        // Default booking
        HotelBooking defaultBooking = new HotelBooking();
        System.out.println("Default Booking:");
        defaultBooking.displayBookingDetails();

        // Parameterized booking
        HotelBooking parameterBooking = new HotelBooking("Alice Trudeau", "Deluxe", 3);
        System.out.println("\nParameterized Booking:");
        parameterBooking.displayBookingDetails();

        // Copy booking
        HotelBooking copiedBooking = new HotelBooking(parameterBooking);
        System.out.println("\nCopied Booking:");
        copiedBooking.displayBookingDetails();
    }
}
