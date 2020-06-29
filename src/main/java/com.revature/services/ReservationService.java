package com.revature.services;

import com.revature.dao.ReservationDAOImplementation;
import com.revature.models.Index;
import com.revature.models.Reservation;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/reservation")
public class ReservationService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservation(Reservation reservation){

        ReservationDAOImplementation reservationRepo = new ReservationDAOImplementation();
        reservationRepo.addReservation(reservation);
        System.out.println(reservation);

        return Response.ok().status(201).build();
    }

    @GET
    @Path("/all")
    public Response allReservation() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ReservationDAOImplementation reservationRepo = new ReservationDAOImplementation();
        List<Reservation> reservationList = reservationRepo.getAllReservations();
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reservationList);


        return Response.ok().status(200).entity(result).build();
    }



    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response deleteReservation(Index index) {

        ReservationDAOImplementation reservationRepo = new ReservationDAOImplementation();
        reservationRepo.removeReservation(index.getNum());


        return Response.ok().status(200).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response updateReservation(Reservation newReservation) {
        ReservationDAOImplementation reservationRepo = new ReservationDAOImplementation();
        int indexNum = newReservation.getReservationID();
        reservationRepo.updateReservation(indexNum, newReservation);

        return Response.ok().status(200).build();
    }

}
