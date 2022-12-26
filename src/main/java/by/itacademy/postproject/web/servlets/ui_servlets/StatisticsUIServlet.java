package by.itacademy.postproject.web.servlets.ui_servlets;


import by.itacademy.postproject.dto.StatisticDTO;
import by.itacademy.postproject.service.api.IStatisticService;
import by.itacademy.postproject.service.factory.StatisticServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatisticsUIServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsUIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStatisticService service = StatisticServiceSingleton.getInstance();
        StatisticDTO statistic = service.getStatistic();
        req.setAttribute("activeUsers",statistic.getActiveUsers());
        req.setAttribute("users",statistic.getCountOfAllUsers());
        req.setAttribute("messages",statistic.getCountOfMessages());

        req.getRequestDispatcher("/pages/secured/statistics.jsp").forward(req,resp);
    }

}
