import java.util.ArrayList;
import java.util.List;

// Student class
class Student {
    // Attributes of student
    private String name;
    // Association: A student can enroll in multiple courses
    private List<Course> enrolledCourses; 

    // Constructor to initialize the student
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    // Get the name of the student
    public String getName() {
        return name;
    }

    // Get the list of enrolled courses 
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Add the enrolled courses
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        // Link student to the course 
        course.enrollStudent(this); 
    }
}

// Course class
class Course {
    // Attributes of course
    private String courseName;
    // Aggregation: A course can have a professor assigned to it
    private Professor professor; 
    // Association: Students enroll in courses
    private List<Student> enrolledStudents; 

    // Constructor to initialize the course
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Get the name of course
    public String getCourseName() {
        return courseName;
    }

    // Get the professor
    public Professor getProfessor() {
        return professor;
    }

    // Assign the professor
    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    // Enroll the student
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Get the list of the enrolled student
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Display the course details
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getName());
        } else {
            System.out.println("No professor assigned yet.");
        }
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(" - " + student.getName());
        }
    }
}

// Professor class
class Professor {
    // Attributes of professor 
    private String name;
    // Aggregation: A professor can teach multiple courses
    private List<Course> assignedCourses; 

    // Constructor to initialize the professor 
    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    // Get the professor name
    public String getName() {
        return name;
    }

    // Get the list of the assigned courses
    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    // Add the assigned course 
    public void assignCourse(Course course) {
        assignedCourses.add(course);
        // Link professor to the course
        course.assignProfessor(this); 
    }
}

class Main {
    public static void main(String[] args) {
        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create professors
        Professor drSmith = new Professor("Dr. Smith");
        Professor drJohnson = new Professor("Dr. John");

        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");

        // Assign professors to courses
        drSmith.assignCourse(math);
        drJohnson.assignCourse(physics);

        // Students enroll in courses
        alice.enrollCourse(math);
        alice.enrollCourse(physics);

        bob.enrollCourse(math);

        // Display course details
        System.out.println("University Course Details:\n");
        math.displayCourseDetails();
        System.out.println();
        physics.displayCourseDetails();
        System.out.println();

        // Display individual student details
        System.out.println("Student Details:");
        for (Course course : alice.getEnrolledCourses()) {
            System.out.println(alice.getName() + " is enrolled in: " + course.getCourseName());
        }
        System.out.println();
        for (Course course : bob.getEnrolledCourses()) {
            System.out.println(bob.getName() + " is enrolled in: " + course.getCourseName());
        }
    }
}
