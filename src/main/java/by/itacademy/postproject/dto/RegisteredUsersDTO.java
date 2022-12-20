package by.itacademy.postproject.dto;

import java.time.LocalDate;
import java.util.Objects;

public class RegisteredUsersDTO {
    private UserDTO user;
    private LocalDate dateRegistration;
    private String userRole;
    private static boolean isAdmin = false;

    public RegisteredUsersDTO(UserDTO user, LocalDate dateRegistration) {
        this.user = user;
        this.dateRegistration = dateRegistration;
        this.userRole = "user";
    }


    public RegisteredUsersDTO(UserDTO user) {
        this.user = user;
        this.dateRegistration = LocalDate.now();
        this.userRole = "user";
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setAdmin() {
        if (!isAdmin){
            userRole = "admin";
             isAdmin = true;
        }
        else userRole = "user";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredUsersDTO that = (RegisteredUsersDTO) o;
        return Objects.equals(userRole, that.userRole)
                && Objects.equals(user, that.user)
                && Objects.equals(dateRegistration, that.dateRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, dateRegistration, userRole);
    }

    @Override
    public String toString() {
        return "user = " + user +
                ", dateRegistration = " + dateRegistration +
                ", isAdmin = " + userRole;
    }
}
