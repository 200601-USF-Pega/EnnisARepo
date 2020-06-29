package com.revature.dao;

import com.revature.models.GameMaster;
import com.revature.models.Reservation;
import com.revature.models.User;
import com.revature.services.ConnectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.*;


public class GameMasterDAOImplementation implements GameMasterDAO {

    ConnectionService connectionService = ConnectionService.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(GameMasterDAOImplementation.class.getName());

    @Override
    public List<GameMaster> getAllGameMasters() {
        int indexNum = 1;


        List<GameMaster> gameMasterList = new ArrayList<GameMaster>();
        LOGGER.info("Attempting to get a list of all GameMasters.");

        try {

            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM GameMasterlist;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                //Gets the data from the specified columns and uses them as parameters to create a new GameMaster
                GameMaster gameMaster = new GameMaster(rs.getString("firstname"), rs.getString("lastname"), rs.getString("managername"));
                //Adds the new GameMaster to the GameMasterList Array
                gameMasterList.add(gameMaster);
            }

            System.out.println("Currently are: " + gameMasterList.size() + " GameMasters.");



            for (GameMaster gameMaster : gameMasterList) {

                System.out.println("["+indexNum+ "] " + gameMaster.toString());
                ++indexNum;
            }
            LOGGER.info("Successfully returned a list of all GameMasters.");
            return gameMasterList;
        }catch(SQLException e){
            LOGGER.error("Error getting a list of all GameMasters.");
            e.printStackTrace();

        } catch (Exception e){
            LOGGER.error("Returning a null list of all GameMasters.");
        }

        LOGGER.error("Returning a null list of all GameMasters.");
        return null;
    }


    public List<GameMaster> getAllGameMastersNoSout() {

        //Instantiate a new ArrayLists of GameMasters
        List<GameMaster> gameMasterList = new ArrayList<GameMaster>();

        try {
            LOGGER.info("Attempting to get a list of all GameMasters.");
            PreparedStatement ps = connectionService.getConnection().prepareStatement("SELECT * FROM GameMasters;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                //Gets the data from the specified columns and uses them as parameters to create a new GameMaster
                GameMaster gameMaster = new GameMaster(rs.getString("firstname"), rs.getString("lastname"), rs.getString("managername"));
                //Adds the new GameMaster to the GameMasterList Array
                gameMasterList.add(gameMaster);
            }
            LOGGER.info("Successfully returned a list of all GameMasters.");
            return gameMasterList;
        }catch(SQLException e){
            LOGGER.error("Error getting a list of all GameMasters.");
            e.printStackTrace();

        } catch (Exception e){
            LOGGER.error("Error getting a list of all GameMasters.");
        }

        LOGGER.error("Returning a null list of all GameMasters.");
        return null;
    }

    
    
    
    
    @Override
    public boolean addGameMaster(GameMaster gameMaster) {
        LOGGER.info("Attempting to add a GameMaster.");
        gameMaster.toString();
        try {

            List<GameMaster> gameMasterList = this.getAllGameMastersNoSout();

            gameMasterList.add(gameMaster);

            try{
                LOGGER.info("Inserting GameMaster into database.");
                PreparedStatement ps = connectionService.getConnection().prepareStatement("INSERT INTO GameMasters (firstname, lastname, managername) VALUES (?,?,?);");
                ps.setString(1, gameMaster.getFirstname());
                ps.setString(2, gameMaster.getLastname());
                ps.setString(3, gameMaster.getManagername());

                boolean didWork = ps.execute();

                LOGGER.info("Successfully Added a GameMaster.");
                return didWork;


            }catch (SQLException e){
                e.printStackTrace();
            }


            return true;

        } catch(Exception e){
            System.out.println(e.getStackTrace());
            System.out.println("Error Adding GameMaster. Please Check your inputs.");
            LOGGER.error("Error Adding GameMaster.");
            return false;
        }

    }



}
