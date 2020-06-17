package com.revature.DAO;

import com.revature.models.GameMaster;
import com.revature.models.Reservation;

import java.util.List;

public interface ManagerDAO {

    public List<GameMaster> getAllGameMasters();
    public List<GameMaster> getAllGameMastersNoSout();
    public List<Reservation> getAllReservations();
    public List<Reservation> getAllReservationsNoSout();
    public boolean addReservation(Reservation reservation);
    public boolean updateReservation(int index);
    public boolean removeReservation(int index);

}
