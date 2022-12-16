package by.itacademy.postproject.service;

import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class LogInService implements ILogInService {
    private final IRegistrationService registrationService;

    public LogInService(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @Override
    public boolean checkLogin(String login, String password) {
        if (login == null || password == null){
            return false;
        }
        return registrationService.isExist(login) && password.equals(registrationService.getUser(login).getUser().getPassword());
    }
}
