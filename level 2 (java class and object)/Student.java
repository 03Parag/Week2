// Create Student class to calculate the grade based on the marks and display the student's details and grade
public class Student {
    // Attributes of the student class
    private String name;
    private int rollnumber;
    private double marks;
    // Constructor to initialize the name, rollnumber and marks
    public Student( String name, int rollnumber, double marks) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.marks =marks;
    }
    // Method to calculate the grade based on marks
    public char calculateGrade() {
        if ( marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    // Method to display the details of the student and grade
    public void displayDetails() {
        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollnumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grades: " + calculateGrade());
    }   
    public static void main(String[]args) {
        // Create a student object
        Student student1 = new Student("Parag Agrawal", 117, 90.2);
        // Display the details of student and grade
        student1.displayDetails();
    }
}    
          