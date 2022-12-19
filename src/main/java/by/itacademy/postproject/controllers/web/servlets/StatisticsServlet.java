package by.itacademy.postproject.controllers.web.servlets;

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
        if ("Admin".equals(ActionSession.getParameterValue(req, "user"))) {
            writer.write("<p>" + service.getAllStatistics() + "</p>");
            /*writer.write("<p>" + "Number of active users in the application: " + service.getActiveUsers() + "</p>");
            writer.write("<p>" + "Number of sent messages in the application: " + service.getCountMessage() + "</p>");*/
        }else{
            writer.write("No access");
        }
    }
}
