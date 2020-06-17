package com.revature.DAO;

import com.revature.models.EscapeRoom;

import java.util.List;

public interface EscapeRoomDAO {

    public List<EscapeRoom> getAllEscapeRooms();
    public List<EscapeRoom> getAllEscapeRoomsNoSout();

}
