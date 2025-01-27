import java.util.ArrayList;
import java.util.List;

// Company class
class Company {
    // Attributes of company
    private String companyName;
    private List<Department> departments;
    
    // Constructor to initialize the company attributes
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
 
    // Add a new department
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Get the company name
    public String getCompanyName() {
        return companyName;
    }

    // Get the list of department
    public List<Department> getDepartments() {
        return departments;
    }

    // Deleting the company deletes all departments and employees
    public void deleteCompany() {
        for (Department department : departments) {
            // Deleting departments and their employees
            department.deleteDepartment();  
        }
        // Deleting all departments 
        departments.clear(); 
    }
    
    // Department class within Company
    static class Department {
        // Attributes of department
        private String departmentName;
        private List<Employee> employees;

        // Constructor to initialize the department attributes
        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.employees = new ArrayList<>();
        }

        // Add an employee
        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        // Get the department name
        public String getDepartmentName() {
            return departmentName;
        }

        // Get the list of employee
        public List<Employee> getEmployees() {
            return employees;
        }

        // Deleting the department deletes all employees
        public void deleteDepartment() {
            // Deleting employees when the department is deleted
            employees.clear();  
        }
        
        // Employee class inside Department
        static class Employee {
            // Attributes of employee
            private String name;

            // Constructor to initialize the employee attributes            
            public Employee(String name) {
                this.name = name;
            }

            // Get the name 
            public String getName() {
                return name;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Creating company 
        Company company = new Company("Capgemini");

        // Creating departments
        Company.Department devDepartment = new Company.Department("Development");
        Company.Department hrDepartment = new Company.Department("HR");

        // Creating employees
        Company.Department.Employee emp1 = new Company.Department.Employee("Alex");
        Company.Department.Employee emp2 = new Company.Department.Employee("Bob");
        Company.Department.Employee emp3 = new Company.Department.Employee("Charlie");

        // Adding employees to departments
        devDepartment.addEmployee(emp1);
        devDepartment.addEmployee(emp2);
        hrDepartment.addEmployee(emp3);

        // Adding departments to company
        company.addDepartment(devDepartment);
        company.addDepartment(hrDepartment);

        // Showing company details before deletion
        System.out.println("Company: " + company.getCompanyName());
        for (Company.Department dept : company.getDepartments()) {
            System.out.println("Department: " + dept.getDepartmentName());
            for (Company.Department.Employee emp : dept.getEmployees()) {
                System.out.println("Employee: " + emp.getName());
            }
        }

        // Deleting the company
        company.deleteCompany();

        // Showing company details after deletion
        System.out.println("\nAfter company deletion:");
        System.out.println("Company: " + company.getCompanyName());
        for (Company.Department dept : company.getDepartments()) {
            System.out.println("Department: " + dept.getDepartmentName());
            for (Company.Department.Employee emp : dept.getEmployees()) {
                System.out.println("Employee: " + emp.getName());
            }
        }
    }
}
