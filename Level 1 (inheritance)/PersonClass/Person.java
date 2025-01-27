// Person class (Superclass)
class Person {
    // Attributes for person
    protected String name;
    protected int id;

    // Constructor for Person
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display personal details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Worker (Interface)
interface Worker {
    // Abstract method to perform duties
    void performDuties();
}

// Chef class (Subclass)
class Chef extends Person implements Worker {
    // Attribute for Chef
    private String specialty;

    // Constructor for Chef
    public Chef(String name, int id, String specialty) {
        // Call the superclass constructor
        super(name, id);
        this.specialty = specialty;
    }

    // Overriding performDuties() from Worker interface
    @Override
    public void performDuties() {
        System.out.println(name + " is preparing dishes in the specialty: " + specialty);
    }

    // Overriding displayDetails to include specialty
    @Override
    public void displayDetails() {
        // Display common details
        super.displayDetails();
        System.out.println("Specialty: " + specialty);
    }
}

// Waiter class (Subclass)
class Waiter extends Person implements Worker {
    // Attribute for Waiter
    private int tableCount;

    // Constructor for Waiter
    public Waiter(String name, int id, int tableCount) {
        // Call the superclass constructor
        super(name, id);
        this.tableCount = tableCount;
    }

    // Overriding performDuties() from Worker interface
    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tableCount + " tables.");
    }

    // Overriding displayDetails to include table count
    @Override
    public void displayDetails() {
        // Display common details
        super.displayDetails();
        System.out.println("Number of Tables Assigned: " + tableCount);
    }
}

// Main class
class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Create objects for Chef and Waiter
        Chef chef = new Chef("Alice", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Bob", 202, 5);

        // Using polymorphism to manage workers
        Worker[] workers = {chef, waiter};

        // Display details and duties for each worker
        for (Worker worker : workers) {
            if (worker instanceof Person) {
                // Cast to Person to access displayDetails()
                ((Person) worker).displayDetails();
            }
            // Call performDuties() from Worker interface
            worker.performDuties();
            System.out.println();
        }
    }
}

