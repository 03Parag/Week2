// Employee class (Base Class)
class Employee {
    // Attributes of employees
    protected String name;
    protected int id;
    protected double salary;

    // Constructor for Employee
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: Rs" + salary);
    }
}

// Manager class (Subclass)
class Manager extends Employee {
    // Attribute for Manager
    private int teamSize;

    // Constructor for Manager
    public Manager(String name, int id, double salary, int teamSize) {
        // Call the superclass constructor
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    // Overriding displayDetails method to include teamSize
    @Override
    public void displayDetails() {
        // Call superclass method
        super.displayDetails(); 
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer class (Subclass)
class Developer extends Employee {
    // Attribute for Developer
    private String programmingLanguage;

    // Constructor for Developer
    public Developer(String name, int id, double salary, String programmingLanguage) {
        // Call the superclass constructor
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding displayDetails method to include programmingLanguage
    @Override
    public void displayDetails() {
        // Call superclass method
        super.displayDetails(); 
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern class (Subclass)
class Intern extends Employee {
    // Attribute for Intern
    private String universityName;

    // Constructor for Intern
    public Intern(String name, int id, double salary, String universityName) {
        // Call the superclass constructor
        super(name, id, salary);
        this.universityName = universityName;
    }

    // Overriding displayDetails method to include universityName
    @Override
    public void displayDetails() {
        // Call superclass method
        super.displayDetails(); 
        System.out.println("University: " + universityName);
    }
}

// Main Class
class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating instances for each subclass
        Manager manager = new Manager("Alice", 101, 9000, 10);
        Developer developer = new Developer("Bob", 102, 800, "Java");
        Intern intern = new Intern("Charlie", 103, 20, "TIT");

        // Using polymorphism to call overridden methods
        Employee[] employees = {manager, developer, intern};
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println();
        }
    }
}


