package by.itacademy.postproject.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogInDTO logInDTO = (LogInDTO) o;
        return Objects.equals(login, logInDTO.login) && Objects.equals(password, logInDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "login = " + login +
                ", password = " + password;
    }
}
