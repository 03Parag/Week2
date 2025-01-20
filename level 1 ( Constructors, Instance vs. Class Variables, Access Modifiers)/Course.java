// Create Course class to modify institute name 
public class Course {
    // Instance variables
    private String courseName;
    // Duration in months
    private int duration; 
    private double fee;

    // Class variable
    private static String instituteName = "Technocrats Institute of Technology";

    // Parameterized constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: Rs" + fee);
    }

    // Class method to modify the institute name
    public static void modifyInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Institute name modified to: " + instituteName);
    }

    public static void main(String[] args) {
        // Create course instances
        Course course1 = new Course("Java Programming", 6, 500.0);
        Course course2 = new Course("Data Science", 12, 1200.0);

        // Display course details
        System.out.println("Course 1 Details:");
        course1.displayCourseDetails();

        System.out.println("\nCourse 2 Details:");
        course2.displayCourseDetails();

        // Modify institute name
        Course.modifyInstituteName("Technocrats Group of Institute");

        // Display course details again to show modified institute name
        System.out.println("\nCourse 1 Details (After Update):");
        course1.displayCourseDetails();

        System.out.println("\nCourse 2 Details (After Update):");
        course2.displayCourseDetails();
    }
}
