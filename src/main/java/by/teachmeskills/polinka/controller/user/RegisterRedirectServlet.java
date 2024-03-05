package by.teachmeskills.polinka.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class RegisterRedirectServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -1410169038030137825L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp");
    }
}