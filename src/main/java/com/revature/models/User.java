package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {



    int userId;
    String userName;
    String firstName;
    String lastName;
    String passcode;
    int familyId;

    public User(int userId, String userName, String firstName, String lastName, String passcode, int familyId) {

        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
        this.familyId = familyId;
    }
    @Override
    public String toString() {
        return "User{" +
                "UserId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=' " + lastName + '\'' +
               ", passcode='" + passcode + '\'' +
                " familyId=" + familyId + '\'' + '}';

    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
   }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }


}

