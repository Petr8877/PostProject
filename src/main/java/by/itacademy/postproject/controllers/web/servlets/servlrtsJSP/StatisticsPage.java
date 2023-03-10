package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatisticsPage", urlPatterns = "/ui/admin/statistics")
public class StatisticsPage extends HttpServlet {
    private final IStatisticsService service;

    public StatisticsPage() {
        this.service = StatisticsServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticsDTO allStatistics = service.getAllStatistics();
        req.setAttribute("statistic", allStatistics);
        req.getRequestDispatcher("/views/Statistics.jsp").forward(req, resp);
    }
}
