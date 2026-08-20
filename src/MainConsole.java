import java.util.Scanner;
import java.util.ArrayList;

public class MainConsole{
    public static void main(String[] args){
        
        Bank bank = new Bank();
        FileManager file = new FileManager();
        ArrayList<Account> accounts = new ArrayList<>();

        file.readAccounts(accounts);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank Management System");

        while (true){
            System.out.print("""
                \n===========Main Menu=========

                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Delete Account
                6. View Account
                7. Display All Accounts
                8. Exit

                """);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> bank.createAccount(scanner, accounts, file);
                case "2" -> bank.depositFund(scanner, accounts);
                case "3" -> bank.withdrawFund(scanner,accounts);
                case "4" -> bank.transferFund(scanner,accounts);
                case "5" -> bank.deleteAccount(scanner, accounts, file);
                case "6" -> bank.viewAccount(scanner,accounts);
                case "7" -> bank.displayAllAccounts(accounts);
                case "8" -> System.out.println("Good Bye🫡");
                default -> System.out.println("Invalid choice");
            }

            if (choice.equals("8")){
                break;
            }
        }
        scanner.close();
    }
    
}