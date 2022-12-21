package by.itacademy.postproject.dao.api;

import by.itacademy.postproject.entity.RegisteredUsersEntity;

public interface IRegisteredUsersDAO {

    void save(RegisteredUsersEntity registeredUsersEntity);

    boolean isExist(String login);

    RegisteredUsersEntity getUser(String login);


}

