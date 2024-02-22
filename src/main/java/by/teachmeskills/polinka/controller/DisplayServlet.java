package by.teachmeskills.polinka.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = (String) request.getAttribute("login");
        String password = (String) request.getAttribute("password");
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");

        out.println("<html><body>");
        out.println("<h1>Введенные данные:</h1>");
        out.println("Логин: " + login + "<br>");
        out.println("Пароль: " + password + "<br>");
        out.println("Имя: " + name + "<br>");
        out.println("Фамилия: " + surname + "<br>");
        out.println("</body></html>");
    }
}

