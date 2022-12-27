package by.itacademy.postproject.dto;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {
    private String login;
    private String password;
    private String fullName;
    private LocalDate birthdate;

    public UserDTO(String login, String password, String fullName, LocalDate birthdate) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(login, userDTO.login)
                && Objects.equals(password, userDTO.password)
                && Objects.equals(fullName, userDTO.fullName)
                && Objects.equals(birthdate, userDTO.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fullName, birthdate);
    }

    @Override
    public String toString() {
        return "login = " + login +
                ", password = " + password +
                ", fullName = " + fullName +
                ", birthdate = " + birthdate;
    }
}
