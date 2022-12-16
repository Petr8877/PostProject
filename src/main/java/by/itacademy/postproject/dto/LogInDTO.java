package by.itacademy.postproject.dto;

public class LogInDTO {
    private String login;
    private String password;

    public LogInDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }
}
