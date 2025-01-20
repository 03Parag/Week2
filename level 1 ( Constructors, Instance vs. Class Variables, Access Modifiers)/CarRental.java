// Create CarRental class to initialize the rental details and calculate total cost.
public class CarRental {
    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Default constructor
    public CarRental() {
        customerName = "Unknown Customer"
        carModel = "Unknown Car Model"
        rentalDays = 1
        dailyRates = 1.0
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Method to calculate total cost
    private double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: Rs" + dailyRate);
        System.out.println("Total Cost: Rs" + calculateTotalCost());
    }

    public static void main(String[] args) {
        // Creating a CarRental instance using the parameterized constructor
        CarRental rental1 = new CarRental("Joe Biden", "Toyota Camry", 5, 3000);
        rental1.displayRentalDetails();

        // Creating a CarRental instance using the default constructor
        CarRental rental2 = new CarRental();
        rental2.displayRentalDetails();
    }
}
