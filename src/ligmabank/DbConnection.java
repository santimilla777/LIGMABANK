/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ligmabank;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Main
 */
public class DbConnection {
     public static Connection getConnection() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lbank";
            String user = "root";    
            String password = "";    
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
