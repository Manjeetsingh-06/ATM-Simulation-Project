import java.util.ArrayList;

public class Account {
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    public Account() {
        this.balance = 1000.00; // Initial balance
        this.pin = "1234"; // Default PIN
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}
