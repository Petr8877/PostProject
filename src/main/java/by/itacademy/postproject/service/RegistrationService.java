package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;
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
    public void register(UserDTO user) {
        validate(user);
        this.dao.save(new RegisteredUsersEntity(user));
    }

    @Override
    public boolean isExist(String login) {
        return this.dao.isExist(login);
    }

    @Override
    public RegisteredUsersEntity getUser(String login) {
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
        if(!login.matches("\\b([a-zA-Z\\d]+\\.?[a-zA-Z\\d]+)+")){
            throw new IllegalArgumentException("Wrong format of login");
        }
        if( login.length()<6 ) {
            throw new IllegalArgumentException("login can not be less then 6 symbols");
        }
        if( login.length()>30 ) {
            throw new IllegalArgumentException("login cannot be longer then 30 symbols");
        }

        String password = userDTO.getPassword();

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password not entered");
        }
        if (password.length()<8){
            throw new IllegalArgumentException("Password can not be less then 8 symbols");
        }

        String fullName = userDTO.getFullName();

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name not entered");
        }
        if (userDTO.getFullName().length()<=4){
            throw  new IllegalArgumentException("full name cannot be less then 4 symbols");
        }
        if(!userDTO.getFullName().matches("(([A-Z])\\w+) (([A-Z])\\w+)")){
            throw  new IllegalArgumentException("write correct full name");
        }

        LocalDate birthdate = userDTO.getBirthdate();

        if (birthdate.isAfter(LocalDate.now())
                || birthdate.isEqual(LocalDate.now())
                || birthdate.isBefore(LocalDate.now().minusYears(100))) {
            throw new IllegalArgumentException("Invalid date of birth");
        }


    }
}
