import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingApp {

    static Scanner scanner = new Scanner(System.in);
    static List<String> transactionLogs = new ArrayList<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Predefined user credentials
    static final String REGISTERED_USERNAME = "JohnNeo";
    static final String REGISTERED_PIN = "1234";

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       WELCOME TO CLI BANKING APP       ");
        System.out.println("========================================");

        // Require successful login before accessing the banking menu
        if (!login()) {
            System.out.println("\nAccess Denied. Exiting program...");
            scanner.close();
            return;
        }

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning){
            System.out.println("\n***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer (Mobile)");
            System.out.println("5. Transaction Logs");
            System.out.println("6. Exit");
            System.out.println("***************");

            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    balance += deposit();
                    break;
                case 3:
                    balance -= withdraw(balance);
                    break;
                case 4:
                    balance -= transfer(balance);
                    break;
                case 5:
                    showTransactionLogs();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }

        System.out.println("***************************");
        System.out.println("Thank you! Have a nice day!");
        System.out.println("***************************");

        scanner.close();
    }

    static boolean login() {
        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("\n--- LOGIN TO YOUR ACCOUNT ---");
            System.out.print("Enter Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter 4-digit PIN: ");
            String pin = scanner.nextLine().trim();

            if (username.equals(REGISTERED_USERNAME) && pin.equals(REGISTERED_PIN)) {
                System.out.printf("\nLogin Successful! Welcome, %s.\n", username);
                return true;
            } else {
                int remaining = maxAttempts - attempt;
                if (remaining > 0) {
                    System.out.printf("Invalid credentials! You have %d attempt(s) left.\n", remaining);
                } else {
                    System.out.println("Too many failed attempts. Account locked temporarily.");
                }
            }
        }
        return false;
    }

    static void showBalance(double balance){
        System.out.println("***************");
        System.out.printf("Current Balance: PHP %.2f\n", balance);
    }

    static double deposit(){
        double amount;

        System.out.print("Enter an amount to be deposited: ");
        amount = scanner.nextDouble();

        if(amount <= 0){
            System.out.println("Amount must be greater than 0");
            return 0;
        }
        else{
            logTransaction(String.format("DEPOSIT  | +PHP %-10.2f | Self", amount));
            System.out.printf("Successfully deposited PHP %.2f\n", amount);
            return amount;
        }
    }

    static double withdraw(double balance){
        double amount;

        System.out.print("Enter amount to be withdrawn: ");
        amount = scanner.nextDouble();

        if(amount > balance){
            System.out.println("INSUFFICIENT FUNDS");
            return 0;
        }
        else if(amount <= 0){
            System.out.println("Amount must be greater than 0");
            return 0;
        }
        else{
            logTransaction(String.format("WITHDRAW | -PHP %-10.2f | ATM / Cash", amount));
            System.out.printf("Successfully withdrew PHP %.2f\n", amount);
            return amount;
        }
    }

    static double transfer(double balance){
        scanner.nextLine(); // Clear scanner buffer

        System.out.print("Enter recipient's mobile number: ");
        String mobileNumber = scanner.nextLine().trim();

        // 1. Validate mobile number
        if(mobileNumber.isEmpty() || !mobileNumber.matches("\\d{10,11}")){
            System.out.println("TRANSFER FAILED: Invalid mobile number. Must be 10-11 digits.");
            return 0;
        }

        // 2. Validate transfer amount
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if(amount <= 0){
            System.out.println("TRANSFER FAILED: Amount must be greater than 0.");
            return 0;
        }

        // 3. Validate sender balance
        if(amount > balance){
            System.out.println("TRANSFER FAILED: Insufficient funds.");
            return 0;
        }

        double remainingBalance = balance - amount;
        logTransaction(String.format("TRANSFER | -PHP %-10.2f | To: %s", amount, mobileNumber));

        System.out.println("----------------------------------------");
        System.out.println("Transfer Successful!");
        System.out.printf("Sent: PHP %.2f to %s\n", amount, mobileNumber);
        System.out.printf("Remaining Balance: PHP %.2f\n", remainingBalance);
        System.out.println("----------------------------------------");

        return amount;
    }

    static void logTransaction(String details) {
        String timestamp = LocalDateTime.now().format(formatter);
        transactionLogs.add(String.format("[%s] %s", timestamp, details));
    }

    static void showTransactionLogs() {
        System.out.println("\n============= TRANSACTION LOGS =============");
        if (transactionLogs.isEmpty()) {
            System.out.println("No recorded transactions yet.");
        } else {
            for (String log : transactionLogs) {
                System.out.println(log);
            }
        }
        System.out.println("============================================");
    }
}