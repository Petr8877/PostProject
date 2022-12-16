package by.itacademy.postproject.service.factory;

import by.itacademy.postproject.dao.factory.RegisteredUsersDAOSingleton;
import by.itacademy.postproject.service.RegistrationService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class RegistrationServiceSingleton {
    private volatile static RegistrationService instance;

    private RegistrationServiceSingleton() {
    }

    public static IRegistrationService getInstance(){
        if(instance == null){
            synchronized (RegistrationService.class){
                if(instance == null){
                    instance = new RegistrationService(RegisteredUsersDAOSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
