package by.itacademy.postproject.dao.factory;

import by.itacademy.postproject.dao.RegisteredUsersDAO;
import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;

public class RegisteredUsersDAOSingleton {
    private volatile static RegisteredUsersDAO instance;

    private RegisteredUsersDAOSingleton() {
    }

    public static IRegisteredUsersDAO getInstance() {
        if (instance == null) {
            synchronized (RegisteredUsersDAOSingleton.class) {
                if (instance == null) {
                    instance = new RegisteredUsersDAO();
                }
            }
        }
        return instance;
    }
}
