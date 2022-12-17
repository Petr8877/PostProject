package by.itacademy.postproject.dao.api;

import by.itacademy.postproject.dto.RegisteredUsersDTO;

public interface IRegisteredUsersDAO {

    void save(RegisteredUsersDTO registeredUsersDTO);

    boolean isExist(String login);
    RegisteredUsersDTO getUser(String login);

}

