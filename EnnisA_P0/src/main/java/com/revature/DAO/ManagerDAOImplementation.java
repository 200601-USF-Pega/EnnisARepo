package com.revature.DAO;

import com.revature.models.GameMaster;
import com.revature.models.Manager;
import com.revature.models.Reservation;
import com.revature.models.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAOImplementation implements ManagerDAO {

    List<Manager> managerList = new ArrayList<Manager>();
    List<Reservation> reservationList = new ArrayList<Reservation>();

    String filepath = "C:/Users/ajemo/IdeaProjects/EscapeRoomManagement/src/main/java/com/revature/output/ManagerData.txt";

    public ManagerDAOImplementation() throws IOException {

    }

    @Override
    public List<GameMaster> getAllGameMasters() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<GameMaster> gameMasterList = (List<GameMaster>) objectInputStream.readObject();
            System.out.println("Got the list");
            objectInputStream.close();

            System.out.println("There are: " + gameMasterList.size() + " game masters.");
            for (GameMaster gameMaster : gameMasterList) {

                System.out.println(gameMaster.toString());
            }

            return gameMasterList;

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
    public List<GameMaster> getAllGameMastersNoSout() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<GameMaster> gameMasterList = (List<GameMaster>) objectInputStream.readObject();
            objectInputStream.close();

            return gameMasterList;

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
    public List<Reservation> getAllReservations() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<Reservation> reservationList = (List<Reservation>) objectInputStream.readObject();
            System.out.println("Got the list");
            objectInputStream.close();

            System.out.println("There are: " + reservationList.size() + " reservations.");
            for (Reservation reservation : reservationList) {

                System.out.println(reservation.toString());
            }

            return reservationList;

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
    public List<Reservation> getAllReservationsNoSout() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<Reservation> reservationList = (List<Reservation>) objectInputStream.readObject();
            objectInputStream.close();


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
    public boolean addReservation(Reservation reservation) {

        reservation.toString();

        try {
            try {
                reservationList = this.getAllReservationsNoSout();
            } catch (Exception e) {

            }

            reservationList.add(reservation);

            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
                objectOutputStream.writeObject(reservationList);
                System.out.println("Reservation Booked! Please confirm details with your Game Masters.");
                objectOutputStream.close();

            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }

            return true;

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println("Error! incorrect data entered");
            return false;

                    }


    }

    @Override
    public boolean updateReservation(int index) {
        return false;
    }

    @Override
    public boolean removeReservation(int reservationId) {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath));
            List<Reservation> reservationList = (List<Reservation>) objectInputStream.readObject();
            objectInputStream.close();

            for (Reservation reservation : reservationList) {

                if (reservation.getReservationId() == (reservationId)) {
                    reservationList.remove(reservation);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
                    System.out.println("Reservation removed! Please confirm details with your Game Masters and Players.");
                    objectOutputStream.writeObject(reservationList);
                    objectOutputStream.close();
                    return true;
                }


            }
            return false;
        } catch (Exception e) {

            return false;
        }
    }
}
