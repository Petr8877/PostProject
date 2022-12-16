package by.itacademy.postproject.dao.factory;

import by.itacademy.postproject.dao.MessageDAO;
import by.itacademy.postproject.dao.api.IMessageDAO;

public class MessageDAOSingleton {
    private volatile static MessageDAO instance;

    private MessageDAOSingleton() {
    }

    public static IMessageDAO getInstance() {
        if (instance == null) {
            synchronized (MessageDAOSingleton.class) {
                if (instance == null) {
                    instance = new MessageDAO();
                }
            }
        }
        return instance;
    }
}
