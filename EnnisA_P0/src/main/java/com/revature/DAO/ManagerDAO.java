package com.revature.DAO;

import com.revature.models.GameMaster;
import com.revature.models.Reservation;

import java.util.List;

public interface ManagerDAO {

    List<GameMaster> getAllGameMasters();
    List<GameMaster> getAllGameMastersNoSout();
    List<Reservation> getAllReservations();
    List<Reservation> getAllReservationsNoSout();
    boolean addReservation(Reservation reservation);
    boolean updateReservation(int index);
    boolean removeReservation(int reservationId);

}
