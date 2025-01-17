// Create Circle to calculate and display the area and circumference of the circle
public class Circle {
    // Attribute of circle
    private double radius;
   // Constructor to initialize the circle radius
   public Circle(double radius){
       this.radius = radius;
   }
   // Method to calculate the area of the circle
   public double calculateArea() {
       return Math.PI * radius * radius;
   }
   // Method to calculate the circumference of the circle
   public double calculateCircumference() {
       return 2 * Math.PI * radius;
   } 
   // Method to display the area and circumference of the circle
   public void displayDetails() {
       System.out.println("Radius: " + radius);
       System.out.println("Area: " + calculateArea());
       System.out.println("Circumference: " + calculateCircumference());
   }
   public static void main(String[]args) {
       // Create a circle using the given radius 
       Circle circle1 = new Circle(5.0);
       // Display the details of the circle
       circle1.displayDetails();
   }
}  