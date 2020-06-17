package com.revature.menu;

import com.revature.DAO.UserDAO_OnlineImplementation;
import com.revature.models.User;
import com.revature.DAO.UserDAO;

import java.util.Scanner;

public class NewUserMenu implements IMenu {

    @Override
    public void menuStart() {

        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;

        Scanner sc = new Scanner(System.in);

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

        while (true) {
        System.out.println("Welcome New User");
        System.out.println("Please select an option:");
        System.out.println("Press [1] to create a new user account");
        System.out.println("Press [0] to return to the main menu");

        int nextMenu = sc.nextInt();

        switch (nextMenu) {


            case 1:
                System.out.println("Please create a username: ");
                userName = sc.next();

                System.out.println("Please enter your first name: ");
                firstName = sc.next();

                System.out.println("Please enter your last name: ");
                lastName = sc.next();

                System.out.println("Please create your password: ");
                passcode = sc.next();

                User user = new User(0, userName, firstName, lastName, passcode, 0);

                System.out.println(user.toString());
                userDAO.addUser(user);
                break;

            case 0:
                newMenu = menuFactory.getMenu("MainMenu");
                newMenu.menuStart();
                break;

            default:
                System.out.println("Please select one of the options");
                continue;
        }
        }
    }
}
