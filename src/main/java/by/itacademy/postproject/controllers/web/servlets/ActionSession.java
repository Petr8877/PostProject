package by.itacademy.postproject.controllers.web.servlets;


import by.itacademy.postproject.dto.UserSessionDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionSession {

    public static UserSessionDTO getParameterValue(HttpServletRequest request, String key) {
        String parameter = request.getParameter(key);
        UserSessionDTO userSessionDTO = null;
        if (parameter == null) {
            HttpSession session = request.getSession();
            if (!session.isNew()) {
                userSessionDTO = (UserSessionDTO) session.getAttribute(key);
            }
        }
        if (userSessionDTO == null) {
            throw new IllegalArgumentException("one of the required parameters was not passed");
        }
        return userSessionDTO;
    }

    public static void saveSession(HttpServletRequest request, String key, UserSessionDTO userSessionDTO) {
        HttpSession session = request.getSession();
        session.setAttribute(key, userSessionDTO);
        session.setMaxInactiveInterval(600);
    }


}
