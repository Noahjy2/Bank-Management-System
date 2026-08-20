import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileWriter;

public class FileManager {

    public void saveAccounts(ArrayList<Account> accounts){
        
        String filePath = "files/accounts.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){

            for (Account account : accounts){
                writer.write(account.getAccountNumber() + "," +
                    account.getOwnerName() + "," + 
                    account.getBalance()
                );
                writer.newLine();
            }

            writer.close();

        } catch (FileNotFoundException e){
            System.out.println("Cannot find file location.");
        } catch (IOException e){
            System.out.println("Cannot access to file.");
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }

    public void readAccounts(ArrayList<Account> accounts){

        String filePath = "files/accounts.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;

            line = reader.readLine();

            if (line == null){
                System.out.println("The file is empty.");
                return;
            }

            do {
                String[] data = line.split(",");

                String accountNumber = data[0];
                String ownerName = data[1];
                double balance = Double.parseDouble(data[2]);

                Account newAccount = new Account(accountNumber,ownerName,balance);
                accounts.add(newAccount);

            } while ((line = reader.readLine()) != null);

        } catch (FileNotFoundException e){
            System.out.println("Cannot find file location.");
        } catch (IOException e){
            System.out.println("Cannot access to file.");
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
    }
}
