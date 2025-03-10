import java.util.*;

class BankAccount {
    private String accountId;
    private String owner;
    private int balance;

    public BankAccount(String accountId, String owner, int balance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(
            "123456",
            "John Doe",
            1000
        );

        System.out.println(bankAccount.getBalance());
        bankAccount.setBalance(2000);
        System.out.println(bankAccount.getBalance());
        System.out.println("\n");
        System.out.println(bankAccount.getOwner());
        bankAccount.setOwner("Jane Doe");
        System.out.println(bankAccount.getOwner());
    }
}