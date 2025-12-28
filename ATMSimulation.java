import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(); // Create an account instance
        ATM atm = new ATM(account); // Create ATM instance with the account

        atm.start(scanner); // Start the ATM simulation
        scanner.close();
    }
}
