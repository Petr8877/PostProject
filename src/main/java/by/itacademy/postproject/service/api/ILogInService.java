package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.LogInDTO;
import by.itacademy.postproject.entity.ClientType;

public interface ILogInService {

    void signIn(LogInDTO log);

    ClientType getClientType(String login);
}
