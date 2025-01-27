import java.util.ArrayList;
import java.util.List;

// Customer class
class Customer {
    // Attributes of customer
    private String customerName;
    // A customer can place multiple orders
    private List<Order> orders; 

    // Constructor to initialize the customer 
    public Customer(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    // Get the customer name
    public String getCustomerName() {
        return customerName;
    }

    // Get the list of orders
    public List<Order> getOrders() {
        return orders;
    }

    // Place the order
    public void placeOrder(Order order) {
        orders.add(order);
    }
}

// Product class
class Product {
    // Attributes of product
    private String productName;
    private double price;

    // Constructor to initialize the product
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    // Get the product name 
    public String getProductName() {
        return productName;
    }

    // Get the pricr of the product
    public double getPrice() {
        return price;
    }
}

// Order class
class Order {
    // Attributes of order
    // Unique order ID generator
    private static int orderCounter = 0; 
    private int orderId;
    private Customer customer;
    private List<Product> products;

    // Constructor to initialize the order
    public Order(Customer customer) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Get the order ID
    public int getOrderId() {
        return orderId;
    }

    // Get the customer  
    public Customer getCustomer() {
        return customer;
    }

    // Get the list of the products
    public List<Product> getProducts() {
        return products;
    }

    // Add the product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate the total price 
    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Display the order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " Price: Rs" + product.getPrice());
        }
        System.out.println("Total Price: Rs" + calculateTotalPrice());
    }
}
class Main {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 1200.50);
        Product smartphone = new Product("Smartphone", 799.99);
        Product headphones = new Product("Headphones", 149.99);

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Create orders for alice
        Order aliceOrder1 = new Order(alice);
        aliceOrder1.addProduct(laptop);
        aliceOrder1.addProduct(headphones);

        Order aliceOrder2 = new Order(alice);
        aliceOrder2.addProduct(smartphone);

        // Place the order for alice
        alice.placeOrder(aliceOrder1);
        alice.placeOrder(aliceOrder2);

        // Create an order for bob
        Order bobOrder = new Order(bob);
        bobOrder.addProduct(smartphone);
        bobOrder.addProduct(headphones);

        // Place the order for bob
        bob.placeOrder(bobOrder);

        // Display order details
        System.out.println("E-Commerce Platform Orders:\n");

        for (Order order : alice.getOrders()) {
            order.displayOrderDetails();
            System.out.println();
        }

        for (Order order : bob.getOrders()) {
            order.displayOrderDetails();
            System.out.println();
        }
    }
}
