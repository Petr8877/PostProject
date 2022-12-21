package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "StatisticsPage", urlPatterns = "/ui/admin/statistics")
public class StatisticsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStatisticsService service = StatisticsServiceSingleton.getInstance();
        Set<String> activeUsers = service.getActiveUsers();
        int users = activeUsers.size();
        int messages = service.getCountMessage();
        req.setAttribute("users", users);
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/views/Statistics.jsp").forward(req, resp);
    }
}
