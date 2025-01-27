// Book class (Superclass)
class Book {
    // Attributes for Book
    protected String title;
    protected int publicationYear;

    // Constructor for Book
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display Book details
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Author class (Subclass)
class Author extends Book {
    // Additional attributes for Author
    private String name;
    private String bio;

    // Constructor for Author
    public Author(String title, int publicationYear, String name, String bio) {
        // Call the superclass constructor
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overriding displayInfo to include Author details
    @Override
    public void displayInfo() {
        // Call superclass method
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class
class LibraryManagement {
    public static void main(String[] args) {
        // Create instance for author
        Author author = new Author("Rich dad poor dad", 1997, "Robert Kiyosaki", "Robert Kiyosaki was an Japanese novelist widely known for 'Rich dad poor dad', published in 1997.");
        // Display book and author information
        author.displayInfo();
    }
}

