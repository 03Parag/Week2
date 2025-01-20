// Create Person class to copy the attributes of another person using copy constructor
public class Person {
    // Attributes
    private String name;
    private int age;
    private String phoneNumber;
    private String email;

    // Parameterized constructor
    public Person(String name, int age, String phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Copy constructor
    public Person(Person another) {
        this.name = another.name;
        this.age = another.age;
        this.phoneNumber = another.phoneNumber;
        this.email = another.email;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        // Creating a person with parameterized constructor
        Person person1 = new Person("Alice", 30, "555-1234", "alice@example.com");
        person1.displayInfo();

        // Creating a copy of person1 using the copy constructor
        Person person2 = new Person(person1);
        person2.displayInfo();
    }
}
