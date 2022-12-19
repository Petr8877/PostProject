package by.itacademy.postproject.service.factory;

import by.itacademy.postproject.service.LogInService;
import by.itacademy.postproject.service.api.ILogInService;

public class LogInServiceSingleton {
    private volatile static LogInService instance;

    private LogInServiceSingleton() {
    }

    public static ILogInService getInstance(){
        if(instance == null){
            synchronized (LogInService.class){
                if(instance == null){
                    instance = new LogInService(RegistrationServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
