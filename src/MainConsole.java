import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        //Display the main menu
        //Receive customer input
        //Access to bank
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank Management System");

        while (true){
            System.out.print("""
                ===========Main Menu=========

                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. View Account
                6. Display All Accounts
                7. Exit

                """);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createAccount(scanner, bank);
                case "2" -> System.out.println("Deposit");
                case "3" -> System.out.println("Withdraw money");
                case "4" -> System.out.println("Transfer money");
                case "5" -> viewAccount(scanner, bank);
                case "6" -> bank.displayAllAccounts();
                case "7" -> System.out.println("Good Bye🫡");
                default -> System.out.println("Invalid choice");
            }

            if (choice.equals("7")){
                break;
            }
        }
        scanner.close();

    }
    public static void createAccount(Scanner scanner, Bank bank){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter Initial Balance Amount: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        
        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        bank.createAccount(account);
    }

    public static void viewAccount(Scanner scanner, Bank bank){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = bank.findAccount(accountNumber);
        if (account != null){
            System.out.println(account.toString());
        } else {
            System.out.println("Account not found");
        }
    }
}