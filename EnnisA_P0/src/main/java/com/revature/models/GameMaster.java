package com.revature.models;

import java.io.Serializable;

public class GameMaster implements Serializable {

    String firstName;
    String lastName;
    String managerName;

    public GameMaster(String firstName, String lastName, String managerName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerName = managerName;

    }

    public String toString(){
        return "GameMaster{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName +'\'' +
                ", managerName='" + managerName + '}';

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}

