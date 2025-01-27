// Vehicle (Abstract Class)
abstract class Vehicle {
    // Attributes for vehicle
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor for vehicle
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Get the vehicle number
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    // Set the vehicle number
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    // Get the type
    public String getType() {
        return type;
    }

    // Set the type
    public void setType(String type) {
        this.type = type;
    }

    // Get the rental rate
    public double getRentalRate() {
        return rentalRate;
    }

    // Set the rental rate
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

// Car (Subclass)
class Car extends Vehicle {
    // Attributes of car
    private static final double INSURANCE_RATE = 0.05;

    // Constructor for car
    public Car(String vehicleNumber, double rentalRate) {
        // Call the abstract class constructor
        super(vehicleNumber, "Car", rentalRate);
    }

    // Overriding calculateRentalCost() method
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Method to calculate insurance
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
}

// Bike (Subclass)
class Bike extends Vehicle {
    // Attributes for bike
    private static final double INSURANCE_RATE = 0.02;

    // Constructor for bike
    public Bike(String vehicleNumber, double rentalRate) {
        // Call the abstract class constructor
        super(vehicleNumber, "Bike", rentalRate);
    }

    // Overriding calculateRentalCost() method
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Method to calculate insurance
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
}

// Truck (Subclass)
class Truck extends Vehicle {
    // Attributes for truck
    private static final double INSURANCE_RATE = 0.1;

    // Constructor for truck
    public Truck(String vehicleNumber, double rentalRate) {
        // Call the abstract class constructor
        super(vehicleNumber, "Truck", rentalRate);
    }

    // Overriding calculateRentalCost() method
    @Override
    public double calculateRentalCost(int days) {
        // Additional fixed cost
        return getRentalRate() * days + 50;
    }

    // Method to calculate insurance
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
}

// Insurable (Interface)
interface Insurable {
    // Method to calculate insurance
    double calculateInsurance();

    // Get the insurance detials
    String getInsuranceDetails();
}

// AllVehicle class implementing Insurable and extending Vehicle
class AllVehicle extends Vehicle implements Insurable {
    // Attributes for all vehicle
    private Car car;
    private Bike bike;
    private Truck truck;

    // Constructor for Car
    public AllVehicle(Car car) {
        // Call the abstract class constructor
        super(car.getVehicleNumber(), car.getType(), car.getRentalRate());
        this.car = car;
    }

    // Constructor for Bike
    public AllVehicle(Bike bike) {
        // Call the abstract class constructor
        super(bike.getVehicleNumber(), bike.getType(), bike.getRentalRate());
        this.bike = bike;
    }

    // Constructor for Truck
    public AllVehicle(Truck truck) {
        // Call the abstract class constructor
        super(truck.getVehicleNumber(), truck.getType(), truck.getRentalRate());
        this.truck = truck;
    }

    // Overriding calculateInsurance() method
    @Override
    public double calculateInsurance() {
        if (car != null) {
            return car.calculateInsurance();
        } else if (bike != null) {
            return bike.calculateInsurance();
        } else if (truck != null) {
            return truck.calculateInsurance();
        }
        return 0.0;
    }

    // Overriding getInsuranceDetails() method
    @Override
    public String getInsuranceDetails() {
        if (car != null) {
            return "Insurance Rate: 5% for Cars";
        } else if (bike != null) {
            return "Insurance Rate: 2% for Bikes";
        } else if (truck != null) {
            return "Insurance Rate: 10% for Trucks";
        }
        return "No insurance details available";
    }

    // Overriding calculateRentalCost() method
    @Override
    public double calculateRentalCost(int days) {
        if (car != null) {
            return car.calculateRentalCost(days);
        } else if (bike != null) {
            return bike.calculateRentalCost(days);
        } else if (truck != null) {
            return truck.calculateRentalCost(days);
        }
        return 0.0;
    }

    // Display vehicle details
    @Override
    public void displayDetails() {
        if (car != null) {
            car.displayDetails();
        } else if (bike != null) {
            bike.displayDetails();
        } else if (truck != null) {
            truck.displayDetails();
        }
    }
}

// Main Class
class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create Car, Bike, and Truck objects
        Car car = new Car("C123", 50);
        Bike bike = new Bike("B456", 20);
        Truck truck = new Truck("T789", 100);

        // Create AllVehicle objects for each vehicle
        AllVehicle allCar = new AllVehicle(car);
        AllVehicle allBike = new AllVehicle(bike);
        AllVehicle allTruck = new AllVehicle(truck);

        // Process a list of vehicles
        Vehicle[] vehicles = { allCar, allBike, allTruck };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            int days = 5; // Example rental period
            System.out.println("Rental Cost for " + days + " days: " + vehicle.calculateRentalCost(days));
            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println(insurable.getInsuranceDetails());
                System.out.println("Insurance Cost: " + insurable.calculateInsurance());
            }
            System.out.println();
        }
    }
}

