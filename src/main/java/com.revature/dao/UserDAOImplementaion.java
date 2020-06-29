package com.revature.dao;

import com.revature.models.GameMaster;
import  com.revature.models.Reservation;
import com.revature.models.User;
import com.revature.services.ConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;


public class UserDAOImplementaion implements UserDAO {

    ConnectionService connectionService = ConnectionService.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(UserDAOImplementaion.class.getName());

    //Setting Up Connection to our DataBase
    public UserDAOImplementaion(){


    }

    @Override
    public List<User> getAllUsers() {
        int indexNum = 1;


        List<User> userList = new ArrayList<User>();

    try {
        LOGGER.info("Attempting to get a list of all Users.");
        PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM users;");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            User user = new User(rs.getString("username"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("passcode"), rs.getInt("familyid"));

            userList.add(user);
        }

        System.out.println("Currently are: " + userList.size() + " Users.");



        for (User user : userList) {

            System.out.println("["+indexNum+ "] " + user.toString());
            ++indexNum;
        }
        LOGGER.info("Successfully returned a list of all Users.");
        return userList;
    }catch(SQLException e){
        LOGGER.error("Error getting a list of all Users.");
        e.printStackTrace();

    } catch (Exception e){
        LOGGER.error("Error getting a list of all Users.");
    }
        LOGGER.error("Returning a null list of all Users.");
        return null;

    }

    @Override
    public List<User> getAllUsersNoSout() {


        List<User> userList = new ArrayList<User>();

        try {
            LOGGER.info("Attempting to get a list of all Users.");
            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM users;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                User user = new User(rs.getString("username"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("passcode"), rs.getInt("familyid"));

                userList.add(user);
            }

            LOGGER.info("Successfully returned a list of all Users.");
            return userList;

        }catch(SQLException e){
            LOGGER.error("Error getting a list of all Users.");
            e.printStackTrace();

        } catch (Exception e){
            LOGGER.error("Error getting a list of all Users.");
        }
        LOGGER.error("Returning a null list of all Users.");
        return null;

    }
    
    
    
    
    @Override
    public boolean addUser(User user) {
        user.toString();
        LOGGER.info("Attempting to add a User.");
       try {

            List<User> userList = this.getAllUsersNoSout();

            userList.add(user);

            try{
                LOGGER.info("Inserting User into database.");
                PreparedStatement ps = connectionService.getConnection().prepareStatement("INSERT INTO users (username,firstname, lastname, passcode, familyid) VALUES (?,?,?,?,?);");
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getPasscode());
                ps.setInt(5, user.getFamilyid());
                boolean didWork = ps.execute();
                LOGGER.info("Successfully Added a User.");
                return didWork;


            }catch (SQLException e){
                e.printStackTrace();
            }


            return true;

        } catch(Exception e){
            System.out.println(e.getStackTrace());
            System.out.println("Error Adding User. Please Check your inputs.");
            LOGGER.error("Error Adding User.");
            return false;
        }

    }

    @Override
    public boolean removeUser(int indexNum) {

        LOGGER.info("Attempting to remove a User.");
        try {

            List<User> userList = this.getAllUsersNoSout();

            User user = userList.get(indexNum - 1);


                 LOGGER.info("Deleting User from the database.");

                    PreparedStatement ps = connectionService.getConnection().prepareStatement("DELETE FROM users as r WHERE r.username = ? AND r.lastname = ?;");
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getLastName());
                    
                    boolean didWork = ps.execute();
                    System.out.println("Deleted: " + user.toString());

                    LOGGER.info("Successfully Removed a User.");
                    return didWork;




        } catch(Exception e){
            LOGGER.info("Error Removed a User.");
            System.out.println("No User exists with that username.");
            return false;
        }


    }

   
}
