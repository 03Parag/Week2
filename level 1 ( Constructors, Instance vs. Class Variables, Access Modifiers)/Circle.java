// Create Circle class to initialize with default and user-provided values
public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        radius = 1.0; 
    }

    // Parameterized constructor,
    public Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        // Creating a circle with the default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle Radius: " + defaultCircle.radius);

        // Creating a circle with the parameterized condtructor
        Circle parameterCircle = new Circle(5.0);
        System.out.println("Parameter Circle Radius: " + parameterCircle.radius);
    }
}
