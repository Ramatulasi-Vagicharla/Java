import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Initial balance
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + String.format("%.2f", amount));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + String.format("%.2f", amount));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
}

public class SimpleBankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = new BankAccount(accountNumber);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting... Thank you for using the banking app!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close(); // Close the scanner to prevent resource leak
    }
}
