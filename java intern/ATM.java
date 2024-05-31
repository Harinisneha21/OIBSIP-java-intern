import java.util.Scanner;

public class ATM{
    private double balance;
    private Scanner scanner;

    public ATM() {
        balance = 0.0;
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void checkBalance() {
        System.out.printf("Your balance is: $%.2f\n", balance);
    }

    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("You've successfully deposited $%.2f\n", amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You've successfully withdrawn $%.2f\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a lesser amount.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}