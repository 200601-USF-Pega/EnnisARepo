package com.revature.dao;

import com.revature.models.*;
import com.revature.models.Reservation;
import com.revature.services.ConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImplementation implements ReservationDAO{

    ConnectionService connectionService = ConnectionService.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(ReservationDAOImplementation.class.getName());


    @Override
    public List<Reservation> getAllReservations() {
        int indexNum = 1;

        List<Reservation> reservationList = new ArrayList<Reservation>();
        LOGGER.info("Attempting to get a list of all Reservations.");


        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM reservationlist;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                //Gets the data from the specified columns and uses them as parameters to create a new Reservation
                Reservation reservation = new Reservation(rs.getString("roomName"), rs.getInt("reservationDate"),rs.getString("gameMasterName"),rs.getString("managerName"), rs.getString("playerGroup"));
                //Adds the new reservation to the reservationList Array
                reservationList.add(reservation);
            }

            System.out.println("Currently are: " + reservationList.size() + " Reservations.");



            for (Reservation reservation : reservationList) {

                System.out.println("["+indexNum+ "] " + reservation.toString());
                ++indexNum;
            }
            LOGGER.info("Successfully returned a list of all Reservations.");
            return reservationList;
        }catch(SQLException e){
            LOGGER.error("Error getting a list of all Reservations.");
            e.printStackTrace();

        } catch (Exception e){
            LOGGER.error("Error Returning a list of all Reservations.");

        }
        LOGGER.error("Returning a null list of all Reservations.");

        return null;
    }


    private List<Reservation> getAllReservationsNoPrint() {
        int indexNum = 1;

        //Instantiate a new ArrayLists of Reservations
        List<Reservation> reservationList = new ArrayList<Reservation>();

        try {
            LOGGER.info("Attempting to get a list of all Reservations.");
            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM reservationlist;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                //Gets the data from the specified columns and uses them as parameters to create a new Reservation
                Reservation reservation = new Reservation(rs.getString("roomName"), rs.getInt("reservationDate"),rs.getString("gameMasterName"),rs.getString("managerName"), rs.getString("playerGroup"));
                //Adds the new reservation to the reservationList Array
                reservationList.add(reservation);
            }
            LOGGER.info("Successfully returned a list of all Reservations.");

            return reservationList;
        }catch(SQLException e){
            LOGGER.error("Error getting a list of all Reservations.");

            e.printStackTrace();

        } catch (Exception e){
            LOGGER.error("Error getting a list of all Reservations.");

        }
        LOGGER.error("Returning a null list of all Reservations.");

        return null;
    }




    @Override
    public boolean addReservation(Reservation reservation) {
        LOGGER.info("Attempting to add a Reservation.");

        reservation.toString();
        try {

            List<Reservation> reservationList = this.getAllReservationsNoPrint();

            reservationList.add(reservation);

            try{
                LOGGER.info("Inserting Reservation into database.");

                PreparedStatement ps = connectionService.getConnection().prepareStatement("INSERT INTO reservationlist (roomname, reservationdate, gamemastername, managername, playergroup) VALUES (?,?,?,?,?);");
                ps.setString(1, reservation.getRoomName());
                ps.setInt(2, reservation.getReservationDate());
                ps.setString(3, reservation.getGameMaster());
                ps.setString(4, reservation.getManagerName());
                ps.setString(5, reservation.getPlayerGroup());
                boolean didWork = ps.execute();
                LOGGER.info("Successfully Added a Reservation.");

                return didWork;


            }catch (SQLException e){
                LOGGER.error("Error Adding Reservation.");

                e.printStackTrace();
            }


            return true;

        } catch(Exception e){
            System.out.println(e.getStackTrace());
            LOGGER.error("Error Adding Reservation.");

            System.out.println("Error Adding Reservation. Please Check your inputs.");
            return false;
        }

    }
    

    @Override
    public boolean removeReservation(int indexNum) {
        LOGGER.info("Attempting to remove a Reservation.");

        try {
            LOGGER.info("Deleting Reservation from the database.");

            List<Reservation> reservationList = this.getAllReservationsNoPrint();
            Reservation reservation = reservationList.get(indexNum - 1);

            //If both the Reservation's First and Last Name equals to what was inputted the Reservation is deleted.
            PreparedStatement ps = connectionService.getConnection().prepareStatement("DELETE FROM reservationlist as r WHERE r.roomname = ? AND r.reservationdate = ? AND r.playergroup = ?;");
            ps.setString(1, reservation.getRoomName());
            ps.setInt(2, reservation.getReservationDate());
            ps.setString(3, reservation.getPlayerGroup());
            boolean didWork = ps.execute();
            System.out.println("Deleted: " + reservation.toString());
            LOGGER.info("Successfully Removed a Reservation.");

            return didWork;




        } catch(Exception e){
            LOGGER.info("Error Removed a Reservation.");

            System.out.println("No Reservation exists with that name.");
            return false;
        }



    }

    @Override
    public boolean updateReservation(int indexNum, Reservation newReservation) {
        LOGGER.info("Attempting to Update a Reservation.");

        List<Reservation> reservationList = this.getAllReservationsNoPrint();
        Reservation reservation = reservationList.get(indexNum);


        try {
            //If both the Reservation's First and Last Name equals to what was inputted the Reservation is deleted.
            PreparedStatement ps = connectionService.getConnection().prepareStatement("UPDATE reservationlist as r SET roomname = ?, reservationdate = ?, gamemastername = ?, managername = ?, playergroup = ? WHERE r.roomname = ? AND r.reservationdate = ? AND r.gamemastername = ? AND r.managername = ? AND r.playergroup = ?;");
            ps.setString(1, newReservation.getRoomName());
            ps.setInt(2, newReservation.getReservationDate());
            ps.setString(3, newReservation.getGameMaster());
            ps.setString(4, newReservation.getManagerName());
            ps.setString(5, newReservation.getPlayerGroup());
            ps.setString(6, reservation.getRoomName());
            ps.setInt(7, reservation.getReservationDate());
            ps.setString(8, reservation.getGameMaster());
            ps.setString(9, reservation.getManagerName());
            ps.setString(10, reservation.getPlayerGroup());

            boolean didWork = ps.execute();
            System.out.println("UPDATED: " + reservation.toString());
            LOGGER.info("Successful Updating a Reservation.");

            return didWork;

        }catch(SQLException e){
            LOGGER.info("Error Updating Reservations from the database.");

        }
        LOGGER.info("Error Updating Reservations from the database.");

        return false;

    }



}
