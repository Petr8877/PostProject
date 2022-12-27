package by.itacademy.postproject.entity;

import by.itacademy.postproject.dto.UserDTO;

import java.time.LocalDate;
import java.util.Objects;

public class RegisteredUsersEntity {
    private UserDTO user;
    private LocalDate dateRegistration;
    private ClientType userRole;
    private static boolean isAdmin = false;

    public RegisteredUsersEntity(UserDTO user, LocalDate dateRegistration) {
        this.user = user;
        this.dateRegistration = dateRegistration;
        this.userRole = ClientType.USER;
    }


    public RegisteredUsersEntity(UserDTO user) {
        this.user = user;
        this.dateRegistration = LocalDate.now();
        this.userRole = ClientType.USER;
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

    public ClientType getUserRole() {
        return userRole;
    }

    public void setAdmin() {
        if (!isAdmin) {
            userRole = ClientType.ADMINISTRATOR;
            isAdmin = true;
        } else userRole = ClientType.USER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredUsersEntity that = (RegisteredUsersEntity) o;
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
