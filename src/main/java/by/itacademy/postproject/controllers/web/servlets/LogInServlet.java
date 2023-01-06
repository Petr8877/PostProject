package by.itacademy.postproject.controllers.web.servlets;

import by.itacademy.postproject.dto.LogInDTO;
import by.itacademy.postproject.dto.UserSessionDTO;
import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.factory.LogInServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(name = "LogInServlet", urlPatterns = "/api/login")
public class LogInServlet extends HttpServlet {
    private final String PARAM_NAME_LOGIN = "login";
    private final String PARAM_NAME_PASSWORD = "password";

    private final ILogInService service;

    public LogInServlet() {
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

        try {
            if (logins == null) {
                throw new IllegalArgumentException("Login not entered");
            }

            if (passwords == null) {
                throw new IllegalArgumentException("Password not entered");
            }

            LogInDTO log = new LogInDTO(login, password);
            if (service.signIn(log)) {
                UserSessionDTO userSessionDTO = new UserSessionDTO(login, service.getClientType(login));

                ActionSession.saveSession(req, "user", userSessionDTO);
                String path = req.getContextPath() + "/ui" + "/UserLogIn";

                resp.sendRedirect(path);
            } else {
                String path = req.getContextPath() + "/ui" + "/UserNotLogIn";

                resp.sendRedirect(path);
            }
            // writer.write("<p> Authorization is successful </p>");

        } catch (IllegalArgumentException exception) {
            writer.write("<p>" + exception.getMessage() + "</p>");
        }
    }

}
