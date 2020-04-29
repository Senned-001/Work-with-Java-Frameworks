package filmography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//for check connection to DB
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/filmography?serverTimezone=UTC&useSSL=false";//ignore timezone and ssl-protocol
        String username = "filmography";
        String password = "film";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

