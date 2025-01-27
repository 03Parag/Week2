// Vehicle (Abstract Class)
abstract class Vehicle {
    // Attributes for Vehicle
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor for Vehicle
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Get the vehicle ID
    public String getVehicleId() {
        return vehicleId;
    }

    // Get the driver name
    public String getDriverName() {
        return driverName;
    }

    // Get the rate per kilometer
    public double getRatePerKm() {
        return ratePerKm;
    }

    // Method to calculate fare
    public abstract double calculateFare(double distance);

    // Method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
}

// Car (Subclass)
class Car extends Vehicle {
    // Attributes for car
    private static final double BASE_FARE = 50.0;

    // Constructor for Car
    public Car(String vehicleId, String driverName, double ratePerKm) {
        // Call the abstract class constructor
        super(vehicleId, driverName, ratePerKm);
    }

    // Overriding calculateFare() method
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (getRatePerKm() * distance);
    }
}

// Bike (Subclass)
class Bike extends Vehicle {
    // Attributes for bike
    private static final double BASE_FARE = 20.0;

    // Constructor for Bike
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        // Call the abstract class constructor
        super(vehicleId, driverName, ratePerKm);
    }

    // Overriding calculateFare() method
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (getRatePerKm() * distance);
    }
}

// Auto (Subclass)
class Auto extends Vehicle {
    // Attributes for auto
    private static final double BASE_FARE = 30.0;

    // Constructor for Auto
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        // Call the abstract class constructor
        super(vehicleId, driverName, ratePerKm);
    }

    // Overriding calculateFare() method
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (getRatePerKm() * distance);
    }
}

// GPS (Interface)
interface GPS {
    // Get the current location
    String getCurrentLocation();

    // Method to update the location
    void updateLocation(String newLocation);
}

// AllVehicle class
class AllVehicle implements GPS {
    private Vehicle vehicle;
    private String currentLocation;

    // Constructor for Car
    public AllVehicle(Car car, String initialLocation) {
        this.vehicle = car;
        this.currentLocation = initialLocation;
    }

    // Constructor for Bike
    public AllVehicle(Bike bike, String initialLocation) {
        this.vehicle = bike;
        this.currentLocation = initialLocation;
    }

    // Constructor for Auto
    public AllVehicle(Auto auto, String initialLocation) {
        this.vehicle = auto;
        this.currentLocation = initialLocation;
    }

    // Overriding getCurrentLocation() method
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    // Overriding updateLocation() method
    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }

    // Method to display vehicle and driver details
    public void displayDetails() {
        vehicle.getVehicleDetails();
        System.out.println("Current Location: " + currentLocation);
    }

    // Method to calculate the fare
    public double calculateFare(double distance) {
        return vehicle.calculateFare(distance);
    }
}

// Main Class
class RideHailingApp {
    public static void main(String[] args) {
        // Create different types of vehicles
        Car car = new Car("CAR001", "John Doe", 15.0);
        Bike bike = new Bike("BIKE001", "Jane Smith", 8.0);
        Auto auto = new Auto("AUTO001", "Mike Johnson", 10.0);

        // Initialize AllVehicle objects with initial locations
        AllVehicle carRide = new AllVehicle(car, "Downtown");
        AllVehicle bikeRide = new AllVehicle(bike, "Suburb");
        AllVehicle autoRide = new AllVehicle(auto, "City Center");

        // Display vehicle and driver details
        System.out.println("Car Ride:");
        carRide.displayDetails();
        double carFare = carRide.calculateFare(10.0);
        System.out.println("Fare for 10 km: " + carFare);
        carRide.updateLocation("Airport");
        System.out.println("Updated Location: " + carRide.getCurrentLocation());
        System.out.println();

        System.out.println("Bike Ride:");
        bikeRide.displayDetails();
        double bikeFare = bikeRide.calculateFare(5.0);
        System.out.println("Fare for 5 km: " + bikeFare);
        bikeRide.updateLocation("Mall");
        System.out.println("Updated Location: " + bikeRide.getCurrentLocation());
        System.out.println();

        System.out.println("Auto Ride:");
        autoRide.displayDetails();
        double autoFare = autoRide.calculateFare(7.0);
        System.out.println("Fare for 7 km: " + autoFare);
        autoRide.updateLocation("Station");
        System.out.println("Updated Location: " + autoRide.getCurrentLocation());
    }
}

