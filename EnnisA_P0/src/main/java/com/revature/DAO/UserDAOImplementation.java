package com.revature.DAO;

import com.revature.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplementation implements  UserDAO{

    List<User> userList = new ArrayList<User>();

    String filepath = "C:/Users/ajemo/IdeaProjects/EscapeRoomManagement/src/main/java/com/revature/output/UserData.txt";

    public UserDAOImplementation() throws IOException {
        }

        @Override
        public List<User> getAllUsers() {


            try{
                ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
                List<User> userList = (List<User>)objectInputStream.readObject();
                System.out.println("Got the list");
                objectInputStream.close();

                System.out.println("Currently are: " + userList.size() + " Users.");
                for (User user: userList) {

                    System.out.println(user.toString());
                }

                return userList;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Class Not found");
            }


            return null;

        }

    public List<User> getAllUsersNoSout() {


        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filepath)));
            List<User> userList = (List<User>)objectInputStream.readObject();
            objectInputStream.close();

            return userList;

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
    public boolean addUser(User user) {

        try {
            try {
                userList = this.getAllUsersNoSout();
            } catch (Exception e) {

            }

            userList.add(user);

            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
                objectOutputStream.writeObject(userList);
                System.out.println("New User Added.");
                objectOutputStream.close();

            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println("Error adding User. Please ensure that you are providing the correct information");
            return false;
        }
    }


}
