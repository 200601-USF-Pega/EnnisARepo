package com.revature.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class User implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    private String userName;
    private String firstName;
    private String lastName;
    private String passcode;
    private int familyid;


    /*------------------------------------------------------------------------------*/
    /* Constructors */
    /*------------------------------------------------------------------------------*/

    public User(String userName, String firstName, String lastName, String passcode, int familyid) {
        LOGGER.info("New User Created: " + userName + " " + firstName + " " + lastName + " " + passcode + " " + familyid);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
        this.familyid = familyid;
    }


    public User() {

    }

    /*------------------------------------------------------------------------------*/
    /* toString */
    /*------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passcode='" + passcode + '\'' +
                ", familyid=" + familyid +
                '}';
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

    public int getFamilyid() {
        return familyid;
    }

    public void setFamilyid(int familyid) {
        this.familyid = familyid;
    }

}


