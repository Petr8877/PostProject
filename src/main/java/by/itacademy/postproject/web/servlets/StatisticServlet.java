package by.itacademy.postproject.web.servlets;

import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.UserSessionDTO;
import by.itacademy.postproject.service.api.IStatisticService;
import by.itacademy.postproject.service.factory.StatisticServiceSingleton;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {


    private IStatisticService service;

    public StatisticServlet() {
        this.service = StatisticServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        UserSessionDTO user =(UserSessionDTO) req.getSession().getAttribute("user");
        if (user.getClientType().equals(ClientType.ADMINISTRATOR)) {
            writer.write("<p> count of active users" + service.getCountOfActiveUsers() + "</p>");
            writer.write("<p> count of users " + service.getCountOfUsers() + "</p>");
            writer.write("<p> count of messages " + service.getCountOfMessages() + "</p>");
        } else {
            throw  new IllegalArgumentException("<p> Access is denied </p>");
        }
    }
}



