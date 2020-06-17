package com.revature.models;

import java.io.Serializable;

public class Reservation implements Serializable {

    int reservationDate;
    String roomName;
    String gameMasterName;
    String managerName;
    String playerGroup;

    public Reservation(String roomName, int reservationDate, String gameMasterName, String managerName, String playerGroup) {

        this.reservationDate = reservationDate;
        this.roomName = roomName;
        this.gameMasterName = gameMasterName;
        this.managerName = managerName;
        this.playerGroup = playerGroup;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomName='" + roomName + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", gameMasterName ='" + gameMasterName + '\'' +
                ", managerName=' " + managerName + '\'' +
                ", playerGroup='" + playerGroup + '\'' + '}';

    }

    public int getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getGameMasterName() {
        return gameMasterName;
    }

    public void setGameMasterName(String gameMasterName) {
        this.gameMasterName = gameMasterName;
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
}