package com.example.week_8_e_commerce_app_servlet.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session to log out the user
        request.getSession().invalidate();

        // Redirect to the login page or home page
        response.sendRedirect("/");
//        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
