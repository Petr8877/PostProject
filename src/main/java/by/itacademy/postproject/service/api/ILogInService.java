package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.LoginDTO;

public interface ILogInService {
    boolean checkLogin(LoginDTO logInDTO);
    ClientType getClientType(String login);
}
