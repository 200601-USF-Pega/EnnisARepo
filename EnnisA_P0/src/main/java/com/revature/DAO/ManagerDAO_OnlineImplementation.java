package com.revature.DAO;

import com.revature.models.GameMaster;
import com.revature.models.Reservation;
import com.revature.models.User;
import com.revature.services.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ManagerDAO_OnlineImplementation implements ManagerDAO{

    ConnectionService connectionService = ConnectionService.getInstance();

    //private static final Logger LOGGER = LogManager.getLogger(ManagerDAO_OnlineImplementation.class.getName());

    @Override
    public List<GameMaster> getAllGameMasters() {
        int index = 1;

        List<GameMaster> gameMasterList = new ArrayList<GameMaster>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM GameMasterList;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GameMaster gameMaster = new GameMaster(rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("managerName"));
                gameMasterList.add(gameMaster);
            }

            System.out.println("There are: " + gameMasterList.size() + " Users.");


            for (GameMaster gameMaster : gameMasterList) {

                System.out.println("[" + index+ "] " + gameMaster.toString());
                ++index;
            }
            //LOGGER.info("Logged the list of game masters.");
            return gameMasterList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public List<GameMaster> getAllGameMastersNoSout() {
        int index = 1;

        List<GameMaster> gameMasterList = new ArrayList<GameMaster>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM GameMasterList;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GameMaster gameMaster = new GameMaster(rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("managerName"));
                gameMasterList.add(gameMaster);
            }

            //LOGGER.info("Logged the list of game masters.");
            return gameMasterList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        int index = 1;

        List<Reservation> reservationList = new ArrayList<Reservation>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM ReservationList;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(rs.getString("roomName"),
                        rs.getInt("reservationDate"),
                        rs.getString("gameMasterName"),
                        rs.getString("managerName"),
                        rs.getString("playerGroup"),
                        rs.getInt("reservationId"));
                reservationList.add(reservation);
            }

            System.out.println("There are: " +reservationList.size() + " reservations.");


            for (Reservation reservation : reservationList) {

                System.out.println("[" + index+ "] " + reservation.toString());
                ++index;
            }
            //LOGGER.info("Logged the list of reservations.");
            return reservationList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservationsNoSout() {
        int index = 1;

        List<Reservation> reservationList = new ArrayList<Reservation>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM ReservationList;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(rs.getString("roomName"),
                        rs.getInt("reservationDate"),
                        rs.getString("gameMasterName"),
                        rs.getString("managerName"),
                        rs.getString("playerGroup"),
                        rs.getInt("reservationId"));
                reservationList.add(reservation);
            }
            //LOGGER.info("Logged the list of reservations.");
            return reservationList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        reservation.toString();

        try {

            List<Reservation> reservationList = this.getAllReservationsNoSout();

            reservationList.add(reservation);

            try {

                PreparedStatement ps = connectionService.getConnection().prepareStatement("INSERT INTO reservationList " +
                        "(roomName, reservationDate, gameMasterName, managerName, playerGroup) VALUES (?,?,?,?,?);");
                ps.setString(1, reservation.getRoomName());
                ps.setInt(2, reservation.getReservationDate());
                ps.setString(3, reservation.getGameMasterName());
                ps.setString(4, reservation.getManagerName());
                ps.setString(5, reservation.getPlayerGroup());
                ps.setInt(6, reservation.getReservationId());
                boolean success = ps.execute();

                return success;


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return true;

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println("Error Adding Reservation. Please ensure that you have the correct information.");
            return false;
        }

    }

    @Override
    public boolean updateReservation(int index) {

        return false;
    }

    @Override
    public boolean removeReservation(int reservationId) {

        String sqlDelete = "DELETE FROM reservationlist WHERE reservationId = ?";

        try {
            List<Reservation> reservationList = this.getAllReservationsNoSout();
            Reservation reservation = reservationList.get(reservationId - 1);

            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setString(1, reservation.getRoomName());
            preparedStatement.setInt(2, reservation.getReservationDate());
            preparedStatement.setString(3, reservation.getGameMasterName());
            preparedStatement.setString(4, reservation.getManagerName());
            preparedStatement.setString(5, reservation.getPlayerGroup());
            preparedStatement.setInt(6, reservation.getReservationId());
            boolean success = preparedStatement.execute();

            System.out.println("The reservation has been deleted.");
        return success;
        } catch (Exception e) {
            System.out.println("There is no reservation matching that ID.");


        }
        return false;

    }
}
