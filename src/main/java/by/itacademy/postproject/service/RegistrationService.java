package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;
import by.itacademy.postproject.entity.ClientType;
import by.itacademy.postproject.entity.RegisteredUsersEntity;
import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.service.api.IRegistrationService;

import java.time.LocalDate;

public class RegistrationService implements IRegistrationService {
    private final IRegisteredUsersDAO dao;

    public RegistrationService(IRegisteredUsersDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean register(UserDTO user) {
        if (validate(user)) {
            this.dao.save(new RegisteredUsersEntity(user));
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(String login) {
        return this.dao.isExist(login);
    }

    @Override
    public RegisteredUsersEntity getUser(String login) {
        return this.dao.getUser(login);
    }

    private boolean validate(UserDTO userDTO) {
        String login = userDTO.getLogin();

        if (login == null || login.isBlank()) {
            return false;
//            throw new IllegalArgumentException("Login not entered");
        }
        if (dao.isExist(login)) {
            return false;
            //throw new IllegalArgumentException("User with this login is already registered");
        }
        if (!login.matches("\\b([a-zA-Z\\d]+\\.?[a-zA-Z\\d]+)+")) {
            return false;
            //throw new IllegalArgumentException("Wrong format of login");
        }
        if (login.length() < 6) {
            return false;
            //throw new IllegalArgumentException("login can not be less then 6 symbols");
        }
        if (login.length() > 30) {
            return false;
            //throw new IllegalArgumentException("login cannot be longer then 30 symbols");
        }

        String password = userDTO.getPassword();

        if (password == null || password.isBlank()) {
            return false;
            //throw new IllegalArgumentException("Password not entered");
        }
        if (password.length() < 8) {
            return false;
            //throw new IllegalArgumentException("Password can not be less then 8 symbols");
        }

        String fullName = userDTO.getFullName();

        if (fullName == null || fullName.isBlank()) {
            return false;
            //throw new IllegalArgumentException("Full name not entered");
        }
        if (userDTO.getFullName().length() <= 4) {
            return false;
            //throw new IllegalArgumentException("full name cannot be less then 4 symbols");
        }
        if (!userDTO.getFullName().matches("(([A-Z])\\w+) (([A-Z])\\w+)")) {
            return false;
            //throw new IllegalArgumentException("write correct full name");
        }

        LocalDate birthdate = userDTO.getBirthdate();

        if (birthdate.isAfter(LocalDate.now())
                || birthdate.isEqual(LocalDate.now())
                || birthdate.isBefore(LocalDate.now().minusYears(100))) {
            return false;
            //throw new IllegalArgumentException("Invalid date of birth");
        }

        return true;
    }

    @Override
    public ClientType getClientType(String login) {
        return this.dao.getClientType(login);
    }

    @Override
    public int getCountAllUser() {
        return dao.getCountAllUser();
    }
}
