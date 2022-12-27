package by.itacademy.postproject.controllers.web.listeners;

import by.itacademy.postproject.dto.UserSessionDTO;
import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.Objects;

public class SessionListeners implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String element = attributeNames.nextElement();
            if (Objects.equals(element, "user")) {
                UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
                if (user != null) {
                    IStatisticsService service = StatisticsServiceSingleton.getInstance();
                    service.removeActiveUser();
                }
                break;
            }
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            IStatisticsService service = StatisticsServiceSingleton.getInstance();
            service.addActiveUsers();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}

