package by.itacademy.postproject.dto;

public class UserSessionDTO {
    private String login;
    private ClientType clientType;

    public UserSessionDTO(String login, ClientType clientType) {
        this.login = login;
        this.clientType =  clientType;

    }

    public String getLogin() {
        return login;
    }

    public ClientType getClientType() {
        return clientType;
    }
}
