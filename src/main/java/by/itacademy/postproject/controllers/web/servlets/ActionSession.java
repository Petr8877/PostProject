package by.itacademy.postproject.controllers.web.servlets;

import by.itacademy.postproject.controllers.web.listeners.SessionListeners;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionSession  {
    private static HttpSession session;
    public static String getParameterValue(HttpServletRequest request, String key){
        String value = (String) session.getAttribute(key);
        if (value == null){
            session = request.getSession();
            if(!session.isNew()){
                value = (String) session.getAttribute(key);
            }
        }
        if (value == null){
            throw new IllegalArgumentException("one of the required parameters was not passed");
        }
        return value;
    }
    public static void saveSession(HttpServletRequest request, String key, String value){
        if (request.getSession() == null){
            session = request.getSession();
        session.setAttribute(key,value);} else {
            request.getSession().setAttribute(key,value);
        }
    }


}
