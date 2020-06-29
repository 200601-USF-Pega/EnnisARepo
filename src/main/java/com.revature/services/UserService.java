package com.revature.services;

import com.revature.dao.UserDAOImplementaion;
import com.revature.models.Index;
import com.revature.models.User;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/user")
public class UserService {



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user){

        System.out.println(user.toString());

        UserDAOImplementaion userDao = new UserDAOImplementaion();

        userDao.addUser(user);

        return Response.ok().status(201).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response deleteUser(Index index) {

        UserDAOImplementaion userDao = new UserDAOImplementaion();
        userDao.removeUser(index.getNum());


        return Response.ok().build();
    }

    @GET
    @Path("/all")
    public Response getAllUsers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserDAOImplementaion userDao = new UserDAOImplementaion();

        List<User> userList = userDao.getAllUsers();

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

        return  Response.ok().entity(result).build();

    }


}
