package by.itacademy.postproject.service.api;

import by.itacademy.postproject.entity.ClientType;
import by.itacademy.postproject.entity.RegisteredUsersEntity;
import by.itacademy.postproject.dto.UserDTO;

public interface IRegistrationService {

    boolean register(UserDTO user);

    boolean isExist(String login);

    RegisteredUsersEntity getUser(String login);

    ClientType getClientType(String login);

    int getCountAllUser();


}
