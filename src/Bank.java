import java.util.ArrayList;
import java.util.Scanner;


public class Bank {
    
    public Bank(){

    }

    public void createAccount(Scanner scanner, ArrayList<Account> accounts, FileManager file){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        if (findAccount(accountNumber, accounts) != null){
            System.out.println("The account number already exist.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        double initialBalance;

        while (true) {
            try {
                System.out.print("Enter Initial Balance Amount: ");
            String input = scanner.nextLine();
            initialBalance = Double.parseDouble(input);
            break;
            } catch (NumberFormatException e){
                System.out.println("Please enter valid number.");
            }
        }
        
        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(account);

        file.saveAccounts(accounts);
    }

    public void deleteAccount(Scanner scanner, ArrayList<Account> accounts, FileManager file){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account selectedAccount = findAccount(accountNumber, accounts);

        if (selectedAccount == null){
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(selectedAccount);

        file.saveAccounts(accounts);
        System.out.println("Account removed succesfully.");
    }

    public void depositFund(Scanner scanner, ArrayList<Account> accounts){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber, accounts);
        if (account == null){
            System.out.println("Account not found");
            return;
        }

        double depositAmount;
        
        while (true){
            try {
                System.out.print("Enter Deposit Amount: ");
                String input = scanner.nextLine();
                depositAmount = Double.parseDouble(input) ;
                break;

            } catch (NumberFormatException e){
                System.out.println("Please enter valid number.");
            }
        }
        account.deposit(depositAmount);
    }


    public void withdrawFund(Scanner scanner, ArrayList<Account> accounts){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber, accounts);
        if (account == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        
        account.withdraw(withdrawAmount);
    }



    public void viewAccount(Scanner scanner, ArrayList<Account> accounts){
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber, accounts);

        if (account != null){
            System.out.println('\n' + account.toString());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Bug exist
    public void transferFund(Scanner scanner, ArrayList<Account> accounts){
        System.out.print("Enter Source Account Number: ");
        String sourceAccountNumber = scanner.nextLine();

        Account sourceAccount = findAccount(sourceAccountNumber, accounts);
        if (sourceAccount == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Destination Account Number: ");
        String destiAccountNumber = scanner.nextLine();

        Account destiAccount = findAccount(destiAccountNumber, accounts);
        if (destiAccount == null){
            System.out.println("Account not found");
            return;
        }

        if (sourceAccount == destiAccount){
            System.out.println("Cannot transfer to the same account");
            return;
        }

        double transferAmount;

        while (true) {
            try {
                System.out.print("Transfer Amount: ");
                String input = scanner.nextLine();
                transferAmount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e){
                System.out.println("Please enter valid number.");
            }
        }
        

        if (transferAmount < 0){
            System.out.println("Transfer Amount cannot be negative");
            return;
        }

        sourceAccount.withdraw(transferAmount);
        destiAccount.deposit(transferAmount);
        System.out.println("Transfer successful.");
    }



    public Account findAccount(String accountNumber, ArrayList<Account> accounts){
        for (Account account: accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts(ArrayList<Account> accounts){
        if (accounts.isEmpty()){
            System.out.println("There is no account yet.");
            return;
        }

        System.out.print("""
                \n==========================================================
                Account Number         Owner name             Balance
                ==========================================================
                """);
        for (Account account : accounts){
            System.out.printf("%-22s %-22s %-8.2f %n",
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance()
            );
        }
    }

}
