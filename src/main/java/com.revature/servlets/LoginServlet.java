package com.revature.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    String html = "<html><body>";
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
//        RequestDispatcher requestDispatcher = new R


        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);

        if(username.equalsIgnoreCase("manager")){

            if(password.equalsIgnoreCase("ajisthebest")){

                req.getRequestDispatcher("/admin.html").forward(req, resp);
                LOGGER.info("An Admin Level User Logged In");

            }

        }


    }
}
