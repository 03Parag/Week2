import java.util.ArrayList;
import java.util.List;

// University class
class University {
    // Attributes of university
    private String universityName;
    // Composition: University owns Departments 
    private List<Department> departments;  
    // Aggregation: Faculty can exist independently
    private List<Faculty> facultyMembers;  

    // Constructor to initialize university attributes
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    // Add a department to the university
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Add a faculty member to the university
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    // Get the university name
    public String getUniversityName() {
        return universityName;
    }

    // Get the list of departments
    public List<Department> getDepartments() {
        return departments;
    }

    // Get the list of faculty members
    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    // Delete the university (composition relationship: deleting university deletes departments)
    public void deleteUniversity() {
        // Deleting all departments 
        // Faculty members are not deleted because they are aggregated, not composed
        departments.clear();  
    }
}

// Faculty class
class Faculty {
    // Attributes of Faculty 
    private String name;

    // Constructor to initialize faculty attributes
    public Faculty(String name) {
        this.name = name;
    }

    // Get the faculty name
    public String getName() {
        return name;
    }
}

// Department class (part of University, composition relationship)
class Department {
    // Attributes of department
    private String departmentName;

    // Constructor to initialize department attributes
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // Get the department name
    public String getDepartmentName() {
        return departmentName;
    }
}

class Main {
    public static void main(String[] args) {
        // Create a university
        University university = new University("RGPV University");

        // Create departments
        Department csDepartment = new Department("Computer Science");
        Department eeDepartment = new Department("Electrical Engineering");

        // Create faculty members
        Faculty faculty1 = new Faculty("Dr. Alice");
        Faculty faculty2 = new Faculty("Dr. Bob");

        // Add departments to the university
        university.addDepartment(csDepartment);
        university.addDepartment(eeDepartment);

        // Add faculty members to the university
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Display university details before deletion
        System.out.println("University: " + university.getUniversityName());
        System.out.println("Departments:");
        for (Department dept : university.getDepartments()) {
            System.out.println("  - " + dept.getDepartmentName());
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : university.getFacultyMembers()) {
            System.out.println("  - " + faculty.getName());
        }

        // Delete the university
        university.deleteUniversity();

        // Display university details after deletion
        System.out.println("\nAfter deleting the university:");
        System.out.println("Departments:");
        for (Department dept : university.getDepartments()) {
            System.out.println("  - " + dept.getDepartmentName());
        }
        System.out.println("Faculty Members (still exist):");
        for (Faculty faculty : university.getFacultyMembers()) {
            System.out.println("  - " + faculty.getName());
        }
    }
}
