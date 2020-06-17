package com.revature.DAO;

import com.revature.models.EscapeRoom;

import java.util.List;

public interface EscapeRoomDAO {

    List<EscapeRoom> getAllEscapeRooms();
    List<EscapeRoom> getAllEscapeRoomsNoSout();

}
