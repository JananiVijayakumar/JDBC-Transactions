package com.bridgelabz;

import java.sql.*;

public class AddressBook {
    public static Connection getConnection(){
        String dbURL = "jdbc:mysql://localhost:3306/address_book";
        String uname = "root";
        String pass = "Vkumar@47";
        Connection connection=null;

        try {
            connection = DriverManager.getConnection(dbURL, uname, pass);
            if (connection != null) {
                System.out.println("Connected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
