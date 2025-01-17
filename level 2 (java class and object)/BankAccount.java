// Create BankAccount class for to deposit money, withdraw money and display the current balance
public class BankAccount {
    // Attributes of the BankAccount class
    private String accountHolder;
    private int accountNumber;  
    private double balance;
    // Constructor to initialize the bank account holder, number, and balance
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    // Method to withdraw money from the account (only if sufficient balance exists)
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew " + amount + ". Current balance: " + balance);
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
    public static void main(String[] args) {
        // Create a BankAccount object 
        BankAccount account1 = new BankAccount("John Smith", 1234567890, 500.00);  
        // Display the initial balance
        account1.displayBalance();
        // Deposit money into the account
        account1.deposit(200.00);
        // Try withdrawing money
        account1.withdraw(100.00);
        // Attempt an overdraft
        account1.withdraw(700.00);
        // Display the final balance
        account1.displayBalance();
    }
}
