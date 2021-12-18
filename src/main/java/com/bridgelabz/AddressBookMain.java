package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
    public ArrayList<AddressBook_Contact> personDetails;
    PreparedStatement preparedStatement;
    Connection connection = AddressBook.getConnection();

    public List<AddressBook_Contact> executeQuery(String query) {
        personDetails = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AddressBook_Contact addressBookContacts = new AddressBook_Contact();
                addressBookContacts.setFirstName(resultSet.getString("FirstName"));
                addressBookContacts.setLastName(resultSet.getString("LastName"));
                addressBookContacts.setAddress(resultSet.getString("Address"));
                addressBookContacts.setLastName(resultSet.getString("City"));
                addressBookContacts.setAddress(resultSet.getString("State"));
                addressBookContacts.setZipCode(resultSet.getInt("ZipCode"));
                addressBookContacts.setMobileNumber(resultSet.getLong("MobileNumber"));

                personDetails.add(addressBookContacts);
            }

        } catch (SQLException sqlException) {
            throw new AddressBookException("Invalid Contact");
        }
        return personDetails;
    }

    public void displayAddressBook() {
        for (AddressBook_Contact i : personDetails) {
            System.out.println(i.toString());
        }
    }

    public int insertDate(int zipCode, String date) {
        String SqlDateUpdate = "update addressbook set Date=? where ZipCode=?";
        try {
            preparedStatement = connection.prepareStatement(SqlDateUpdate);
            preparedStatement.setDate(1, java.sql.Date.valueOf("2013-09-04"));
            preparedStatement.setInt(2, 123456);
            preparedStatement.executeUpdate();
            preparedStatement.setDate(1, java.sql.Date.valueOf("2000-02-05"));
            preparedStatement.setInt(2, 109876 );
            preparedStatement.executeUpdate();
            preparedStatement.setDate(1, java.sql.Date.valueOf("1996-12-30"));
            preparedStatement.setInt(2, 123);
            preparedStatement.executeUpdate();
            System.out.println("Date update successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlRead = "select count(FirstName) from addressbook where State=U";
        executeQuery(sqlRead);
        for (AddressBook_Contact addressBookContacts : personDetails) {
            {
                return addressBookContacts.getZipCode();
            }
        }
        return 0;
    }
}