// Course class (Base class)
class Course {
    // Attributes for course
    protected String courseName;
    protected int duration; 

    // Constructor for Course
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// OnlineCourse (Subclass)
class OnlineCourse extends Course {
    // Attributes for online courses
    protected String platform;
    protected boolean isRecorded;

    // Constructor for OnlineCourse
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        // Call the superclass constructor
        super(courseName, duration); 
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overriding displayDetails to include online course details
    @Override
    public void displayDetails() {
        // Display base course details
        super.displayDetails(); 
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// PaidOnlineCourse (Subclass)
class PaidOnlineCourse extends OnlineCourse {
    // Attributes for paid online courses
    private double fee;
    private double discount; 

    // Constructor for PaidOnlineCourse
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        // Call the superclass constructor
        super(courseName, duration, platform, isRecorded); 
        this.fee = fee;
        this.discount = discount;
    }

    // Method to calculate the final price after discount
    public double calculateFinalPrice() {
        return fee - (fee * discount / 100);
    }

    // Overriding displayDetails to include paid course details
    @Override
    public void displayDetails() {
        // Display online course details
        super.displayDetails(); 
        System.out.println("Fee: Rs" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: Rs" + calculateFinalPrice());
    }
}

// Main Class
class EducationalCourseSystem {
    public static void main(String[] args) {
        // Create objects for each class level
        Course basicCourse = new Course("Introduction to Programming", 20);
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 40, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Data Structures", 50, "Coursera", false, 100, 20);

        // Display details for each course
        System.out.println("Basic Course Details:");
        basicCourse.displayDetails();
        System.out.println();

        System.out.println("Online Course Details:");
        onlineCourse.displayDetails();
        System.out.println();

        System.out.println("Paid Online Course Details:");
        paidCourse.displayDetails();
    }
}

