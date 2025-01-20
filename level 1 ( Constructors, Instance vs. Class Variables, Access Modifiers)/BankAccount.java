// Base class
public class BankAccount {
    // Attributes
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    // Parameterized constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to get the balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs" + amount + ". New Balance: Rs" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew Rs" + amount + ". New Balance: Rs" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs" + balance);
    }
}

// Subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Parameterized constructor
    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate and add interest to the balance
    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest); 
        System.out.println("Interest of Rs" + interest + " added at a rate of " + interestRate + "%");
    }

    // Method to display savings account details
    public void displaySavingsAccountDetails() {
        // Access public and protected members from the parent class
        System.out.println("Account Number: " + accountNumber); // Public member
        System.out.println("Account Holder: " + accountHolder); // Protected member
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount account = new BankAccount(101, "Joe Biden", 5000.0);
        account.displayAccountDetails();

        System.out.println("\nDepositing Rs1000");
        account.deposit(1000);

        System.out.println("\nWithdrawing Rs2000");
        account.withdraw(2000);

        System.out.println("\nCreating a SavingsAccount");
        SavingsAccount savingsAccount = new SavingsAccount(201, "Alice Trudeau", 8000.0, 5.0);
        savingsAccount.displaySavingsAccountDetails();

        System.out.println("\nAdding Interest");
        savingsAccount.addInterest();

        System.out.println("\nSavings Account Details After Interest:");
        savingsAccount.displaySavingsAccountDetails();
    }
}
