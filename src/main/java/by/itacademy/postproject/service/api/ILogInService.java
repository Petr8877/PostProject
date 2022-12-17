package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.LogInDTO;

public interface ILogInService {
    boolean checkLogin(LogInDTO logInDTO);
//    boolean checkLogin(String login, String password);
}
