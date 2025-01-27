// BankAccount class (Base class)
class BankAccount {
    // Attributes for all accounts
    protected String accountNumber;
    protected double balance;

    // Constructor for BankAccount
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs" + balance);
    }

    // Method to display the account type 
    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

// SavingsAccount class (Subclass)
class SavingsAccount extends BankAccount {
    // Attribute for SavingsAccount
    private double interestRate;

    // Constructor for SavingsAccount
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        // Call the superclass constructor
        super(accountNumber, balance); 
        this.interestRate = interestRate;
    }

    // Overriding displayAccountType
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    // Method to display additional details
    @Override
    public void displayDetails() {
        // Display common account details
        super.displayDetails(); 
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount class (Subclass)
class CheckingAccount extends BankAccount {
    // Attribute for CheckingAccount
    private double withdrawalLimit;

    // Constructor for CheckingAccount
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        // Call the superclass constructor
        super(accountNumber, balance); 
        this.withdrawalLimit = withdrawalLimit;
    }

    // Overriding displayAccountType
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }

    // Method to display additional details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Display common account details
        System.out.println("Withdrawal Limit: Rs" + withdrawalLimit);
    }
}

// FixedDepositAccount class (Subclass)
class FixedDepositAccount extends BankAccount {
    // Attribute for FixedDepositAccount
    private int depositTerm; 

    // Constructor for FixedDepositAccount
    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        // Call the superclass constructor
        super(accountNumber, balance); 
        this.depositTerm = depositTerm;
    }

    // Overriding displayAccountType
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }

    // Method to display additional details
    @Override
    public void displayDetails() {
        // Display common account details
        super.displayDetails(); 
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Main Class
class BankAccountTypes {
    public static void main(String[] args) {
        // Create objects for each account type
        SavingsAccount savings = new SavingsAccount("SA12345", 5000.0, 3.5);
        CheckingAccount checking = new CheckingAccount("CA67890", 3000.0, 1000.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD11223", 10000.0, 12);

        // Using polymorphism to call overridden methods
        BankAccount[] accounts = {savings, checking, fixedDeposit};

        // Display details and account type for each account
        for (BankAccount account : accounts) {
            account.displayAccountType();
            account.displayDetails();
            System.out.println();
        }
    }
}

