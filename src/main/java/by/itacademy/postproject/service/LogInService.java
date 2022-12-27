package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.LogInDTO;
import by.itacademy.postproject.entity.ClientType;
import by.itacademy.postproject.service.api.ILogInService;
import by.itacademy.postproject.service.api.IRegistrationService;

public class LogInService implements ILogInService {
    private final IRegistrationService registrationService;

    public LogInService(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void signIn(LogInDTO log) {
        String login = log.getLogin();

        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login not entered");
        }

        if (!registrationService.isExist(login)) {
            throw new IllegalArgumentException("This login doesn't exist");
        }

        String password = log.getPassword();

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password not entered");
        }

        if (!registrationService.getUser(login).getUser().getPassword().equals(password)) {
            throw new IllegalArgumentException("Wrong password entered");
        }

    }

    @Override
    public ClientType getClientType(String login) {
        return registrationService.getClientType(login);
    }
}
