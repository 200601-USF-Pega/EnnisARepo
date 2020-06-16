package com.revature.menu;

public class MenuFactory {

    public IMenu getMenu(String menuName) {
        IMenu currentMenu;
        switch (menuName) {

            case "MainMenu":
                return new MainMenu();

            case "Users":
                return new UserMenu();

            case "Managers":
                return new ManagerMenu();

            case "NewUserMenu":
                return new NewUserMenu();
        }

        return null;
    }
}
