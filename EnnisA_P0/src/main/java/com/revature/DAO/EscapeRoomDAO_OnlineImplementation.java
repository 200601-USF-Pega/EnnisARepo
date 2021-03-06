package com.revature.DAO;

import com.revature.models.EscapeRoom;
import com.revature.services.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscapeRoomDAO_OnlineImplementation implements EscapeRoomDAO {

    ConnectionService connectionService = ConnectionService.getInstance();


    @Override
    public List<EscapeRoom> getAllEscapeRooms() {
        int index = 1;

        List<EscapeRoom> escapeRoomList = new ArrayList<EscapeRoom>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM EscapeRoomList;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EscapeRoom escapeRoom = new EscapeRoom(rs.getString("roomName"),
                        rs.getString("roomDifficulty"));
                escapeRoomList.add(escapeRoom);
            }

            System.out.println("There are: " + escapeRoomList.size() + " Escape Rooms.");


            for (EscapeRoom escapeRoom : escapeRoomList) {

                System.out.println("[" + index+ "] " + escapeRoom.toString());
                ++index;
            }
            return escapeRoomList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public List<EscapeRoom> getAllEscapeRoomsNoSout() {

        List<EscapeRoom> escapeRoomList = new ArrayList<EscapeRoom> ();
        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM EscapeRooms;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                EscapeRoom escapeRoom = new EscapeRoom(rs.getString("RoomName"),
                        rs.getString("RoomDifficulty"));
                escapeRoomList.add(escapeRoom);
            }

            return escapeRoomList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }

        return null;
    }


}
