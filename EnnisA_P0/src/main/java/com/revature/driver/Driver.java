package com.revature.driver;

import com.revature.menu.IMenu;
import com.revature.menu.MainMenu;
import com.revature.services.ConnectionService;

public class Driver {

    public static void main(String[] args) {

        ConnectionService connectionService = ConnectionService.getInstance();

        IMenu mainMenu = new MainMenu();

        mainMenu.menuStart();

    }
}
