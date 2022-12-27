package by.itacademy.postproject.dto;

import by.itacademy.postproject.entity.ClientType;

public class UserSessionDTO {
    private String login;
    private ClientType clientType;

    public UserSessionDTO(String login, ClientType clientType) {
        this.login = login;
        this.clientType = clientType;

    }

    public String getLogin() {
        return login;
    }

    public ClientType getClientType() {
        return clientType;
    }
}
