// Create a BankAccount class to check if the account is an instanceof BankAccount
public class BankAccount {
    // Static variable to store the bank name
    private static String bankName = "National Bank";

    // Static variable to keep track of total accounts
    private static int totalAccounts = 0;

    // Final variable for the account number
    private final int accountNumber;

    // Instance variable for the account holder name
    private String accountHolderName;

    // Parameterized constructor to initialize account details
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName; 
        this.accountNumber = accountNumber; // Final variable assigned once
        totalAccounts++; // Increment total accounts
    }

    // Method to get the total number of accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) { // Check if the object is an instance of BankAccount
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    // Method to set the bank name
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void main(String[] args) {
        // Set a bank name
        BankAccount.setBankName("SBI Bank");

        // Create two bank accounts
        BankAccount account1 = new BankAccount("Alice", 101);
        BankAccount account2 = new BankAccount("Bob", 102);

        // Display account details
        account1.displayAccountDetails();
        System.out.println();
        account2.displayAccountDetails();

        // Display total accounts
        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
    }
}
