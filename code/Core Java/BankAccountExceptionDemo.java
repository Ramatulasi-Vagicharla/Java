import java.util.Scanner;

// Custom checked exception for insufficient funds
class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds. You need " + amount + " more to complete this transaction.");
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Custom unchecked exception for invalid account ID
class InvalidAccountException extends RuntimeException {
    private String accountId;
    
    public InvalidAccountException(String accountId) {
        super("Invalid account ID: " + accountId);
        this.accountId = accountId;
    }
    
    public String getAccountId() {
        return accountId;
    }
}

// Main class demonstrating exception handling with modified logic
public class BankAccountExceptionDemo {
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("Enter '1' to withdraw, '2' to deposit, or 'q' to quit: ");
                String choice = scanner.nextLine();
                
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    break;
                }

                // Get the account ID and amount based on the action
                System.out.print("Enter account ID: ");
                String accountId = scanner.nextLine();
                
                if (choice.equals("1")) {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    
                    // Withdraw method may throw exceptions
                    account.withdraw(accountId, amount);
                    System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                } else if (choice.equals("2")) {
                    System.out.print("Enter amount to deposit: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    
                    // Deposit money into the account
                    account.deposit(accountId, amount);
                    System.out.println("Deposit successful. New balance: $" + account.getBalance());
                } else {
                    System.out.println("Invalid choice! Please enter '1', '2', or 'q'.");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("You need $" + e.getAmount() + " more. Please try again.");
            } catch (InvalidAccountException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with a valid account ID.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount entered. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
                break;
            } finally {
                System.out.println("Transaction attempt completed.");
            }
        }
        
        scanner.close();
    }
}

// Bank account class with modified logic
class BankAccount {
    private String accountId;
    private double balance;
    
    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Withdraw method with added logic to prevent negative amounts
    public void withdraw(String accountId, double amount) throws InsufficientFundsException {
        if (!this.accountId.equals(accountId)) {
            throw new InvalidAccountException(accountId);
        }
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException(shortfall);
        }
        
        balance -= amount;
    }
    
    // Deposit method with validation for negative deposits
    public void deposit(String accountId, double amount) {
        if (!this.accountId.equals(accountId)) {
            throw new InvalidAccountException(accountId);
        }
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        
        balance += amount;
    }
}
