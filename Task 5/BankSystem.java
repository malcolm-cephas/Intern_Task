import java.util.*;

class Account 
{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String accountHolder, double initialBalance) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposit successful! New Balance: " + balance);
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful! New Balance: " + balance);
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void showBalance() 
    {
        System.out.println("Current Balance: " + balance);
    }

    public void showTransactionHistory() 
    {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String record : transactionHistory) 
        {
            System.out.println("- " + record);
        }
    }
}

public class BankSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.println("Enter Account Holder Name: ");
        String holder = sc.nextLine();
        System.out.println("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        Account account = new Account(accNo, holder, balance);

        int choice;
        do 
        {
            System.out.println("\n===== Bank Operations Menu =====");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Show Balance");
            System.out.println("4: View Transaction History");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting Bank System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
