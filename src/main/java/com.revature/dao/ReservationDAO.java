package com.revature.dao;

import com.revature.models.Reservation;

import java.util.ArrayList;
import java.util.List;

public interface ReservationDAO {

    public List<Reservation> getAllReservations();
    public boolean addReservation(Reservation reservation);
    public boolean removeReservation(int indexNum);
    public boolean updateReservation(int indexNum, Reservation newReservation);




}
