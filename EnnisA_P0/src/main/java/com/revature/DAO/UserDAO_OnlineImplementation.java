package com.revature.DAO;

import com.revature.models.User;
import com.revature.services.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO_OnlineImplementation implements UserDAO {

    ConnectionService connectionService = ConnectionService.getInstance();

    public UserDAO_OnlineImplementation() {

    }

    @Override
    public List<User> getAllUsers(){
        int index = 1;

        List<User> userList = new ArrayList<User>();

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM users;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("passcode"),
                        rs.getInt("familyid"));
                userList.add(user);
            }

            System.out.println("There are: " + userList.size() + " Users.");


            for (User user : userList) {

                System.out.println("[" + index+ "] " + user.toString());
                ++index;
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }

        return null;
    }


    public List<User> getAllUsersNoSout() {

        List<User> userList = new ArrayList<User> ();
        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM users;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User(rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("passcode"),
                        rs.getInt("familyid"));
                userList.add(user);
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {

        }

        return null;
    }


    @Override
    public boolean addUser(User user) {

        user.toString();

        try {

            List<User> userList = this.getAllUsersNoSout();

            userList.add(user);

            try {

                PreparedStatement ps = connectionService.getConnection().prepareStatement("INSERT INTO users (username, firstname, lastname, passcode,familyid) VALUES (?,?,?,?,?);");
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getPasscode());
                ps.setInt(5, user.getFamilyId());
                boolean success = ps.execute();

                return success;


            } catch (SQLException e) {
                e.printStackTrace();
            }


            return true;

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println("Error Adding User. Please ensure that you have the correct information.");
            return false;
        }
    }
}
