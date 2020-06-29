package com.revature.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class GameMaster implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(GameMaster.class.getName());


    private String firstname;
    private String lastname;
    private String managername;


    public GameMaster(String firstname, String lastname, String managername) {
        LOGGER.info("New Game Master Created: " + firstname + " " + lastname + " " + managername);
        this.firstname = firstname;
        this.lastname = lastname;
        this.managername = managername;

    }


    @Override
    public String toString() {
        return "GameMaster{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", managername=" + managername +
                '}';
    }



    /*------------------------------------------------------------------------------*/
                            /* Getters and Setters  */
    /*------------------------------------------------------------------------------*/
    public String getFirstname() {

        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {

        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }


}
