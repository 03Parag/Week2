import java.util.ArrayList;

// Bank Class
class Bank {
    // Attributes of bank
    private String name;

    // Constructor of bank
    public Bank(String name) {
        this.name = name;
    }

    // Open an account for a customer
    public void openAccount(Customer customer, double initialDeposit) {
        customer.openAccount(initialDeposit);
    }
}

// Customer Class
class Customer {
    // Attributes of customer
    private String name;
    // Each account is represented by a balance
    private ArrayList<Double> accounts; 

    // Constructor of customer
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Open a new account
    public void openAccount(double initialDeposit) {
        accounts.add(initialDeposit);
        System.out.println("Account opened for " + name + " with initial deposit: Rs" + initialDeposit);
    }

    // View all account balances
    public void viewBalance() {
        System.out.println("Accounts for " + name + ":");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + " Balance: Rs" + accounts.get(i));
        }
    }
}

class  Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("National Bank");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts for customers
        bank.openAccount(alice, 500.0);
        bank.openAccount(bob, 1000.0);
        bank.openAccount(alice, 300.0);

        // View account balances
        alice.viewBalance();
        bob.viewBalance();
    }
}