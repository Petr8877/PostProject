package by.itacademy.postproject.web.listener;

import by.itacademy.postproject.dto.UserSessionDTO;
import by.itacademy.postproject.service.factory.StatisticServiceSingleton;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;
import java.util.Objects;

@WebListener
public class SessionDestroyedListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String element = attributeNames.nextElement();
            if (Objects.equals(element, "user")) {
                UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
                if (user != null) {
                     StatisticServiceSingleton.getInstance().deleteActiveUser();
                }
                break;
            }
        }
    }
}
