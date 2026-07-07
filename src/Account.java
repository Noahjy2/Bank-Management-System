public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    //Getter
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public String getOwnerName(){
        return this.ownerName;
    }
    public double getBalance(){
        return this.balance;
    }

    //Setter 
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public void deposit(double value){
        this.balance += value;
    }
    public void withdraw(double value){
        if (value < 0){
            System.out.println("Amount cannot be negative");
        } else if (value > balance){
            System.out.println("Balance is not enough");
        } else {
            this.balance -= value;
        }
    }

    @Override
    public String toString(){
        return "Account Number: " + this.accountNumber + "\nOwner Name: " + this.ownerName + "\nBalance: " + String.format("%.2f", this.balance); 
    }
}
