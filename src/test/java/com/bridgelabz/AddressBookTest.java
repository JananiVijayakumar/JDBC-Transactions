package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
    AddressBookMain addressBookMain = new AddressBookMain();
    @Test
    public void givenDateHasBeenUpdated(){
        int ZipCode = 123456;
        String Date = "2013-09-04";
        int dateInserted = addressBookMain.insertDate(ZipCode, Date);
        Assert.assertEquals(ZipCode, dateInserted);
    }
}
