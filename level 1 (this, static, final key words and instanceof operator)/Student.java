// Create Student class to check if the object is the instance of student
public class Student {
    // Static variable for the university name
    private static String universityName = "State University";

    // Static variable to track the total number of students
    private static int totalStudents = 0;

    // Final variable for the student's roll number
    private final int rollNumber;

    // Instance variables for the student's name and grade
    private String name;
    private String grade;

    // Parameterized constructor to initialize student details
    public Student(String name, int rollNumber, String grade) {
        this.name = name; 
        this.rollNumber = rollNumber; 
        this.grade = grade; 
        totalStudents++; 
    }

    // Static method to display the total number of students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to set the university name
    public static void setUniversityName(String name) {
        universityName = name;
    }

    // Method to display student details
    public void displayStudentDetails() {
        if (this instanceof Student) { // Check if the object is an instance of Student
            System.out.println("University Name: " + universityName);
            System.out.println("Student Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    // Method to update the student's grade
    public void updateGrade(String newGrade) {
        if (this instanceof Student) { // Check if the object is an instance of Student
            this.grade = newGrade; // Update the grade
            System.out.println("Grade updated successfully for " + name + " to " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public static void main(String[] args) {
        // Set a custom university name
        Student.setUniversityName("RGPV");

        // Create student objects
        Student student1 = new Student("Alice", 101, "A");
        Student student2 = new Student("Bob", 102, "B");

        // Display student details
        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();

        // Update and display student grades
        System.out.println();
        student1.updateGrade("A+");
        student2.updateGrade("A");

        // Display total number of students
        System.out.println();
        Student.displayTotalStudents();
    }
}

     