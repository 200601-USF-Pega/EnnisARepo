package com.revature.DAO;

import com.revature.models.EscapeRoom;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class EscapeRoomDAOImplementation implements EscapeRoomDAO {

    List<EscapeRoom> escapeRoomList = new ArrayList<EscapeRoom>();

    String filepath = "C:/Users/ajemo/IdeaProjects/EscapeRoomManagement/src/main/java/com/revature/output/EscapeRoomData.txt";

    public EscapeRoomDAOImplementation() throws IOException {
    }

    @Override
    public List<EscapeRoom> getAllEscapeRooms() {


        try{
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<EscapeRoom> escapeRoomList = (List<EscapeRoom>)objectInputStream.readObject();
            System.out.println("Got the list");
            objectInputStream.close();

            System.out.println("There are: " + escapeRoomList.size() + " Escape Rooms.");
            for (EscapeRoom escapeRoom: escapeRoomList) {

                System.out.println(escapeRoom.toString());
            }

            return escapeRoomList;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class Not found");
        }


        return null;

    }
    @Override
    public List<EscapeRoom> getAllEscapeRoomsNoSout() {


        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<EscapeRoom> escapeRoomList = (List<EscapeRoom>)objectInputStream.readObject();
            objectInputStream.close();

            return escapeRoomList;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class Not found");
        }


        return null;
    }
}
