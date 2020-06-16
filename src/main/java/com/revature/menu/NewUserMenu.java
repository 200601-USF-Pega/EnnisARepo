package com.revature.menu;

import java.util.Scanner;

public class NewUserMenu implements IMenu {

    @Override
    public void menuStart() {

        MenuFactory menuFactory = new MenuFactory();
        IMenu newMenu;

        Scanner sc = new Scanner(System.in);

        userDAO_OnlineImpl userDAO = null;

        try {
            userDAO = new userDAO_OnlineImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userName;
        String firstName;
        String lastName;
        String passcode;

        System.out.println("Welcome New User");
        System.out.println("Please create a username: ");
        userName = sc.next();

        System.out.println("Please enter your first name: ");
        firstName = sc.next();

        System.out.println("Please enter your last name: ");
        lastName = sc.next();

        System.out.println("Please create your password: ");
        passcode = sc.next();

        User user = new User(userName, firstName, lastName, passcode);

        System.out.println(User.toString());
        userDAO.addUser(User);


    }
}
