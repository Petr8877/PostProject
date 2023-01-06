package by.itacademy.postproject.service.factory;

import by.itacademy.postproject.dao.factory.MessageDAOSingleton;
import by.itacademy.postproject.service.MessageService;
import by.itacademy.postproject.service.api.IMessageService;

public class MessageServiceSingleton {
    private volatile static MessageService instance;

    private MessageServiceSingleton() {
    }

    public static IMessageService getInstance() {
        if (instance == null) {
            synchronized (MessageService.class) {
                if (instance == null) {
                    instance = new MessageService(MessageDAOSingleton.getInstance(),
                            RegistrationServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
