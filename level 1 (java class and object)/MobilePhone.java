// Create MobilePhone class to display the mobile phone details
public class MobilePhone {
    // Attributes of the mobile phone 
    private String brand;
    private String model;
    private double price;
    // Constructor to initialize the mobile phone brand, model and price
    public MobilePhone (String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    // Method to display brand, model and price of the mobile phone
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        // Create a MobilePhone object 
        MobilePhone phone1 = new MobilePhone("Apple", "iPhone 14", 999.99);
        // Display the details 
        phone1.displayDetails();
    }
}    