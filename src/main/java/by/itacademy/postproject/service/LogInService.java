package by.itacademy.postproject.service;

import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class LogInService implements ILogInService {
    IRegistrationService registrationService;

    public LogInService(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @Override
    public boolean checkLogin(String login, String password) {
        if (!registrationService.isExist(login) || !password.equals(registrationService.getUser(login).getUser().getPassword())){
            throw new IllegalArgumentException("Login and password not exist");
        }
        return true;
    }
}
