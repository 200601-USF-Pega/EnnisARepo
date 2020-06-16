package com.revature.DAO;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public List<User> getAllUsersNoSout();
    public boolean addUser(User user);

}
