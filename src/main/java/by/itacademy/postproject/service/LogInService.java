package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.LoginDTO;
import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class LogInService implements ILogInService {
    private IRegistrationService registrationService;

    public LogInService(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @Override
    public boolean checkLogin(LoginDTO loginDTO) {
        if (!registrationService.isExist(loginDTO.getLogin()) || !loginDTO.getPassword().equals(registrationService.getUser(loginDTO.getLogin()).getUser().getPassword())){
            throw new IllegalArgumentException("Login and password not exist");
        }
        return true;
    }

    @Override
    public ClientType getClientType(String login) {
        return registrationService.getClientType(login);
    }
}
