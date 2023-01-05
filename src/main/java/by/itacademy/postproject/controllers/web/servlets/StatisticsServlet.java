package by.itacademy.postproject.controllers.web.servlets;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatisticsService service;

    public StatisticsServlet() {
        this.service = StatisticsServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        StatisticsDTO allStatistics = service.getAllStatistics();

        writer.write("<p> Number of active users in the application: " + allStatistics.getCountActiveUser() + "</p>");
        writer.write("<p> Number of all registered users in the application: " + allStatistics.getCountAllUser() + "</p>");
        writer.write("<p> Number of sent messages in the application: " + allStatistics.getCountMessage() + "</p>");
    }
}
