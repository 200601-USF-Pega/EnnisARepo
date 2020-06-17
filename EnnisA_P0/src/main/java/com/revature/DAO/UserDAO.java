package com.revature.DAO;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    List<User> getAllUsersNoSout();
    boolean addUser(User user);

}
