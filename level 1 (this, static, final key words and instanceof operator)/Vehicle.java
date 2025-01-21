// Create Vehicle class to check if the object ia an instance of vehicle
public class Vehicle {
    // Static variable for the registration fee (shared by all vehicles)
    private static double registrationFee = 500.00;

    // Final variable for the registration number
    private final String registrationNumber;

    // Instance variables for the owner's name and vehicle type
    private String ownerName;
    private String vehicleType;

    // Parameterized constructor to initialize vehicle details
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display the registration fee
    public static void displayRegistrationFee() {
        System.out.println("Registration Fee: Rs" + registrationFee);
    }

    // Method to display vehicle registration details
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) { // Validate if the object is an instance of Vehicle
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: Rs" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }

    public static void main(String[] args) {
        // Update the registration fee
        Vehicle.updateRegistrationFee(750.00);

        // Create vehicle objects
        Vehicle vehicle1 = new Vehicle("Alice", "Car", "ABC123");
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle", "XYZ789");

        // Display the registration fee
        Vehicle.displayRegistrationFee();
        System.out.println();

        // Display details of each vehicle
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
    }
}