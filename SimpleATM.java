import java.util.Scanner;

public class SimpleATM {

    static double balance = 1000050.00;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice1! Please try again.");
            }

            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: Rs%.2f%n", balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: Rs");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: Rs%.2f%n", amount);
            System.out.printf("New balance: Rs%.2f%n", balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: Rs");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: Rs%.2f%n", amount);
            System.out.printf("Remaining balance: Rs%.2f%n", balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}
