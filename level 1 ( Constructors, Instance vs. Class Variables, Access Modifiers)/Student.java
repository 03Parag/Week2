// Base class
public class Student {
    // Attributes
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Parameterized constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Method to modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA! It should be between 0.0 and 10.0.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass
class PostgraduateStudent extends Student {
    private String specialization;

    // Parameterized constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method to display postgraduate student details
    public void displayPostgraduateDetails() {
        // Accessing protected member 'name' from the parent class
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name); // Accessing protected member
        System.out.println("Specialization: " + specialization);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Student instance
        Student student = new Student(101, "Alice", 9.5);
        student.displayStudentDetails();

        System.out.println("\nUpdating CGPA...");
        student.setCGPA(8.8);
        student.displayStudentDetails();

        System.out.println("\nCreating a Postgraduate Student ");
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Joe", 8.2, "Artificial Intelligence and Machine Learning");
        pgStudent.displayPostgraduateDetails();

        System.out.println("\nUpdating Postgraduate Student CGPA...");
        pgStudent.setCGPA(9.0); // Accessing public method from the parent class
        pgStudent.displayStudentDetails();
    }
}
