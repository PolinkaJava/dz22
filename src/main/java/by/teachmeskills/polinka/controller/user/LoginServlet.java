package by.teachmeskills.polinka.controller.user;

import by.teachmeskills.polinka.entity.User;
import by.teachmeskills.polinka.repository.FileRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private FileRepository repository;

    @Override
    public void init() throws ServletException {
        repository = new FileRepository();
        getServletContext().setAttribute("fileRepository", repository);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обработка введенных данных из формы входа
        String usernameLogin = req.getParameter("username");
        String passwordLgin = req.getParameter("password");

try {


    User authentication = repository.authentication(usernameLogin, passwordLgin);
    req.setAttribute("user", authentication);
    req.getRequestDispatcher("/jsp/welcom.jsp").forward(req, resp);
}catch (Exception exception){
    req.getRequestDispatcher("/jsp/error.jsp").forward(req,resp);
}
        List<User> users = repository.allUsers();

    }
}