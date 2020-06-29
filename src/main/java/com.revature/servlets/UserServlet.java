package com.revature.servlets;


import com.revature.dao.ReservationDAOImplementation;

import com.revature.dao.GameMasterDAOImplementation;
import com.revature.dao.UserDAOImplementaion;
import com.revature.models.GameMaster;
import com.revature.models.Reservation;
import com.revature.models.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    String userTableStart = "\n" +
            "<table class=\"table\">\n" +
            "    <thead>\n" +
            "        <th scope=\"col\">ID #</th>\n" +
            "        <th scope=\"col\">User Name</th>\n" +
            "        <th scope=\"col\">First Name</th>\n" +
            "        <th scope=\"col\">Last Name</th>\n" +
            "        <th scope=\"col\">Player Group</th>\n" +
            "    </thead><tbody>";




    GenericPageFormat pageFormat = new GenericPageFormat();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String getCheck = req.getParameter("getAllUsers");
        System.out.println(getCheck);


        if ("1".equals(getCheck)) {
            resp.getWriter().write(pageFormat.getHtmlStart() + this.getAllUsers() + pageFormat.getHtmlEnd());
        } else if ("2".equals(getCheck)) {//   resp.getWriter().write(pageFormat.getHtmlStart() + this.getAllUsers() + pageFormat.getHtmlEnd() );

            //case "3":
            //resp.getWriter().write(pageFormat.getHtmlStart() + this.getAllUsers() + pageFormat.getHtmlEnd() );

            //   break;
        }


    }


    private String getAllUsers(){

        UserDAOImplementaion userDao = new UserDAOImplementaion();
        List<User> userList = new ArrayList<User>();

        String htmlout = "";
        int index = 1;

        userList = userDao.getAllUsers();

        htmlout = (htmlout + userTableStart);

        for (User r: userList) {


            htmlout = (htmlout + "<tr>");
            htmlout = (htmlout + "<td>" + index + "</td>");
            htmlout = (htmlout + "<td>" + r.getUserName() + "</td>");
            htmlout = (htmlout + "<td>" + r.getFirstName()+ "</td>");
            htmlout = (htmlout + "<td>" + r.getLastName()+ "</td>");
            htmlout = (htmlout + "<td>" + r.getFamilyid()+ "</td>");
            htmlout = (htmlout + "</tr>");
            index = index + 1;

        }

        htmlout = (htmlout + "</tbody></table>");

        return htmlout;
    }



}
