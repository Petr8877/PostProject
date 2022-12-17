package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.LogInDTO;
import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class LogInService implements ILogInService {
    IRegistrationService registrationService;

    public LogInService(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @Override
    public boolean checkLogin(LogInDTO logInDTO) {
        if (!registrationService.isExist(logInDTO.getLogin()) || !logInDTO.getPassword().equals(registrationService.getUser(logInDTO.getLogin()).getUser().getPassword())){
            throw new IllegalArgumentException("Login and password not exist");
        }
        return true;
    }
}
