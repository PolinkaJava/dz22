package by.teachmeskills.polinka.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        try (FileWriter writer = new FileWriter("C:\\Users\\user\\Desktop\\Maven\\project2\\src\\main\\resources\\registration.txt", true)) {
            writer.write("Login: " + login + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Surname: " + surname + "\n");
            writer.write("-------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setAttribute("login", login);
        request.setAttribute("password", password);
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);

        request.getRequestDispatcher("/display").forward(request, response);
    }
}

