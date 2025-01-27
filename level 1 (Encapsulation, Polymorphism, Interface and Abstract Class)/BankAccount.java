// BankAccount (Abstract Class)
abstract class BankAccount {
    // Attributes for bank account
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor for bank account
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Get the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Set the account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Get the holder name
    public String getHolderName() {
        return holderName;
    }

    // Set the holder name
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    // Get the balance
    public double getBalance() {
        return balance;
    }

    // Set the balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to deposit the amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw the amount
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Display details of the account
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount (Subclass)
class SavingsAccount extends BankAccount {
    // Attributes for saving account
    private static final double INTEREST_RATE = 0.04;

    // Constructor for saving account
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        // Call the abstract class constructor
        super(accountNumber, holderName, balance);
    }

    // Overriding calculateInterest() method
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// CurrentAccount (Subclass)
class CurrentAccount extends BankAccount {
    // Attribute for current account
    private static final double INTEREST_RATE = 0.01;

    // Constructor for current account
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        // Call the abstract class constructor
        super(accountNumber, holderName, balance);
    }

    // Overriding calculateInterest() method
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    // Overriding withdraw() method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

// Loanable (Interface)
interface Loanable {
    // Method to calculate loan eligibility
    double calculateLoanEligibility();

    // Get the loan details
    String getLoanDetails();
}

// AllBankAccount Class
class AllBankAccount extends BankAccount implements Loanable {
    // Attributes for all bank account
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;

    // Constructor for SavingsAccount
    public AllBankAccount(SavingsAccount savingsAccount) {
        // Call the abstract class constructor
        super(savingsAccount.getAccountNumber(), savingsAccount.getHolderName(), savingsAccount.getBalance());
        this.savingsAccount = savingsAccount;
    }

    // Constructor for CurrentAccount
    public AllBankAccount(CurrentAccount currentAccount) {
        // Call the abstract class constructor
        super(currentAccount.getAccountNumber(), currentAccount.getHolderName(), currentAccount.getBalance());
        this.currentAccount = currentAccount;
    }

    // Overriding calculateLoanEligibility() method
    @Override
    public double calculateLoanEligibility() {
        if (savingsAccount != null) {
            return savingsAccount.getBalance() * 5; // Savings: Loan eligibility = 5x balance
        } else if (currentAccount != null) {
            return currentAccount.getBalance() * 3; // Current: Loan eligibility = 3x balance
        }
        return 0.0;
    }

    // Overriding getLoanDetails() method
    @Override
    public String getLoanDetails() {
        if (savingsAccount != null) {
            return "Loan Eligibility Multiplier: 5x for Savings Account";
        } else if (currentAccount != null) {
            return "Loan Eligibility Multiplier: 3x for Current Account";
        }
        return "No loan details available.";
    }

    // Overriding calculateInterest() method
    @Override
    public double calculateInterest() {
        if (savingsAccount != null) {
            return savingsAccount.calculateInterest();
        } else if (currentAccount != null) {
            return currentAccount.calculateInterest();
        }
        return 0.0;
    }

    // Overriding displayDetails() method
    @Override
    public void displayDetails() {
        if (savingsAccount != null) {
            savingsAccount.displayDetails();
        } else if (currentAccount != null) {
            currentAccount.displayDetails();
        }
    }
}

// Main Class
class BankingSystem {
    public static void main(String[] args) {
        // Create Savings and Current Account objects
        SavingsAccount savings = new SavingsAccount("S123", "John Doe", 10000);
        CurrentAccount current = new CurrentAccount("C456", "Jane Smith", 20000);

        // Create AllBankAccount objects
        AllBankAccount allSavings = new AllBankAccount(savings);
        AllBankAccount allCurrent = new AllBankAccount(current);

        // Process accounts
        BankAccount[] accounts = { allSavings, allCurrent };

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Interest Earned: " + account.calculateInterest());

            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println(loanable.getLoanDetails());
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
            }

            System.out.println();
        }
    }
}
