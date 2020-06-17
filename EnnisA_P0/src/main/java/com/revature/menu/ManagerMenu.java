package com.revature.menu;

import com.revature.DAO.*;
import com.revature.models.Reservation;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.logging.Logger;

public class ManagerMenu implements IMenu {

private static final Logger log = Logger.getLogger(MainMenu.class.getName());

    @Override
    public void menuStart() {

        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;


        Scanner sc = new Scanner(System.in);

        UserDAO_OnlineImplementation userDAO = null;
        EscapeRoomDAO_OnlineImplementation escapeRoomDAO = null;
        ManagerDAO managerDAO = null;

        String attemptPassword;
        String correctPassword = "ajisthebest";

        try {
            log.info("Created new Manager Data Access Object");
            managerDAO = new ManagerDAO_OnlineImplementation();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Welcome Manager");
        System.out.println("Please enter the manager password:");
        attemptPassword = sc.next();
        if (attemptPassword .contentEquals(correctPassword)) {
            System.out.println("That is correct!");

        System.out.println("What would you like to do?");
        while (true) {

            System.out.println("For a list of all escape rooms, please press [1]");
            System.out.println("For a list of all game masters, please press [2]");
            System.out.println("For a list of all users, please press [3]");
            System.out.println("For a list of all upcoming reservations, please press [4]");
            //System.out.println("To assign a game master to a reservation, please press [5]");
            //System.out.println("To remove a game master from a reservation, please press [6]");
            System.out.println("To create a new reservation, please press [5]");
            System.out.println("To remove a reservation, please press [6]");
            System.out.println("To return to the main menu, please press [0]");

//initializing variable
            int reservationDate;
            String gameMasterName;
            String roomName;
            String managerName;
            String playerGroup;
            int reservationId = 0;


            int nextMenu = sc.nextInt();

            switch (nextMenu) {

                case 1:
                    escapeRoomDAO.getAllEscapeRooms();
                    break;

                case 2:
                    managerDAO.getAllGameMasters();
                    break;

                case 3:
                    userDAO.getAllUsers();
                    break;

                case 4:
                    managerDAO.getAllReservations();
                    break;

                //case 5:
                //managerDAO.addGameMasterToReservation();
                //break;


                case 5:
                    managerDAO.getAllReservationsNoSout();

                    System.out.println("Please enter an escape room from the list: Framed, Rum Hangover, Ward 21 or Smoke and Mirrors");
                    roomName = sc.next();

                    System.out.println("Please enter the date of the reservation in this format (DDMMYYYY): ");
                    reservationDate = sc.nextInt();

                    System.out.println("Please enter a select an available game master from this list: Buddy, Friend, Pal or Steve");
                    gameMasterName = sc.next();

                    System.out.println("Please select a manager: Aj or Jab");
                    managerName = sc.next();

                    System.out.println("Please enter the group name of the client: ");
                    playerGroup = sc.next();

                    Reservation reservation = new Reservation(roomName, reservationDate, gameMasterName, managerName, playerGroup, reservationId);
                    System.out.println("Here are the details of your new escape room reservation: " + reservation.toString());

                    managerDAO.addReservation(reservation);

                    break;

                case 6:

                    managerDAO.getAllReservations();


                    System.out.println("Please enter the reservation ID of the reservation you would like to cancel: ");
                    reservationId = sc.nextInt();

                    managerDAO.removeReservation(reservationId);
                    break;

                case 0:
                    newMenu = menuFactory.getMenu("MainMenu");
                    newMenu.menuStart();
                    break;

                default:
                    System.out.println("Please select from one of the options given");
                    continue;
            }


            }
               }else {
            System.out.println("That is not the correct password, you will be returned to the main menu.");
            newMenu = menuFactory.getMenu("MainMenu");
            newMenu.menuStart();
        }

}

}
