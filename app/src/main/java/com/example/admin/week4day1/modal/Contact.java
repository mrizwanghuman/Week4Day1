package com.example.admin.week4day1.modal;

import java.io.StringBufferInputStream;

/**
 * Created by  Admin on 11/27/2017.
 */

public class Contact {
    String Id;
    String FirstName;
    String LastName;
    String MobileNumber;
    String HomeNumber;

    public Contact(String firstName, String lastName, String mobileNumber, String homeNumber) {
        FirstName = firstName;
        LastName = lastName;
        MobileNumber = mobileNumber;
        HomeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id='" + Id + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", MobileNumber='" + MobileNumber + '\'' +
                ", HomeNumber='" + HomeNumber + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return HomeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        HomeNumber = homeNumber;
    }

    public Contact(String id, String firstName, String lastName, String mobileNumber, String homeNumber) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        MobileNumber = mobileNumber;
        HomeNumber = homeNumber;
    }
}
