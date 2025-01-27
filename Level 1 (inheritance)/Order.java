// Order class (Base class)
class Order {
    // Attributes for  order
    protected String orderId;
    protected String orderDate;

    // Constructor for Order
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to return order status
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    // Method to display order details
    public void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// ShippedOrder (Subclass)
class ShippedOrder extends Order {
    // Attribute for shipped order
    protected String trackingNumber;

    // Constructor for ShippedOrder
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        // Call the superclass constructor
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Overriding getOrderStatus to include shipping details
    @Override
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }

    // Overriding displayDetails to include shipping details
    @Override
    public void displayDetails() {
        // Display base order details
        super.displayDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// DeliveredOrder (Subclass)
class DeliveredOrder extends ShippedOrder {
    // Attribute for delivered order
    private String deliveryDate;

    // Constructor for DeliveredOrder
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        // Call the superclass constructor
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Overriding getOrderStatus to include delivery details
    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    // Overriding displayDetails to include delivery details
    @Override
    public void displayDetails() {
        // Display shipping details
        super.displayDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main Class
class OnlineRetailSystem {
    public static void main(String[] args) {
        // Create objects for each class level
        Order order = new Order("ORD123", "2025-01-20");
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", "2025-01-19", "TRACK5678");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", "2025-01-18", "TRACK1234", "2025-01-23");

        // Display details and status of each order
        System.out.println("Order Details:");
        order.displayDetails();
        System.out.println("Status: " + order.getOrderStatus());
        System.out.println();

        System.out.println("Shipped Order Details:");
        shippedOrder.displayDetails();
        System.out.println("Status: " + shippedOrder.getOrderStatus());
        System.out.println();

        System.out.println("Delivered Order Details:");
        deliveredOrder.displayDetails();
        System.out.println("Status: " + deliveredOrder.getOrderStatus());
    }
}

