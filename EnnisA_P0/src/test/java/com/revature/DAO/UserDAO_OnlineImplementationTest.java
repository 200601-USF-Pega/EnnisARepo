package com.revature.DAO;

import com.revature.models.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAO_OnlineImplementationTest extends TestCase {

    PreparedStatement preparedStatement;
    UserDAO_OnlineImplementation userDAO_online;
    UserDAO userDAO;
    ResultSet resultSet;

    private User user;

    @Before
    public void setUp() throws Exception {
        userDAO = userDAO_online;
        user = new User(1, "thebest", "gotcha", "yeaaaa", "things", 5);



    }

    @After
    public void tearDown() throws Exception {
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<User>();



        ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User userTest = new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getInt(6));
                userList.add(userTest);
            }

            assertEquals(user, userList.get(1).toString());

    }

    @Test
    public void addUser() {
    }
}