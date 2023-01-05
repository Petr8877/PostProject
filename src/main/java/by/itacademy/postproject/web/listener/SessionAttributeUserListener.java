package by.itacademy.postproject.web.listener;

import by.itacademy.postproject.service.factory.StatisticServiceSingleton;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
@WebListener
public class SessionAttributeUserListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
            if (event.getName().equals("user")){
                StatisticServiceSingleton.getInstance().addActiveUser();
        }
    }


    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }


}
