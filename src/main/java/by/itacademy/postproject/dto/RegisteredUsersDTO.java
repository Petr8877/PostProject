package by.itacademy.postproject.dto;

import java.time.LocalDate;
import java.util.Objects;

public class RegisteredUsersDTO {
    private UserDTO user;
    private LocalDate dateRegistration;
    private boolean isAdmin;

    public RegisteredUsersDTO(UserDTO user, LocalDate dateRegistration) {
        this.user = user;
        this.dateRegistration = dateRegistration;
        this.isAdmin = false;
    }


    public RegisteredUsersDTO(UserDTO user) {
        this.user = user;
        this.dateRegistration = LocalDate.now();
        this.isAdmin = false;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredUsersDTO that = (RegisteredUsersDTO) o;
        return isAdmin == that.isAdmin
                && Objects.equals(user, that.user)
                && Objects.equals(dateRegistration, that.dateRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, dateRegistration, isAdmin);
    }

    @Override
    public String toString() {
        return "user = " + user +
                ", dateRegistration = " + dateRegistration +
                ", isAdmin = " + isAdmin;
    }
}
