// Create Product class to get total number of products
public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable
    private static int totalProducts = 0;

    // Parameterized constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        // Increment totalProducts whenever a new product is created
        totalProducts++; 
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs" + price);
    }

    // Method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Laptop", 12000.50);
        Product product2 = new Product("Smartphone", 999.99);

        // Display product details
        System.out.println("Product 1 Details:");
        product1.displayProductDetails();

        System.out.println("\nProduct 2 Details:");
        product2.displayProductDetails();

        // Display total products created
        System.out.println("\nTotal Products Created:");
        Product.displayTotalProducts();
    }
}
