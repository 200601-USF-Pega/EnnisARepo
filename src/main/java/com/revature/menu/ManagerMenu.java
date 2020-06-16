package com.revature.menu;

import com.revature.DAO.EscapeRoomDAO_OnlineImplementation;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAO_OnlineImplementation;

import java.util.Scanner;

public class ManagerMenu implements IMenu {


    @Override
    public void menuStart() {

        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;


        Scanner sc = new Scanner(System.in);

        UserDAO_OnlineImplementation userDAO = null;
        EscapeRoomDAO_OnlineImplementation escapeRoomDAO = null;
        ManagerDAO managerDAO = null;

        try {

            managerDAO = new ManagerDAO_OnlineImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Welcome Manager, what would you like to do?");

        while (true) {

            System.out.println("For a list of all escape rooms, please press [1]");
            System.out.println("For a list of all game masters, please press [2]");
            System.out.println("For a list of all users, please press [3]");
            System.out.println("For a list of all upcoming reservations, please press [4]");
            System.out.println("To assign a game master to a reservation, please press [5]");
            System.out.println("To remove a game master from a reservation, please press [6]");
            System.out.println("To create a new reservation, please press [7]");
            System.out.println("To return to the main menu, please press [0]");

//initializing variable
            int reservationDate;
            int accountId;
            int roomId;
            int invoiceNumber;
            int managerId;
            String familyName;
            int gameMasterId;
            String passcode;

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

                case 5:
                    managerDAO.addGameMasterToReservation();
                    break;

                case 6:
                    managerDAO.removeGameMasterFromReservation();
                    break;

                case 7:
                    managerDAO.getAllReservations();

                    System.out.println("Please enter the invoice number: ");
                    invoiceNumber = sc.nextInt();

                    System.out.println("Please select an escape room");
                    System.out.println("[1] for Framed");
                    System.out.println("[2] for Rum Hangover");
                    System.out.println("[3] for Ward 21");
                    System.out.println("[4] for Smoke and Mirrors");
                    roomId = sc.nextInt();

                    System.out.println("Please enter the date of the reservation in this format (DDMMYYYY): ");
                    reservationDate = sc.nextInt();

                    System.out.println("Please select a game master: ");
                    System.out.println("[11] for Buddy");
                    System.out.println("[12] for Friend");
                    System.out.println("[13] for Pal");
                    System.out.println("[14] for Steve");
                    gameMasterId = sc.nextInt();

                    System.out.println("Please enter your Manager ID: ");
                    System.out.println("[1] for Aj, [2] for Jab");
                    managerId = sc.nextInt();

                    System.out.println("Please enter the account ID of the client: ");
                    accountId = sc.nextInt();

                    Reservation reservation = new Reservation(invoiceNumber, roomid, reservationDate, gameMasterId, managerId, accountId);
                    System.out.println("Here are the details of your new escape room reservation: " + reservation.toString());

                    reservationDAO.addReservation(reservation);

                    break;

                case 0:
                    newMenu = menuFactory.getMenu("MainMenu");
                    newMenu = menuStart();
                    break;

                default:
                    System.out.println("Please select from one of the options given");
                    continue;

            }
        }
}

}
