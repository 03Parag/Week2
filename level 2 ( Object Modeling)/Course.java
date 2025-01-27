import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    // Attributes of course
    private String courseName;
    private List<Student> enrolledStudents;

    // Constructor to initialize course attributes
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Get the course name
    public String getCourseName() {
        return courseName;
    }

    // Enroll the students
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }

    // Get the list of enrolled students
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

// Student class
class Student {
    // Attributes of student 
    private String studentName;
    private List<Course> courses;

    // Constructor to initialize student attributes 
    public Student(String studentName) {
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    // Get the student name
    public String getStudentName() {
        return studentName;
    }

    // Add the course
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);  
        }
    }

    // Get the list of courses
    public List<Course> getCourses() {
        return courses;
    }
}

// School class
class School {
    // Attributes of school
    private String schoolName;
    private List<Student> students;

    // Constructor to initialize school attributes
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Get the school name
    public String getSchoolName() {
        return schoolName;
    }

    // Add the student
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Get the list of students
    public List<Student> getStudents() {
        return students;
    }
}

class Main {
    public static void main(String[] args) {
        // Create a school
        School school = new School("St. Xavier's School");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create courses
        Course course1 = new Course("Math");
        Course course2 = new Course("Science");

        // Add students to the school
        school.addStudent(student1);
        school.addStudent(student2);

        // Enroll students in courses
        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course1);

        // Display students and their courses
        System.out.println("School: " + school.getSchoolName());
        for (Student student : school.getStudents()) {
            System.out.println("Student: " + student.getStudentName());
            System.out.println("Enrolled in:");
            for (Course course : student.getCourses()) {
                System.out.println("  - " + course.getCourseName());
            }
        }

        // Display courses and their enrolled students
        System.out.println("\nCourses and their enrolled students:");
        for (Course course : List.of(course1, course2)) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Enrolled Students:");
            for (Student student : course.getEnrolledStudents()) {
                System.out.println("  - " + student.getStudentName());
            }
        }
    }
}
