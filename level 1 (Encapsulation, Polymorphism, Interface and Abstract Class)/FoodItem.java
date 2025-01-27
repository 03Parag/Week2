// FoodItem (Abstract Class)
abstract class FoodItem {
    // Attributes for FoodItem
    private String itemName;
    private double price;
    private int quantity;

    // Constructor for FoodItem
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Get the item name
    public String getItemName() {
        return itemName;
    }

    // Set the item name
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Get the price
    public double getPrice() {
        return price;
    }

    // Set the price
    public void setPrice(double price) {
        this.price = price;
    }

    // Get the quantity
    public int getQuantity() {
        return quantity;
    }

    // Set the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to  calculateTotalPrice
    public abstract double calculateTotalPrice();

    // Get the item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem (Subclass)
class VegItem extends FoodItem {
    // Constructor for VegItem
    public VegItem(String itemName, double price, int quantity) {
        // Call the abstract class constructor
        super(itemName, price, quantity);
    }

    // Overriding calculateTotalPrice() method
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

// NonVegItem (Subclass)
class NonVegItem extends FoodItem {
    // Attributes for non veg item
    private static final double NON_VEG_EXTRA_CHARGE = 50.0;

    // Constructor for NonVegItem
    public NonVegItem(String itemName, double price, int quantity) {
        // Call the abstract class constructor
        super(itemName, price, quantity);
    }

    // Overriding calculateTotalPrice() method
    @Override
    public double calculateTotalPrice() {
        return (getPrice() + NON_VEG_EXTRA_CHARGE) * getQuantity();
    }
}

// Discountable (Interface)
interface Discountable {
    // Method to apply discount
    double applyDiscount();

    // Method to get discount details
    String getDiscountDetails();
}

// AllFoodItem class
class AllFoodItem extends FoodItem implements Discountable {
    // Attributes for AllFoodItem
    private VegItem vegItem;
    private NonVegItem nonVegItem;
    private boolean isAvailable;

    // Constructor for VegItem
    public AllFoodItem(VegItem vegItem) {
        // Call the abstract class constructor
        super(vegItem.getItemName(), vegItem.getPrice(), vegItem.getQuantity());
        this.vegItem = vegItem;
        this.isAvailable = true;
    }

    // Constructor for NonVegItem
    public AllFoodItem(NonVegItem nonVegItem) {
        // Call the abstract class constructor
        super(nonVegItem.getItemName(), nonVegItem.getPrice(), nonVegItem.getQuantity());
        this.nonVegItem = nonVegItem;
        this.isAvailable = true;
    }

    // Overriding calculateTotalPrice() method
    @Override
    public double calculateTotalPrice() {
        if (vegItem != null) {
            return vegItem.calculateTotalPrice();
        } else if (nonVegItem != null) {
            return nonVegItem.calculateTotalPrice();
        }
        return 0.0;
    }

    // Overriding applyDiscount() method
    @Override
    public double applyDiscount() {
        if (vegItem != null) {
            return vegItem.calculateTotalPrice() * 0.05;
        } else if (nonVegItem != null) {
            return nonVegItem.calculateTotalPrice() * 0.1;
        }
        return 0.0;
    }

    // Overriding getDiscountDetails() method
    @Override
    public String getDiscountDetails() {
        if (vegItem != null) {
            return "5% discount on Veg Items";
        } else if (nonVegItem != null) {
            return "10% discount on Non-Veg Items";
        }
        return "No discount available";
    }

    // Overriding getItemDetails() method
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Method to check availability
    public boolean checkAvailability() {
        return isAvailable;
    }

    // Method to reserve the item
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
}

// Main Class
class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Create VegItem and NonVegItem objects
        VegItem vegItem = new VegItem("Paneer Butter Masala", 150.0, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Tikka", 200.0, 1);

        // Create AllFoodItem objects
        AllFoodItem allVegItem = new AllFoodItem(vegItem);
        AllFoodItem allNonVegItem = new AllFoodItem(nonVegItem);

        // Process the food items
        FoodItem[] foodItems = { allVegItem, allNonVegItem };

        // Initialize the total amount and total discount
        double totalAmount = 0.0;
        double totalDiscount = 0.0;

        for (FoodItem item : foodItems) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price: " + totalPrice);

            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                double discount = discountable.applyDiscount();
                totalDiscount += discount;
                System.out.println(discountable.getDiscountDetails());
                System.out.println("Discount: " + discount);
            }

            totalAmount += totalPrice;
            System.out.println();
        }


        System.out.println("Total Amount before Discount: " + totalAmount);
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("Total Amount after Discount: " + (totalAmount - totalDiscount));
    }
}
