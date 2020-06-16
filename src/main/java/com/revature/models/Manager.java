package com.revature.models;

import java.io.Serializable;

public class Manager implements Serializable {



    int managerId;
    String firstName;
    String lastName;

    public Manager(int managerId, String firstName, String lastName) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
        public String toString() {
            return "Manager{" +
                    "managerId='" + managerId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName=" + lastName + '\'' + '}';


        }

            public int getManagerId() {
                return managerId;
            }

            public void setManagerId(int managerId) {
                this.managerId = managerId;
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
}


