package com.revature.models;

import junit.framework.TestCase;
import org.junit.Test;

public class UserTest extends TestCase {


    @Test
    public void testGetUserName() {
        User user = new User("test","test","test","test", 1);
        user.getUserName();
        assertTrue(user.getUserName() == "test");
    }
    @Test
    public void testSetUserName() {
        User user = new User("test","test","test","test", 1);
        user.setUserName("testy");
        assertTrue(user.getUserName() == "testy");
    }
    @Test
    public void testGetFirstName() {
        User user = new User("test","test","test","test", 1);
        user.getFirstName();
        assertTrue(user.getFirstName() == "test");
    }
    @Test
    public void testSetFirstName() {
        User user = new User("test","test","test","test", 1);
        user.setFirstName("testy");
        assertTrue(user.getFirstName() == "testy");
    }
    @Test
    public void testGetLastName() {
        User user = new User("test","test","test","test", 1);
        user.getLastName();
        assertTrue(user.getLastName() == "test");
    }
    @Test
    public void testSetLastName() {
        User user = new User("test","test","test","test", 1);
        user.setLastName("testy");
        assertTrue(user.getLastName() == "testy");
    }
}