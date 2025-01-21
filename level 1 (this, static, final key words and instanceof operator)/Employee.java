// Create Employee class to check if the object is the instance of employee class
public class Employee {
    // Static variable for the company name
    private static String companyName = "Company";

    // Static variable to track the total number of employees
    private static int totalEmployees = 0;

    // Final variable for the employee ID
    private final int id;

    // Instance variables for the employee's name and designation
    private String name;
    private String designation;

    // Parameterized constructor to initialize employee details
    public Employee(String name, int id, String designation) {
        this.name = name; 
        this.id = id; 
        this.designation = designation; 
        totalEmployees++; // Increment the total employee count
    }

    // Method to display the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to set the company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        if (this instanceof Employee) { // Check if the object is an instance of Employee
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        // Set a company name
        Employee.setCompanyName("Capgemini");

        // Create employee objects
        Employee emp1 = new Employee("Alice", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob", 102, "Data Scientist");

        // Display employee details
        emp1.displayEmployeeDetails();
        System.out.println();
        emp2.displayEmployeeDetails();

        // Display total number of employees
        System.out.println();
        Employee.displayTotalEmployees();
    }
}
