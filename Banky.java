import java.util.Random;
import java.util.Scanner;

public class Banky {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        AccountManagement accountManagement = new AccountManagement();
        while (true) {
            System.out.println("1. Press '1' to create an account\n2. Press '2' to deposit\n3. Press '3' to withdraw\n4. Press '4' to transfer money\n5. Press any to exit.");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    accountManagement.createAccount();
                    break;
                case 2:
                    accountManagement.deposit();
                    break;
                case 3:
                    accountManagement.withdraw();
                    break;
                case 4:
                    accountManagement.transfer();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}

class AccountManagement {
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    long newAccountNumber = random.nextLong(221430110101L, 500122010066L);
    long balance = 0;

    public void createAccount() {
        System.out.print("Enter Your Name: ");
        String newName = input.nextLine();
        System.out.print("Enter your age: ");
        int newAge = input.nextInt();
        if(newAge<5) {
            System.out.println("You are not eligible to create a bank account.");
        }
        else{
            System.out.println("Congratulations, " + newName + "! Your account has been created.");
            System.out.println("Your Account number is: " + newAccountNumber);
        }
    }

    public void deposit() {
        System.out.println("Enter your Account Number: ");
        long accountNumber = input.nextLong();
        System.out.println("Enter your Amount:");
        long depositAmount = input.nextLong();

        if (accountNumber != newAccountNumber) {
            System.out.println("Please enter the correct Account Number.");
        } else {
            balance += depositAmount;
            System.out.println("Deposit successful.\nNew balance: " + balance);
        }
    }

    public void withdraw() {
        System.out.println("Enter your account number:");
        long withdrawAccount=input.nextLong();
        System.out.println("Enter your Amount to withdraw:");
        long withdrawAmount = input.nextLong();
        if (withdrawAccount !=newAccountNumber || withdrawAmount > balance) {
            System.out.println("Invalid withdrawal amount or account number.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful.\nNew balance: " + balance);
        }
    }

    public void transfer() {
        System.out.println("Enter the bank Account you want to transfer:");
        long transferAccount = input.nextLong();
        System.out.println("Enter amount:");
        long transferAmount = input.nextLong();

        if (transferAccount != 500122010066L) {
            System.out.println("Please enter a valid account number.");
        } else if (transferAmount > balance) {
            System.out.println("You don't have enough money to transfer.");
        } else {
            balance -= transferAmount;
            System.out.println("Transfer successful.\nNew balance: " + balance);
        }
    }
}
