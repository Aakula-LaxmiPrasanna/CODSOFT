

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) 
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public boolean withdraw(double amount) 
    {
        if (balance >= amount)
        {
            balance -= amount;
            return true;
        } else
        {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void withdraw(double amount)
    {
        if (account.withdraw(amount))
        {
            System.out.println("Withdraw successful, Remaining balance: $" + account.getBalance());
        } else 
        {
            System.out.println("Dont have sufficient amount to withdrawal.");
        }
    }

    public void deposit(double amount) 
    {
        account.deposit(amount);
        System.out.println("Deposit successful. Balance after deposit is : $" + account.getBalance());
    }

    public void checkBalance() 
    {
        System.out.println("Your current bank balance is: $" + account.getBalance());
    }
}

public class ATMInterface 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(10000.0);

        ATM atm = new ATM(userAccount);

        while (true) 
        {
            System.out.println("Welcome to the ATM interface.");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you. Visit Again");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }
}