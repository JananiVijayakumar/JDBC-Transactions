package com.bridgelabz;

import java.sql.*;

public class AddressBook_Service {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/address_book";
        String uname = "root";
        String pass = "Vkumar@47";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, uname, pass);
            if (connection != null) {
                System.out.println("Connected!");
            }
            Statement readStatement = connection.createStatement();
            String sqlInsert = "INSERT INTO AddressBook (FirstName, LastName, Address, City, State, ZipCode, MobileNumber) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, "Jungkook");
            statement.setString(2, "Jeon");
            statement.setString(3, "ABC");
            statement.setString(4, "M");
            statement.setString(5, "U");
            statement.setInt(6, 123456);
            statement.setLong(7, 1234567890);
            statement.execute();
            statement.setString(1, "Jimin");
            statement.setString(2, "kim");
            statement.setString(3, "QWE");
            statement.setString(4, "F");
            statement.setString(5, "H");
            statement.setInt(6, 109876);
            statement.setLong(7, 1234567890);
            statement.execute();
            statement.setString(1, "RM");
            statement.setString(2, "Jin");
            statement.setString(3, "REQ");
            statement.setString(4, "C");
            statement.setString(5, "E");
            statement.setInt(6, 129876);
            statement.setLong(7, 1123467890);
            statement.execute();
            boolean rowsInserted = statement.execute();
            if (rowsInserted) {
                System.out.println("Row or data added successfully!!");
            }
            String sqlInsert1 = "INSERT INTO AddressBook (FirstName, LastName, Address, City, State, ZipCode, MobileNumber) values ('Tae Hyung', 'Kim', 'xyz', 'A', 'S', '123', '1234567890' )";
            int insertValue = readStatement.executeUpdate(sqlInsert1);
            if(insertValue > 0){
                System.out.println(" Contact details Insert Sucessfully!!");
            }
            String sqlRead = "SELECT * FROM AddressBook";
            ResultSet resultSet = readStatement.executeQuery(sqlRead);
            while(resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String state = resultSet.getString("State");
                int zipCode = resultSet.getInt("ZipCode");
                long mobileNumber = resultSet.getLong("MobileNumber");
                System.out.println(firstName + " | " + lastName + " | "+ address + " | "+ city + " | "+state + " | "+zipCode + " | "+mobileNumber);
            }
            connection.setAutoCommit(false);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
