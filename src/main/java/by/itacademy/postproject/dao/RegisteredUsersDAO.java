package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;

import by.itacademy.postproject.dto.ClientType;
import by.itacademy.postproject.dto.RegisteredUsersDTO;
import by.itacademy.postproject.dto.UserDTO;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.Map;

public class RegisteredUsersDAO implements IRegisteredUsersDAO {

    private Map<String, RegisteredUsersDTO> registeredUsers = new HashMap<>();

    {
        UserDTO admin = new UserDTO("Administrator", "12345678",
                "Иванов И.И", LocalDate.of(1990, 12,12));
        RegisteredUsersDTO adminReg = new RegisteredUsersDTO(admin, LocalDate.of(2022,12,12));
        adminReg.setUserRole();
        this.registeredUsers.put(adminReg.getUser().getLogin(), adminReg);
    }

    @Override
    public void save(RegisteredUsersDTO registeredUsersDTO) {
        this.registeredUsers.put(registeredUsersDTO.getUser().getLogin(), registeredUsersDTO);
    }

    @Override
    public boolean isExist(String login) {
        return this.registeredUsers.containsKey(login);
    }

    @Override
    public RegisteredUsersDTO getUser(String login) {
        return this.registeredUsers.get(login);

    }

    @Override
    public int getCountOfUser() {
        return registeredUsers.entrySet().size();
    }

    @Override
    public ClientType getClientType(String login) {
        return registeredUsers.get(login).getUserRole();
    }

}
