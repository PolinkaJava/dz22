package by.teachmeskills.polinka.controller.user;

import by.teachmeskills.polinka.entity.User;
import by.teachmeskills.polinka.repository.FileRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileRepository repository = (FileRepository) getServletContext().getAttribute("fileRepository");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        long id = repository.userIdGenerator();
        User.Role role = repository.allUsers().isEmpty() ? User.Role.ADMIN : User.Role.USER;

        User user = new User(id,name,surname,login,password,role);
        repository.add(user);

        resp.sendRedirect("/jsp/register.jsp");
    }
}