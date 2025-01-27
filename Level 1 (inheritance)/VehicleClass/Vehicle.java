// Vehicle class (Superclass)
class Vehicle {
    // Attributes for Vehicle
    protected String model;
    protected int maxSpeed;

    // Constructor for Vehicle
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Refuelable (Interface)
interface Refuelable {
    // Abstract method to refuel the vehicle
    void refuel();
}

// ElectricVehicle class (Subclass)
class ElectricVehicle extends Vehicle {
    // Attribute for ElectricVehicle
    private int batteryCapacity;

    // Constructor for ElectricVehicle
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        // Call the superclass constructor
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    // Method to charge the electric vehicle
    public void charge() {
        System.out.println(model + " is charging with a battery capacity of " + batteryCapacity + " kWh.");
    }

    // Overriding displayInfo to include battery capacity
    @Override
    public void displayInfo() {
        // Display common details
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle class (Subclass)
class PetrolVehicle extends Vehicle implements Refuelable {
    // Attribute for PetrolVehicle
    private int fuelCapacity;

    // Constructor for PetrolVehicle
    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        // Call the superclass constructor
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    // Implementing the refuel() method from Refuelable interface
    @Override
    public void refuel() {
        System.out.println(model + " is refueling with a capacity of " + fuelCapacity + " liters.");
    }

    // Overriding displayInfo to include fuel capacity
    @Override
    public void displayInfo() {
        // Display common details
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Main Class
class VehicleManagementSystem {
    public static void main(String[] args) {
        // Create objects for ElectricVehicle and PetrolVehicle
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle toyota = new PetrolVehicle("Toyota Corolla", 180, 50);

        // Display details and unique behavior for ElectricVehicle
        tesla.displayInfo();
        tesla.charge();
        System.out.println();

        // Display details and unique behavior for PetrolVehicle
        toyota.displayInfo();
        toyota.refuel();
    }
}

