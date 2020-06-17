package com.revature.menu;

import com.revature.DAO.UserDAO_OnlineImplementation;
import com.revature.models.User;

import java.util.Scanner;
import java.util.SortedMap;

public class MainMenu  implements  IMenu {

    @Override
    public void menuStart() {



        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;

        //Scanner for user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Escape Room Reservation App!");
        System.out.println("What would you like to do?");
        //repeating while loop for menu options
        while (true) {
            System.out.println("For the Player menu press [1]");
            System.out.println("For Manager menu press [2]");
            System.out.println("If you are a new user press [3]");
            System.out.println("Press [0] to exit the App");

            //Menu Switching
            int nextMenu = sc.nextInt();

            switch (nextMenu) {

                case 1:
                    newMenu = menuFactory.getMenu("Users");
                    newMenu.menuStart();
                    break;

                case 2:
                    newMenu = menuFactory.getMenu("Managers");
                    newMenu.menuStart();
                    break;

                case 3:
                    UserDAO_OnlineImplementation userDAO = null;

                    try {
                        userDAO = new UserDAO_OnlineImplementation();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String userName;
                    String firstName;
                    String lastName;
                    String passcode;
                    int familyId;
                    int validation;


                        System.out.println("Welcome New User");
                        System.out.println("Please create a username: ");
                        userName = sc.next();

                        System.out.println("Please enter your first name: ");
                        firstName = sc.next();

                        System.out.println("Please enter your last name: ");
                        lastName = sc.next();

                        System.out.println("Please create your password: ");
                        passcode = sc.next();


                    do {
                        System.out.println("If you know your Escape Room family Id please enter it now, if not please enter 0");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid Escape Room family ID! Family IDs range from 1-3");
                            sc.next();
                        }
                        validation = sc.nextInt();
                    } while (validation < 0 || validation > 3);
                    System.out.println("Thank you! You will be added to Escape Room Family " + validation);
                        //System.out.println("If you know your Escape Room family Id please enter it now, if not please enter 0");
                        familyId = validation;

                        User user = new User(0, userName, firstName, lastName, passcode, familyId);

                        System.out.println(user.toString());

                        try {
                            userDAO.addUser(user);
                        }catch (Exception e){
                            System.out.println("You have entered an invalid family ID, If you do not have a family ID please enter 0");
                            continue;
                        }
                    System.out.println("A NEW PLAYER HAS ARRIVED!!");
                    continue;

                    case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please Enter one of the options");
                    continue;

            }
        }

    }
}


