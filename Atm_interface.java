import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: Rs:" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: Rs: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}
public class ATM {
    private BankAccount userAccount;
    public ATM(BankAccount account) {
        this.userAccount = account;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.println("Current Balance: Rs: " + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs: ");
                double withdrawalAmount = scanner.nextDouble();
                userAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            atm.processOption(choice);
        }
    }
}
