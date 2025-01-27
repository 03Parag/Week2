// LibraryItem (Abstract Class)
abstract class LibraryItem {
    // Attributes for library item
    private String itemId;
    private String title;
    private String author;

    // Constructor for library item
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Get the item ID
    public String getItemId() {
        return itemId;
    }

    // Set the item ID
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // Get the title
    public String getTitle() {
        return title;
    }

    // Set the title
    public void setTitle(String title) {
        this.title = title;
    }

    //Get the author
    public String getAuthor() {
        return author;
    }

    // Set the author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to get loan duration
    public abstract int getLoanDuration();

    // Method to get item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Book (Subclass)
class Book extends LibraryItem {
    // Attribute for book
    private static final int LOAN_DURATION = 14;

    // Constructor for book
    public Book(String itemId, String title, String author) {
        // Call the abstract class constructor
        super(itemId, title, author);
    }

    // Overriding getLoanDuration() method
    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
}

// Magazine (Subclass)
class Magazine extends LibraryItem {
    // Attribute for magazine
    private static final int LOAN_DURATION = 7;

    // Constructor for magazine
    public Magazine(String itemId, String title, String author) {
        // Call the abstract class constructor
        super(itemId, title, author);
    }

    // Overriding getLoanDuration() method
    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
}

// DVD (Subclass)
class DVD extends LibraryItem {
    // Attributes for DVD
    private static final int LOAN_DURATION = 3;

    //Constructor for DVD
    public DVD(String itemId, String title, String author) {
        // Call the abstract class constructor
        super(itemId, title, author);
    }

    // Overriding getLoanDuration() method
    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
}

// Reservable (Interface)
interface Reservable {
    // Method to reserve the item
    boolean reserveItem();

    // Method to check availability
    boolean checkAvailability();
}

// AllLibraryItem Class
class AllLibraryItem extends LibraryItem implements Reservable {
    // Attributes for All Library Item
    private Book book;
    private Magazine magazine;
    private DVD dvd;
    private boolean isAvailable;

    // Constructor for Book
    public AllLibraryItem(Book book) {
        // Call the abstract class constructor
        super(book.getItemId(), book.getTitle(), book.getAuthor());
        this.book = book;
        this.isAvailable = true;
    }

    // Constructor for Magazine
    public AllLibraryItem(Magazine magazine) {
        // Call the abstract class constructor
        super(magazine.getItemId(), magazine.getTitle(), magazine.getAuthor());
        this.magazine = magazine;
        this.isAvailable = true;
    }

    // Constructor for DVD
    public AllLibraryItem(DVD dvd) {
        // Call the abstract class constructor
        super(dvd.getItemId(), dvd.getTitle(), dvd.getAuthor());
        this.dvd = dvd;
        this.isAvailable = true;
    }

    // Overriding the reserveItem() method
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // Overriding the checkAvailability() method
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    // Overriding the getLoanDuration() method
    @Override
    public int getLoanDuration() {
        if (book != null) {
            return book.getLoanDuration();
        } else if (magazine != null) {
            return magazine.getLoanDuration();
        } else if (dvd != null) {
            return dvd.getLoanDuration();
        }
        return 0;
    }

    // Overriding the getItemDetails() method
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Main Class
class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create instances of Book, Magazine, and DVD
        Book book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine("M001", "National Geographic", "Editorial Team");
        DVD dvd = new DVD("D001", "Inception", "Christopher Nolan");

        // Create AllLibraryItem objects
        AllLibraryItem allBook = new AllLibraryItem(book);
        AllLibraryItem allMagazine = new AllLibraryItem(magazine);
        AllLibraryItem allDVD = new AllLibraryItem(dvd);

        // Process library items
        LibraryItem[] libraryItems = { allBook, allMagazine, allDVD };

        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Reserving Item: " + (reservable.reserveItem() ? "Success" : "Failed"));
                System.out.println("Available After Reservation: " + reservable.checkAvailability());
            }

            System.out.println();
        }
    }
}

