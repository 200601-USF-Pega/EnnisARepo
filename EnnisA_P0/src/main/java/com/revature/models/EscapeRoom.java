package com.revature.models;

import java.io.Serializable;

public class EscapeRoom implements Serializable {

    String roomName;
    String roomDifficulty;

    public EscapeRoom(String roomName, String roomDifficulty) {

        this.roomName = roomName;
        this.roomDifficulty = roomDifficulty;
    }
    @Override
    public String toString(){
        return "EscapeRoom{" +
                "roomName='" + roomName + '\'' +
                ", roomDifficulty='" + roomDifficulty + '\'' + '}';

    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDifficulty() {
        return roomDifficulty;
    }

    public void setRoomDifficulty(String roomDifficulty) {
        this.roomDifficulty = roomDifficulty;
    }

}
