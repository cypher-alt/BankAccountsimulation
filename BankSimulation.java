import java.util.*;

class Account {
    String accountHolderName;
    int accountNumber;
    double balance;
    List<String> transactionHistory;

    public Account(String name, int accNum) {
        this.accountHolderName = name;
        this.accountNumber = accNum;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

class SavingsAccount extends Account {
    final double minBalance = 500;

    public SavingsAccount(String name, int accNum) {
        super(name, accNum);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Maintain min balance ₹" + minBalance);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        SavingsAccount acc1 = new SavingsAccount("Aditya", 1001);
        acc1.deposit(2000);
        acc1.withdraw(300);
        acc1.withdraw(1300);  // should not allow
        acc1.displayBalance();
        acc1.printTransactionHistory();
    }
}
