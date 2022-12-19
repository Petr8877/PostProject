package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.RegisteredUsersDTO;
import by.itacademy.postproject.dto.UserDTO;

public interface IRegistrationService {

    void register(UserDTO user);

    boolean isExist(String login);

    RegisteredUsersDTO getUser(String login);
    int getCountOfUsers();



}
