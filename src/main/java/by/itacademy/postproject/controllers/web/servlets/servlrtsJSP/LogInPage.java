package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogInPage", urlPatterns = "/ui/signIn")
public class LogInPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String redirect = contextPath + "/api/login";
        req.setAttribute("path", redirect);
        req.getRequestDispatcher("/views/LogIn.jsp").forward(req, resp);
    }
}
