package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IRegisteredUsersDAO;
import by.itacademy.postproject.entity.RegisteredUsersEntity;
import by.itacademy.postproject.dto.UserDTO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RegisteredUsersDAO implements IRegisteredUsersDAO {

    private Map<String, RegisteredUsersEntity> registeredUsers = new HashMap<>();

    {
        UserDTO admin = new UserDTO("Administrator", "12345678",
                "Иванов И.И", LocalDate.of(1990, 12, 12));
        RegisteredUsersEntity adminReg = new RegisteredUsersEntity(admin, LocalDate.of(2022, 12, 12));
//   изменила строку 20
        adminReg.setAdmin();
        this.registeredUsers.put(adminReg.getUser().getLogin(), adminReg);
    }

    @Override
    public void save(RegisteredUsersEntity registeredUsersEntity) {
        this.registeredUsers.put(registeredUsersEntity.getUser().getLogin(), registeredUsersEntity);
    }

    @Override
    public boolean isExist(String login) {
        return this.registeredUsers.containsKey(login);
    }

    @Override
    public RegisteredUsersEntity getUser(String login) {
        return this.registeredUsers.get(login);
    }


}
