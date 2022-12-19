package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;
import by.itacademy.postproject.dto.RegisteredUsersDTO;
import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.service.api.IRegistrationService;

import java.time.LocalDate;

public class RegistrationService implements IRegistrationService {
    private final IRegisteredUsersDAO dao;

    public RegistrationService(IRegisteredUsersDAO dao) {
        this.dao = dao;
    }

    @Override
    public void register(UserDTO user) {
        validate(user);
        this.dao.save(new RegisteredUsersDTO(user));
    }

    @Override
    public boolean isExist(String login) {
        return this.dao.isExist(login);
    }

    @Override
    public RegisteredUsersDTO getUser(String login) {
        return this.dao.getUser(login);
    }

    private void validate(UserDTO userDTO) {
        String login = userDTO.getLogin();

        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login not entered");
        }

        if (dao.isExist(login)) {
            throw new IllegalArgumentException("User with this login is already registered");
        }

        String password = userDTO.getPassword();

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password not entered");
        }

        //можно доп.проверить пароль на кол-во символов

        String fullName = userDTO.getFullName();

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name not entered");
        }

        LocalDate birthdate = userDTO.getBirthdate();

        if (birthdate.isAfter(LocalDate.now())
                || birthdate.isEqual(LocalDate.now())
                || birthdate.isBefore(LocalDate.now().minusYears(100))) {
            throw new IllegalArgumentException("Invalid date of birth");
        }


    }
}
