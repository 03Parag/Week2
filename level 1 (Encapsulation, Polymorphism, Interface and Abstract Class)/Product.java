// Product (Abstract Class)
abstract class Product {
    // Attributes for product
    private int productId;
    private String name;
    private double price;

    // Constructor for product
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Get the product ID
    public int getProductId() {
        return productId;
    }

    // Set the product ID
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Get the product name
    public String getName() {
        return name;
    }

    // Set the product name
    public void setName(String name) {
        this.name = name;
    }

    // Get the product price
    public double getPrice() {
        return price;
    }

    // Set the product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics (Subclass)
class Electronics extends Product {
    // Attributes for electronics
    private double discountRate;

    // Constructor for electronics
    public Electronics(int productId, String name, double price, double discountRate) {
        // Call the abstract class constructor
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    // Get the discount rate
    public double getDiscountRate() {
        return discountRate;
    }

    // Set the discount rate
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    // Overriding calculateDiscount() method
    @Override
    public double calculateDiscount() {
        return getPrice() * (discountRate / 100);
    }
}

// Clothing (Subclass)
class Clothing extends Product {
    // Attributes for clothing
    private double discountRate;

    // Constructor for clothing
    public Clothing(int productId, String name, double price, double discountRate) {
        // Call the abstract class constructor
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    // Get the discount rate
    public double getDiscountRate() {
        return discountRate;
    }

    // Set the discount rate
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    // Overriding calculateDiscount() method
    @Override
    public double calculateDiscount() {
        return getPrice() * (discountRate / 100);
    }
}

// Groceries (Subclass)
class Groceries extends Product {
    // Attributes for groceries
    private double discountRate;

    // Constructor for groceries
    public Groceries(int productId, String name, double price, double discountRate) {
        // Call the abstract class constructor
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    // Get the discount rate
    public double getDiscountRate() {
        return discountRate;
    }

    // Set the discount rate
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    // Overriding calculateDiscount() method
    @Override
    public double calculateDiscount() {
        return getPrice() * (discountRate / 100);
    }
}

// Taxable (Interface)
interface Taxable {
    // Calculate tax
    double calculateTax();

    // Get tax details
    String getTaxDetails();
}

// AllProduct Class implementing Taxable and extending Product
class AllProduct extends Product implements Taxable {
    // Attributes for all products
    private Electronics electronics;
    private Clothing clothing;
    private Groceries groceries;

    // Constructor for electronics
    public AllProduct(Electronics electronics) {
        // Call the abstract class  constructor
        super(electronics.getProductId(), electronics.getName(), electronics.getPrice());
        this.electronics = electronics;
    }

    // Constructor for clothing
    public AllProduct(Clothing clothing) {
        // Call the abstract class  constructor
        super(clothing.getProductId(), clothing.getName(), clothing.getPrice());
        this.clothing = clothing;
    }

    // Constructor for groceries
    public AllProduct(Groceries groceries) {
        // Call the abstract class  constructor
        super(groceries.getProductId(), groceries.getName(), groceries.getPrice());
        this.groceries = groceries;
    }

    // Overriding calculateTax() method
    @Override
    public double calculateTax() {
        if (electronics != null) {
            return electronics.getPrice() * 0.15; // 15% tax for electronics
        } else if (clothing != null) {
            return clothing.getPrice() * 0.10; // 10% tax for clothing
        }
        return 0.0; // No tax for groceries
    }

    // Overriding getTaxDetails() method
    @Override
    public String getTaxDetails() {
        if (electronics != null) {
            return "Tax for Electronics: 15%";
        } else if (clothing != null) {
            return "Tax for Clothing: 10%";
        }
        return "No Tax Applicable for Groceries";
    }

    // Overriding calculateDiscount() method
    @Override
    public double calculateDiscount() {
        if (electronics != null) {
            return electronics.calculateDiscount();
        } else if (clothing != null) {
            return clothing.calculateDiscount();
        } else if (groceries != null) {
            return groceries.calculateDiscount();
        }
        return 0.0;
    }

    // Display details
    public void displayDetails() {
        // Call the display details method
        super.displayDetails();
        if (electronics != null) {
            System.out.println("Discount Rate: " + electronics.getDiscountRate() + "%");
        } else if (clothing != null) {
            System.out.println("Discount Rate: " + clothing.getDiscountRate() + "%");
        } else if (groceries != null) {
            System.out.println("Discount Rate: " + groceries.getDiscountRate() + "%");
        }
    }
}

// Main Class
class ECommercePlatform {
    public static void main(String[] args) {
        // Create Electronics, Clothing, and Groceries objects
        Electronics laptop = new Electronics(1, "Laptop", 1000, 10);
        Clothing shirt = new Clothing(2, "Shirt", 50, 20);
        Groceries apple = new Groceries(3, "Apple", 2, 5);

        // Create AllProduct objects for each product
        AllProduct allElectronics = new AllProduct(laptop);
        AllProduct allClothing = new AllProduct(shirt);
        AllProduct allGroceries = new AllProduct(apple);

        // Process a list of all products
        Product[] products = { allElectronics, allClothing, allGroceries };

        for (Product product : products) {
            product.displayDetails();
            System.out.println("Discount: " + product.calculateDiscount());
            if (product instanceof Taxable) {
                Taxable taxable = (Taxable) product;
                System.out.println(taxable.getTaxDetails());
                System.out.println("Tax: " + taxable.calculateTax());
            }
            double finalPrice = product.getPrice() + ((product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0.0) - product.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
            System.out.println();
        }
    }
}

