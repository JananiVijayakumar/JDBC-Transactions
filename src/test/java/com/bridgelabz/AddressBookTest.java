package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
    AddressBookMain addressBookMain = new AddressBookMain();
    @Test
    public void givenDataHasBeenUpdated(){
        int ZipCode = 123456;
        String LastName = "Jin";
        int salaryUpdated = addressBookMain.updateLastName(LastName, ZipCode);
        Assert.assertEquals(ZipCode, salaryUpdated,345678);
    }
}
