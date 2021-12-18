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

        public void displayAddressBook () {
            for (AddressBook_Contact i : personDetails) {
                System.out.println(i.toString());
            }
        }
        public int updateLastName(String lastName, int zipCode){
            String SqlUpdate = "UPDATE addressbook SET ZipCode = ? WHERE LastName = ?";
            try {
                preparedStatement = connection.prepareStatement(SqlUpdate);
                preparedStatement.setInt(1,zipCode );
                preparedStatement.setString(2,lastName );
                preparedStatement.executeUpdate();
                System.out.println("update successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sqlSelect = "SELECT * FROM addressbook";
            executeQuery(sqlSelect);
            for (AddressBook_Contact addressBookContacts : personDetails) {
                if (addressBookContacts.getFirstName().equals(lastName)) {
                    return addressBookContacts.getZipCode();
                }
            }
            return 0;
        }
    }