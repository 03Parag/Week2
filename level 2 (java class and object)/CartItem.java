// Create CartItem class to add and remove an item and display the total cost
public class CartItem {
    // Attributes of the cart item
    private String itemName;
    private double price;
    private int quantity;
    // Constructor to initialize the item name , price and quantity
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    // Using getters(A getter is a method used to retrieve the value of a private attribute)
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    // Using setters(A setter is a method used to update or set the value of a private attribute)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // Method to calculate the cost of an item
    public double calculateCost() {
        return price * quantity;
    }
    // ShoppingCart class to manage a fixed number of items
    public static class ShoppingCart {
        // Array to store cart items
        private CartItem[] cartItems; 
        // Tracks the number of items in the cart
        private int itemCount;        
        // Constructor to initialize the cart with a fixed size
        public ShoppingCart(int capacity) {
            cartItems = new CartItem[capacity];
            itemCount = 0;
        }
        // Method to add an item to the cart
        public void addItem(String itemName, double price, int quantity) {
            // Check if the item already exists in the cart
            for (int i = 0; i < itemCount; i++) {
                if (cartItems[i].getItemName().equalsIgnoreCase(itemName)) {
                    // Update quantity if the item already exists
                    cartItems[i].setQuantity(cartItems[i].getQuantity() + quantity);
                    System.out.println(itemName + " quantity updated to " + cartItems[i].getQuantity());
                    return;
                }
            }
            // Add a new item if it doesn't exist
            if (itemCount < cartItems.length) {
                cartItems[itemCount] = new CartItem(itemName, price, quantity);
                itemCount++;
                System.out.println(itemName + " added to the cart.");
            } else {
                System.out.println("Cart is full! Cannot add more items.");
            }
        }
        // Method to remove an item from the cart
        public void removeItem(String itemName) {
            boolean found = false;
            for (int i = 0; i < itemCount; i++) {
                if (cartItems[i].getItemName().equalsIgnoreCase(itemName)) {
                    found = true;
                    // Shift items to the left to fill the gap
                    for (int j = i; j < itemCount - 1; j++) {
                        cartItems[j] = cartItems[j + 1];
                    }
                    // Remove the last duplicate
                    cartItems[itemCount - 1] = null; 
                    itemCount--;
                    System.out.println(itemName + " removed from the cart.");
                    break;
                }
            }
            if (!found) {
                System.out.println(itemName + " not found in the cart.");
            }
        }
        // Method to display the total cost of items in the cart
        public void displayTotalCost() {
            double totalCost = 0.0;
            for (int i = 0; i < itemCount; i++) {
                totalCost += cartItems[i].calculateCost();
            }
            System.out.println("Total Cost: $" + totalCost);
        }
        // Method to display all items in the cart
        public void displayCartItems() {
            if (itemCount == 0) {
                System.out.println("The cart is empty.");
                return;
            }
            System.out.println("Cart Items:");
            for (int i = 0; i < itemCount; i++) {
                CartItem item = cartItems[i];
                System.out.println("Name: " + item.getItemName() + "\nPrice: " + item.getPrice() + "\nQuantity: " + item.getQuantity() + "\nCost: " + item.calculateCost());
            }
        }
    }
    public static void main(String[] args) {
        // Create a ShoppingCart object with a capacity of 5 items
        ShoppingCart cart = new ShoppingCart(5);
        // Add items to the cart
        cart.addItem("Laptop", 1000.0, 1);
        cart.addItem("Mouse", 25.0, 2);
        cart.addItem("Keyboard", 50.0, 1);
        // Display cart items
        System.out.println("\nCart Details:");
        cart.displayCartItems();
        // Display total cost
        cart.displayTotalCost();
        // Add more of an existing item
        System.out.println("\nAdding more of an existing item:");
        cart.addItem("Mouse", 25.0, 1);
        // Display cart items again
        cart.displayCartItems();
        cart.displayTotalCost();
        // Remove an item from the cart
        System.out.println("\nRemoving an item:");
        cart.removeItem("Keyboard");
        // Display cart items after removal
        cart.displayCartItems();
        cart.displayTotalCost();
        // Try adding more items than the cart can hold
        System.out.println("\nAdding more items:");
        cart.addItem("Monitor", 200.0, 1);
        cart.addItem("Headphones", 75.0, 1);
        // This should fail because the cart is full
        cart.addItem("Speakers", 100.0, 1); 
    }
}
