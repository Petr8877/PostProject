package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationPage", urlPatterns = "/ui/singUp")
public class RegistrationPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("RegistrationPage.jsp").forward(req, resp);
    }
}
