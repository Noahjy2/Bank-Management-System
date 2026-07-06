import java.util.Scanner;

public class MainConsole{
    public static void main(String[] args){
        //Display the main menu
        //Receive customer input
        //Access to bank

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
                6. Exit

                Enter your choice (1-6): 
                """);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println("Creat account");
                case "2" -> System.out.println("Deposit");
                case "3" -> System.out.println("Withdraw money");
                case "4" -> System.out.println("Transfer money");
                case "5" -> System.out.println("View account");
                case "6" -> System.out.println("Exit");
                default -> System.out.println("Invalid choice");
            }

            if (choice.equals("6")){
                break;
            }
        }
        

    }
}