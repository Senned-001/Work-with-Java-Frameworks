package com.jdbc;

import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "кщще";
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL?useSSL=false";

    public static void main(String[] args) {
        Connection connection = null;
        Driver driver;

        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("insert into buisness.products (product_name, price, shop_id)values (\"disks\", 45, 1)");
            System.out.println("Insert complited");
            int n = statement.executeUpdate("update buisness.products set product_name = \"Snickers\" where product_id = 6");
            System.out.println(n + " strings was updated");
            statement.addBatch("insert into buisness.products (product_name, price, shop_id)values (\"pasta\", 47, 3)");
            statement.addBatch("insert into buisness.products (product_name, price, shop_id)values (\"water\", 50, 2)");
            statement.executeBatch();
            statement.clearBatch();
            ResultSet resultSet= statement.executeQuery("select * from buisness.products");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
