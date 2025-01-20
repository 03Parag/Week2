// Create Vehicle class to update the registration fees
public class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable
    private static double registrationFee = 500.0; 

    // Parameterized constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs" + registrationFee);
    }

    // Method to update the registration fee
    public static void updateRegistrationFee(double newRegistrationFee) {
        registrationFee = newRegistrationFee;
        System.out.println("Registration fee updated to: Rs" + registrationFee);
    }

    public static void main(String[] args) {
        // Create vehicle instances
        Vehicle vehicle1 = new Vehicle("John Doe", "Car");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle");

        // Display vehicle details
        System.out.println("Vehicle 1 Details:");
        vehicle1.displayVehicleDetails();

        System.out.println("\nVehicle 2 Details:");
        vehicle2.displayVehicleDetails();

        // Update registration fee
        System.out.println("\nUpdating Registration Fee...");
        Vehicle.updateRegistrationFee(750.0);

        // Display vehicle details again to reflect updated registration fee
        System.out.println("\nVehicle 1 Details (After Update):");
        vehicle1.displayVehicleDetails();

        System.out.println("\nVehicle 2 Details (After Update):");
        vehicle2.displayVehicleDetails();
    }
}
