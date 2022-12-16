package by.itacademy.postproject.web;

import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.factory.LogInServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {
    private final String  PARAM_NAME_LOGIN = "login";
    private final String  PARAM_NAME_PASSWORD = "password";

    private final ILogInService service;
    public LogInServlet(){
        this.service = LogInServiceSingleton.getInstance();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] logins = parameterMap.get(PARAM_NAME_LOGIN);
        String login = (logins == null) ? null : logins[0];

        String[] passwords = parameterMap.get(PARAM_NAME_PASSWORD);
        String password = (passwords == null) ? null : passwords[0];
        PrintWriter writer = resp.getWriter();
           if (service.checkLogin(login, password)){
            ActionSession.saveSession(req,PARAM_NAME_LOGIN,login);
            writer.write("<p> Authorization is successful </p>");}
           else {
               writer.write("<p> Login and password not exist </p>");
           }
    }
}
