/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ligmabank;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Main
 */
public class BankDatabase {
     
    private static Map<String, Account> accounts = new HashMap<>();

    static {
        
        accounts.put("1001", new Account("Alice", 5000));
        accounts.put("1002", new Account("Bob", 3000));
        accounts.put("1003", new Account("Charlie", 10000));
    }

    public static double getBalance(String username) {
        // Find by username
        for (Account acc : accounts.values()) {
            if (acc.getName().equals(username)) {
                return acc.getBalance();
            }
        }
        return 0;
    }

    public static boolean accountExists(String accNum, String accName) {
        Account acc = accounts.get(accNum);
        return acc != null && acc.getName().equals(accName);
    }

    public static void withdraw(String username, double amount) {
        for (Account acc : accounts.values()) {
            if (acc.getName().equals(username)) {
                acc.setBalance(acc.getBalance() - amount);
                return;
            }
        }
    }

    public static void deposit(String accNum, double amount) {
        Account acc = accounts.get(accNum);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
        }
    }

    
    static class Account {
        private String name;
        private double balance;

        public Account(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        public String getName() { return name; }
        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }
    }
}
