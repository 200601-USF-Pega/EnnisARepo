package com.revature.models;

import junit.framework.TestCase;
import org.junit.Test;

public class GameMasterTest extends TestCase {

    @Test
    public void testGetFirstname() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.getLastname();
        assertTrue(gameMaster.getFirstname() == "test");
    }
    @Test
    public void testSetFirstname() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.setFirstname("testy");
        assertTrue(gameMaster.getFirstname() == "testy");
    }
    @Test
    public void testGetLastname() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.getLastname();
        assertTrue(gameMaster.getLastname() == "test");
    }
    @Test
    public void testSetLastname() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.setLastname("testy");
        assertTrue(gameMaster.getLastname() == "testy");
    }
    @Test
    public void testGetManagername() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.getManagername();
        assertTrue(gameMaster.getManagername() == "test");
    }
    @Test
    public void testSetManagername() {
        GameMaster gameMaster = new GameMaster("test","test", "test");
        gameMaster.setManagername("testy");
        assertTrue(gameMaster.getManagername() == "testy");
    }
}