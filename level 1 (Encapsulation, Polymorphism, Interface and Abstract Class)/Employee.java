// Employee (Abstract Class)
abstract class Employee {
    // Attributes for employee
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor for employee
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Get the employee id
    public int getEmployeeId() {
        return employeeId;
    }

    // Set the employee id
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Get the employee name
    public String getName() {
        return name;
    }

    // Set the employee name
    public void setName(String name) {
        this.name = name;
    }

    // Get the base salary for employee
    public double getBaseSalary() {
        return baseSalary;
    }

    // Set the base salary for employee
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Display the details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

// FullTimeEmployee (Subclass)
class FullTimeEmployee extends Employee {
    // Attributes for fullTimeEmployee
    private double bonus;

    // Constructor for fullTimeEmployee
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        // Call the abstract class constructor
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    // Get the bonus
    public double getBonus() {
        return bonus;
    }

    // set the bonus
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Overriding calculateSalary() method to add bonus
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// PartTimeEmployee (Subclass)
class PartTimeEmployee extends Employee {
    // Attributes for partTimeEmployee
    private int hoursWorked;
    private double hourlyRate;

    // Constructor for partTimeEmployee
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        // Call the abstract class constructor
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Get the number of hours worked
    public int getHoursWorked() {
        return hoursWorked;
    }

    // Set the number of hours worked
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Get the hourly rate
    public double getHourlyRate() {
        return hourlyRate;
    }

    // Set the hourly rate
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Overriding calculateSalary() method to add hours worked and hourly rate
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

// Department (Interface)
interface Department {
    // Assign the department
    void assignDepartment(String departmentName);

    // Get the department details
    String getDepartmentDetails();
}

// AllEmployee Class implementing Department, and extending FullTimeEmployee and PartTimeEmployee
class AllEmployee extends Employee implements Department {
    // Attributes for all employee
    private String departmentName;
    private FullTimeEmployee fullTimeEmployee;
    private PartTimeEmployee partTimeEmployee;

    // Constructor for all employee of
    public AllEmployee(FullTimeEmployee fullTimeEmployee) {
        // Call the abstract class  constructor
        super(fullTimeEmployee.getEmployeeId(), fullTimeEmployee.getName(), fullTimeEmployee.getBaseSalary());
        this.fullTimeEmployee = fullTimeEmployee;
    }

    // Constructor for all employee
    public AllEmployee(PartTimeEmployee partTimeEmployee) {
        // Call the abstract class  constructor
        super(partTimeEmployee.getEmployeeId(), partTimeEmployee.getName(), partTimeEmployee.getBaseSalary());
        this.partTimeEmployee = partTimeEmployee;
    }

    // Overriding assign department for all employee
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    // Overriding department details
    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }

    // Overriding calculateSalary() method for all employee
    @Override
    public double calculateSalary() {
        if (fullTimeEmployee != null) {
            return fullTimeEmployee.calculateSalary();
        } else if (partTimeEmployee != null) {
            return partTimeEmployee.calculateSalary();
        }
        return 0.0;
    }

    // Display the details
    public void displayDetails() {
        // Call the display details method
        super.displayDetails();
        if (fullTimeEmployee != null) {
            System.out.println("Bonus: " + fullTimeEmployee.getBonus());
        } else if (partTimeEmployee != null) {
            System.out.println("Hours Worked: " + partTimeEmployee.getHoursWorked());
            System.out.println("Hourly Rate: " + partTimeEmployee.getHourlyRate());
        }
    }
}

// Main Class
class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create FullTimeEmployee and PartTimeEmployee objects
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee(1, "Alice", 50000, 10000);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee(2, "Bob", 20000, 50, 200);

        // Create CombinedEmployee objects for both FullTime and PartTime employees
        AllEmployee combinedFullTimeEmp = new AllEmployee(fullTimeEmp);
        AllEmployee combinedPartTimeEmp = new AllEmployee(partTimeEmp);

        // Assign departments
        combinedFullTimeEmp.assignDepartment("HR");
        combinedPartTimeEmp.assignDepartment("IT");

        // Process a list of employees (both full-time and part-time)
        Employee[] employees = { combinedFullTimeEmp, combinedPartTimeEmp };

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Total Salary: " + emp.calculateSalary());
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}

