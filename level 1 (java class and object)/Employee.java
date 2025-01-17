// Create Employee class to display the details of the employee
public class Employee {
    // Attributes of the class
    private String name;
    private int id;
    private double salary;
    // Constructor to initialize the employee details
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this. salary = salary;
    } 
    // Method to display the details 
    public void displayDetails() {
        System.out.println("Employee name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee salary: " + salary);
    }    
    public static void main(String[]args) {
        // Create an employee object
        Employee employee1 = new Employee ( "Parag Agrawal", 117, 25000);
        Employee employee2 = new Employee ( " Hrithik Maurya", 74, 25000);
        // Display the details 
        employee1.displayDetails(); 
        employee2.displayDetails(); 
    }
}    