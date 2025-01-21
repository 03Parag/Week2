// Create Product class to check if the object is the instance of product
public class Product {
    // Static variable for discount that is shared by all products
    private static double discount = 0.0;

    // Final variable for the product ID
    private final int productID;

    // Instance variables for product details
    private String productName;
    private double price;
    private int quantity;

    // Parameterized constructor to initialize product details
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID; 
        this.productName = productName; 
        this.price = price; 
        this.quantity = quantity; 
    }

    // Method to update the discount percentage
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display product details
    public void displayProductDetails() {
        if (this instanceof Product) { // Validate if the object is an instance of Product
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: Rs" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price After Discount: Rs" + calculateDiscountedPrice());
        } else {
            System.out.println("Invalid product object.");
        }
    }

    // Method to calculate the price after applying the discount
    private double calculateDiscountedPrice() {
        return price - (price * discount / 100);
    }

    public static void main(String[] args) {
        // Update the discount percentage
        Product.updateDiscount(10.0);

        // Create product objects
        Product product1 = new Product(101, "Laptop", 10000.00, 2);
        Product product2 = new Product(102, "Smartphone", 8000.00, 3);

        // Display product details
        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
    }
}
