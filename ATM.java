import java.util.Scanner;

public class ATM {
    private Account account;
    private static final double MIN_WITHDRAWAL = 1.00;
    private static final double MAX_WITHDRAWAL = 500.00;
    private static final int MAX_PIN_ATTEMPTS = 3;

    public ATM(Account account) {
        this.account = account;
    }

    public void start(Scanner scanner) {
        boolean loggedIn = false;
        int attempts = 0;

        System.out.println("Welcome to the ATM Simulation!");

        // PIN Verification
        while (!loggedIn && attempts < MAX_PIN_ATTEMPTS) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();
            if (enteredPin.equals(account.getPin())) {
                loggedIn = true;
                System.out.println("PIN verified. Access granted.");
            } else {
                attempts++;
                System.out.println("Invalid PIN. Attempts remaining: " + (MAX_PIN_ATTEMPTS - attempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Account locked. Exiting...");
            return;
        }

        // Main Menu Loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidInt(scanner);
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    changePIN(scanner);
                    break;
                case 6:
                    logout();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Check Balance
    private void checkBalance() {
        System.out.printf("Your current balance is: Rs.%.2f\n", account.getBalance());
        account.addTransaction("Checked balance: Rs." + String.format("%.2f", account.getBalance()));
    }

    // Deposit Money
    private void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidDouble(scanner);
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be positive.");
            return;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.printf("Deposited Rs.%.2f. New balance: Rs.%.2f\n", amount, account.getBalance());
        account.addTransaction("Deposited: Rs." + String.format("%.2f", amount));
    }

    // Withdraw Money with Min/Max Checks
    private void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidDouble(scanner);
        if (amount < MIN_WITHDRAWAL || amount > MAX_WITHDRAWAL) {
            System.out.printf("Invalid amount. Withdrawal must be between Rs.%.2f and Rs.%.2f.\n", MIN_WITHDRAWAL, MAX_WITHDRAWAL);
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.printf("Withdrew Rs.%.2f. New balance: Rs.%.2f\n", amount, account.getBalance());
        account.addTransaction("Withdrew: Rs." + String.format("%.2f", amount));
    }

    // Transaction History
    private void viewTransactionHistory() {
        if (account.getTransactionHistory().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println("- " + transaction);
            }
        }
    }

    // Change PIN
    private void changePIN(Scanner scanner) {
        System.out.print("Enter current PIN: ");
        String currentPin = scanner.nextLine();
        if (!currentPin.equals(account.getPin())) {
            System.out.println("Incorrect current PIN.");
            return;
        }
        System.out.print("Enter new PIN (4 digits): ");
        String newPin = scanner.nextLine();
        if (newPin.length() != 4 || !newPin.matches("\\d{4}")) {
            System.out.println("Invalid PIN. Must be 4 digits.");
            return;
        }
        account.setPin(newPin);
        System.out.println("PIN changed successfully.");
        account.addTransaction("PIN changed");
    }

    // Logout
    private void logout() {
        System.out.println("Logging out. Thank you for using the ATM!");
        account.addTransaction("Logged out");
    }

    // Helper: Get valid integer input
    private int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return num;
    }

    // Helper: Get valid double input
    private double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: ");
            scanner.next();
        }
        double num = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return num;
    }
}
