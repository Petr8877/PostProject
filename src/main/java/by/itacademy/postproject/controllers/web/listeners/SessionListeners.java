package by.itacademy.postproject.controllers.web.listeners;


import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListeners implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            IStatisticsService service = StatisticsServiceSingleton.getInstance();
            service.addActiveUsers((String) httpSessionBindingEvent.getSession().getAttribute("user"));
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            IStatisticsService service = StatisticsServiceSingleton.getInstance();
            service.addActiveUsers((String) httpSessionBindingEvent.getSession().getAttribute("user"));
        }
    }
}
