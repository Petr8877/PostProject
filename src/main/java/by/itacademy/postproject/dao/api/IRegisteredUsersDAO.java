package by.itacademy.postproject.dao.api;

import by.itacademy.postproject.entity.ClientType;
import by.itacademy.postproject.entity.RegisteredUsersEntity;

public interface IRegisteredUsersDAO {

    void save(RegisteredUsersEntity registeredUsersEntity);

    boolean isExist(String login);

    RegisteredUsersEntity getUser(String login);

    ClientType getClientType(String login);

    int getCountAllUser();


}

