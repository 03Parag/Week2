// Create Item class to display item details and calculate the total cost for a given quantity
public class Item {
    // Attributes of the Item class
    private String itemCode;
    private String itemName;
    private double price;
    // Constructor to initialize Item code, Item name and price
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    // Method to display the item code, item name and price
    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }
    // Method to calculate the total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    public static void main(String[] args) {
        // Create an Item  using the given details
        Item item1 = new Item("I101", "Wireless Mouse", 25.99);
        // Display the item details
        item1.displayDetails();
        // Calculate and display the total cost for a given quantity
        int quantity = 3;
        double totalCost = item1.calculateTotalCost(quantity);
        System.out.println("Total Cost for " + quantity + " items: " + totalCost);
    }
}
