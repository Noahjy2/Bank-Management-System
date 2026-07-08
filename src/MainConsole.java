import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        
        Bank bank = new Bank();

        //Add account to the bank for testing purpose
        Account account = new Account("123456", "John Doe", 1000.0);
        bank.createAccount(account);

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
                case "2" -> depositFund(scanner, bank);
                case "3" -> withdrawFund(scanner, bank);
                case "4" -> transferFund(scanner, bank);
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
            System.out.println('\n' + account.toString());
        } else {
            System.out.println("Account not found");
        }
    }

    public static void depositFund(Scanner scanner, Bank bank){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = bank.findAccount(accountNumber);
        if (account == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        
        account.deposit(depositAmount);
    }

    public static void withdrawFund(Scanner scanner, Bank bank){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = bank.findAccount(accountNumber);
        if (account == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        
        account.withdraw(withdrawAmount);
    }
    
    public static void transferFund(Scanner scanner, Bank bank){
        System.out.print("Enter Source Account Number: ");
        String sourceAccountNumber = scanner.nextLine();

        Account sourceAccount = bank.findAccount(sourceAccountNumber);
        if (sourceAccount == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Destination Account Number: ");
        String destiAccountNumber = scanner.nextLine();

        Account destiAccount = bank.findAccount(destiAccountNumber);
        if (destiAccount == null){
            System.out.println("Account not found");
            return;
        }

        if (sourceAccount == destiAccount){
            System.out.println("Cannot transfer to the same account");
            return;
        }

        System.out.print("Transfer Amount: ");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (transferAmount < 0){
            System.out.println("Transfer Amount cannot be negative");
            return;
        }

        sourceAccount.withdraw(transferAmount);
        destiAccount.deposit(transferAmount);
        System.out.println("Transfer successful.");
    }
}