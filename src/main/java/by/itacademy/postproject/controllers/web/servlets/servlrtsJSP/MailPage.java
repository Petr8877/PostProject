package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.dto.UserSessionDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MailPage", urlPatterns = "/ui/user/message")
public class MailPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSessionDTO dto = (UserSessionDTO) req.getSession().getAttribute("user");
        req.setAttribute("name", dto.getLogin());
        req.getRequestDispatcher("/views/Mail.jsp").forward(req, resp);
    }
}
