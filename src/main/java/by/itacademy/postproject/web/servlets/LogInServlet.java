package by.itacademy.postproject.web.servlets;

import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.LoginDTO;
import by.itacademy.postproject.dto.UserSessionDTO;
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

        String[] passwords = parameterMap.get(PARAM_NAME_PASSWORD);

//        String page;

        try {
            String login = (logins == null) ? null : logins[0];
            String password = (passwords == null) ? null : passwords[0];

            LoginDTO logInDTO = new LoginDTO(login,password);

            if(service.checkLogin(logInDTO)){
                UserSessionDTO userSessionDTO = new  UserSessionDTO(login,service.getClientType(login));
                ActionSession.saveSession(req,"user", userSessionDTO);
                if ( userSessionDTO.getClientType().equals(ClientType.USER)){
                    req.getRequestDispatcher("/pages/user_main.jsp").forward(req,resp);
                }
                if ( userSessionDTO.getClientType().equals(ClientType.ADMINISTRATOR)){
                    req.getRequestDispatcher("/pages/secured/admin_main.jsp").forward(req,resp);
                }
            }


        } catch (Exception e){
            req.setAttribute("error_login", e.getMessage());
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
        }

    }
}
