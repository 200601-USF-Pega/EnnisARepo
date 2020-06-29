package com.revature.models;

import com.revature.services.ConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;


public class Reservation implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(Reservation.class.getName());

    String roomName;
    String gameMaster;
    String managerName;
    String playerGroup;
    int reservationDate;
    int reservationID;

    public Reservation(String roomName, int reservationDate, String gameMaster, String managerName, String playerGroup) {
        LOGGER.info("New Reservation: " + roomName + " " + reservationDate + " " + gameMaster + " " + managerName +  " " + playerGroup);
        this.roomName = roomName;
        this.reservationDate = reservationDate;
        this.gameMaster = gameMaster;
        this.managerName = managerName;
        this.playerGroup = playerGroup;
    }

    public Reservation(){

    }

    /*------------------------------------------------------------------------------*/
    /* ToString */
    /*------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Reservation{" +
                "roomName='" + roomName + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", gameMaster='" + gameMaster + '\'' +
                ", managerName='" + managerName + '\'' +
                ", playerGroup=" + playerGroup +
                '}';
    }

    /*------------------------------------------------------------------------------*/
    /* Getters and Setters  */
    /*------------------------------------------------------------------------------*/

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(String gameMaster) {
        this.gameMaster = gameMaster;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(String playerGroup) {
        this.playerGroup = playerGroup;
    }

    public int getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}
