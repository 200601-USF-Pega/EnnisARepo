package com.revature.menu;

import java.util.Scanner;

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
            System.out.println("For User login press [1]");
            System.out.println("For Manager login press [2]");
            System.out.println("If you are a new user login press [3]");
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
                    newMenu = menuFactory.getMenu("New User");
                    newMenu.menuStart();
                    break;

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


