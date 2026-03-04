/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ligmabank;
import java.sql.*;
/**
 *
 * @author Main
 */
public class DBHelper {
     private static final String URL = "jdbc:mysql://localhost:3306/lbank";
    private static final String USER = "root"; //
    private static final String PASS = ""; //

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    
    public static void logTransaction(String username, String type, double amount) throws SQLException {
    String query = "INSERT INTO transactions(username, type, amount) VALUES (?, ?, ?)";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, username);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.executeUpdate();
    }
}
    
    
    
    
    
    
    
    
    // Get balance para smooth
    public static double getBalance(String username) throws SQLException {
        String query = "SELECT balance FROM register WHERE username=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            return 0;
        }
    }

    // Check if account mo drix nag-eexist
    public static boolean accountExists(String accNum, String accName) throws SQLException {
        String query = "SELECT * FROM register WHERE account_no =? AND username =?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, accNum);
            ps.setString(2, accName);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    // Withdraw money here
   public static void withdraw(String username, double amount) throws SQLException {
    String query = "UPDATE register SET balance = balance - ? WHERE username=?";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setDouble(1, amount);
        ps.setString(2, username);
        ps.executeUpdate();
    }
}

// Deposit money
public static void deposit(String accNum, double amount) throws SQLException {
    String query = "UPDATE register SET balance = balance + ? WHERE account_no=?";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setDouble(1, amount);
        ps.setString(2, accNum);
        ps.executeUpdate();
    }
}
    }
   
