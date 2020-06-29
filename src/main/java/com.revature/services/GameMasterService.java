package com.revature.services;


import com.revature.dao.GameMasterDAOImplementation;
import com.revature.models.GameMaster;
import com.revature.models.Index;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/gamemaster")
public class GameMasterService {


    @GET
    @Path("/all")
    public Response getAllGameMasters() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GameMasterDAOImplementation gameMasterRepo = new GameMasterDAOImplementation();
        List<GameMaster> gameMasterList = gameMasterRepo.getAllGameMasters();
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameMasterList);

        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGameMaster(GameMaster gameMaster) throws IOException{


        GameMasterDAOImplementation gameMasterRepo = new GameMasterDAOImplementation();

        System.out.println(gameMaster.toString());
        gameMasterRepo.addGameMaster(gameMaster);

        return Response.ok().build();
    }




}
