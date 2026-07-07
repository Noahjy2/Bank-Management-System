import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    
    public Bank(){
        accounts = new ArrayList<>();
    }

    public void createAccount(Account newAccount){
        for (Account account: accounts){
            if (account.getAccountNumber().equals(newAccount.getAccountNumber())){
                System.out.println("The account is already exist!");
                return;
            }
        }
        accounts.add(newAccount);
    }

    public Account findAccount(String accountNumber){
        for (Account account: accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts(){
        int i = 0;
        for (Account account : accounts){
            i++;
            System.out.println("-----" + i + "-----");
            System.out.println(account.toString());
        }
    }




}
