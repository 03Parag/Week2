// Vehicle class (Superclass)
class Vehicle {
    // Attributes of vehicle
    protected int maxSpeed;
    protected String fuelType;

    // Constructor for vehicle
    public Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle info
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + "Kmph");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car class (Subclass)
class Car extends Vehicle {
    // Attributes for car
    private int seatCapacity;

    // Constructor for car
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        // Call superclass constructor
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // Overriding display info to include seatCapacity
    @Override
    public void displayInfo() {
        // Call superclass method
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck class (Subclass)
class Truck extends Vehicle {
    // Attributes for truck
    private double loadCapacity;

    // Constructor for truck
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        // Call superclass constructor
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Overriding display info to include loadCapacity
    @Override
    public void displayInfo() {
        // Call superclass method
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}

// Motorcycle class (Subclass)
class Motorcycle extends Vehicle {
    // Attributes for motorcycle
    private double fuelCapacity;

    // Constructor for motorcycle
    public Motorcycle(int maxSpeed, String fuelType, double fuelCapacity) {
        // Call superclass constructor
        super(maxSpeed, fuelType);
        this.fuelCapacity = fuelCapacity;
    }

    // Overriding display info to include fuelCapacity
    @Override
    public void displayInfo() {
        // Call superclass method
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + "L");
    }
}

// Main class
class VehicleTransportSystem {
    public static void main(String[] args) {
        // Create instances for each subclass
        Vehicle car = new Car(100, "Petrol", 7);
        Vehicle truck = new Truck(50,"Diesel", 5.7);
        Vehicle motorcycle = new Motorcycle(75, "Petrol", 25);

        // Using polymorphism to call overridden methods
        Vehicle[]vehicles = {car, truck,motorcycle};
        for(Vehicle vehicle : vehicles){
            vehicle.displayInfo();
            System.out.println();
        }
    }
}