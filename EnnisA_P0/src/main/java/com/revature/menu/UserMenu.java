package com.revature.menu;

import com.revature.DAO.EscapeRoomDAO_OnlineImplementation;
import com.revature.DAO.UserDAO_OnlineImplementation;
import com.revature.models.User;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserMenu implements IMenu {

    private static final Logger log = Logger.getLogger(MainMenu.class.getName());

    @Override
    public void menuStart() {

        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;

        Scanner sc = new Scanner(System.in);

        EscapeRoomDAO_OnlineImplementation escapeRoomDAO = null;
        UserDAO_OnlineImplementation userDAO = null;

        try {
            log.info("Created new User Data Access Object");
        userDAO = new UserDAO_OnlineImplementation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Welcome Player, what would you like to do?");

        while (true) {

           // System.out.println("For a list of escape rooms available, please press [1]");
            System.out.println("To add a user to your account, please press [1]");
            //System.out.println("To reserve an escape room experience, please press [3]");
           //System.out.println("To check your current reservations, please press [4]");
            //System.out.println("To cancel a reservation, please press [5]");
            System.out.println("To return to the previous menu, please press [0]");

            //initializing variables
            int userId = 0;
            int familyId = 0;
            String userName;
            String firstName;
            String lastName;
            String passcode;

            //switching menus
            int nextMenu = sc.nextInt();

            switch (nextMenu) {
                //case 1:
                   // escapeRoomDAO.getAllEscapeRooms();
                    //break;

                case 1:
                    System.out.println("Please enter the new user's username:");
                    userName = sc.next();

                    System.out.println("Please enter the new user's password:");
                    passcode = sc.next();

                    System.out.println("Please enter the new user's first name:");
                    firstName = sc.next();

                    System.out.println("Please enter the new user's last name:");
                    lastName = sc.next();

                    System.out.println("Please enter your Escape Room Family Id");
                    familyId = sc.nextInt();



                    User user = new User(userId, userName, passcode, firstName, lastName, familyId);

                    System.out.println("Added: " + user.toString());

                    userDAO.addUser(user);

                    break;

                case 0:
                    newMenu = menuFactory.getMenu("MainMenu");
                    newMenu.menuStart();
                    break;

                default:
                    System.out.println("Please Enter one of the options");
                    continue;
            }

        }
    }
}
