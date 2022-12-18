package by.itacademy.postproject.controllers.web.servlets;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionSession {

    public static String getParameterValue(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (value == null) {
            HttpSession session = request.getSession();
            if (!session.isNew()) {
                value = (String) session.getAttribute(key);
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("one of the required parameters was not passed");
        }
        return value;
    }

    public static void saveSession(HttpServletRequest request, String key, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }


}
