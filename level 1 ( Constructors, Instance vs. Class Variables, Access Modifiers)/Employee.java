// Base class
public class Employee {
    // Attributes
    public int employeeID;
    protected String department;
    private double salary;

    // Parameterized constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Method to modify salary
    public void modifySalary(double newSalary) {
        if (newSalary >= 0) {
            salary = newSalary;
            System.out.println("Salary updated to: Rs" + salary);
        } else {
            System.out.println("Invalid salary! Salary cannot be negative.");
        }
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs" + salary);
    }
}

// Subclass
class Manager extends Employee {
    private String managementArea;

    // Constructor
    public Manager(int employeeID, String department, double salary, String managementArea) {
        super(employeeID, department, salary);
        this.managementArea = managementArea;
    }

    // Method to display manager details
    public void displayManagerDetails() {
        // Accessing public and protected members from the parent class
        System.out.println("Employee ID: " + employeeID); // Public member
        System.out.println("Department: " + department); // Protected member
        System.out.println("Management Area: " + managementArea);
    }

    // Method to display salary (demonstrating private member access)
    public void displaySalary() {
        // Accessing salary through the modifySalary method
        System.out.println("Manager Salary: $" + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an Employee instance
        Employee employee = new Employee(101, "Sales", 50000.0);
        employee.displayEmployeeDetails();

        System.out.println("\nModifying Salary");
        employee.modifySalary(55000.0);
        employee.displayEmployeeDetails();

        System.out.println("\nCreating a Manager");
        Manager manager = new Manager(201, "HR", 75000.0, "Employee Relations");
        manager.displayManagerDetails();

        System.out.println("\nDisplaying Manager's Salary");
        manager.displaySalary();
    }
}
