package com.jdbc;

import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "кщще";
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL?useSSL=false";

    public static void main(String[] args) {
        //first method - work with data base directly
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
            statement.close();
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

        //second method - work with data base with classes
        String query = "select * from buisness.products";
        String insert = "insert into buisness.products (product_name, price, shop_id) values (?, ?, ?)";
        try {
            DBProcessor db = new DBProcessor();
            Connection con = db.getConnection(URL, USERNAME, PASSWORD);
            //insert in table from class with PreparedStatement
            Product product2 = new Product(9, "Eggs",44,1);
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, product2.getName());
            ps.setDouble(2, product2.getPrice());
            ps.setInt(3, product2.getShopID());
            ps.execute();

            //select from table to new class
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                int id = result.getInt("product_id");
                String name = result.getString("product_name");
                double price = result.getDouble("price");
                int shopID = result.getInt("shop_id");
                Product product = new Product(id, name, price, shopID);
                System.out.println(product.toString());
            }

            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
