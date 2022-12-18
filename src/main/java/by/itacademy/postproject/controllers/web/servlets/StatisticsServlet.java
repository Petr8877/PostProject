package by.itacademy.postproject.controllers.web.servlets;

import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.service.StatisticsService;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.MessageServiceSingleton;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;


@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IStatisticsService service;

    public StatisticsServlet() {
        this.service = StatisticsServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<p>" + service.getActiveUsers() + "</p>");
        writer.write("<p>" + service.getCountMessage() + "</p>");
    }
}