// Person class (Superclass)
class Person {
    // Attributes for person
    protected String name;
    protected int age;

    // Constructor for Person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Method to display role
    public void displayRole() {
        System.out.println("Role: General Person");
    }
}

// Teacher class (Subclass)
class Teacher extends Person {
    // Attribute for Teacher
    private String subject;

    // Constructor for Teacher
    public Teacher(String name, int age, String subject) {
        // Call superclass constructor
        super(name, age); 
        this.subject = subject;
    }

    // Overriding displayRole
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    // Overriding displayDetails to include specific attributes
    @Override
    public void displayDetails() {
        // Display common details
        super.displayDetails(); 
        System.out.println("Subject: " + subject);
    }
}

// Student class (Subclass)
class Student extends Person {
    // Attribute for Student
    private String grade; 

    // Constructor for Student
    public Student(String name, int age, String grade) {
        // Call superclass constructor
        super(name, age); 
        this.grade = grade;
    }

    // Overriding displayRole
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    // Overriding displayDetails to include specific attributes
    @Override
    public void displayDetails() {
        // Display common details
        super.displayDetails(); 
        System.out.println("Grade: " + grade);
    }
}

// Staff class (Subclass)
class Staff extends Person {
    // Attribute for Staff
    private String department; 

    // Constructor for Staff
    public Staff(String name, int age, String department) {
        // Call superclass constructor
        super(name, age); 
        this.department = department;
    }

    // Overriding displayRole
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }

    // Overriding displayDetails to include specific attributes
    @Override
    public void displayDetails() {
        // Display common details
        super.displayDetails(); 
        System.out.println("Department: " + department);
    }
}

// Main Class
class SchoolSystem {
    public static void main(String[] args) {
        // Create objects for each role
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 15, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");

        // Using polymorphism to call overridden methods
        Person[] people = {teacher, student, staff};

        // Display details and role for each person
        for (Person person : people) {
            person.displayRole();
            person.displayDetails();
            System.out.println();
        }
    }
}

