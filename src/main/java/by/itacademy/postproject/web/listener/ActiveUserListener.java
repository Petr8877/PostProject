package by.itacademy.postproject.web.listener;

import by.itacademy.postproject.service.factory.StatisticServiceSingleton;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
@WebListener
public class ActiveUserListener implements HttpSessionAttributeListener {



    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
            if (event.getName().equals("user")){
                StatisticServiceSingleton.getInstance().setCountOfActiveUsers();
        }
    }


    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")){
            StatisticServiceSingleton.getInstance().setCountOfActiveUsers();
        }
    }


}