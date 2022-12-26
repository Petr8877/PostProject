package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.RegisteredUsersDAO;
import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.entity.RegisteredUsersEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class StatisticsServiceTest {

    @Test
    public void getActiveUsers(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        Assertions.assertEquals(0, service.getActiveUsers());
    }

    @Test
    public void addActiveUsers(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        service.addActiveUsers();
        int expected = 1;
        Assertions.assertEquals(expected, service.getActiveUsers());
    }

    @Test
    public void addActiveUsers2(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        Assertions.assertEquals(4, service.getActiveUsers());
    }

    @Test
    public void removeActiveUser(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        service.removeActiveUser();
        Assertions.assertEquals(2, service.getActiveUsers());
    }

    @Test
    public void getCountMessage(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        Assertions.assertEquals(0, service.getCountMessage());
    }

    @Test
    public void addCountMessage(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        service.addCountMessage();
        Assertions.assertEquals(1, service.getCountMessage());
    }

    @Test
    public void addCountMessage2(){
        StatisticsService service = new StatisticsService(new RegistrationService(new RegisteredUsersDAO()));
        service.addCountMessage();
        service.addCountMessage();
        service.addCountMessage();
        service.addCountMessage();
        Assertions.assertEquals(4, service.getCountMessage());
    }

    @Test
    public void getAllStatistics(){
        RegisteredUsersDAO dao = new RegisteredUsersDAO();

        RegisteredUsersEntity usersEntity = new RegisteredUsersEntity(
                new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10)));
        RegisteredUsersEntity usersEntity2 = new RegisteredUsersEntity(
                new UserDTO("Rolly","87654321", "Liz Petrova", LocalDate.of(1998,8, 1)));
        RegisteredUsersEntity usersEntity3 = new RegisteredUsersEntity(
                new UserDTO("Candy","01012345", "Sam Smirnov", LocalDate.of(1978, 1, 21)));

        dao.save(usersEntity);
        dao.save(usersEntity2);
        dao.save(usersEntity3);

        StatisticsService service = new StatisticsService(new RegistrationService(dao));

        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();

        service.addCountMessage();
        service.addCountMessage();
        service.addCountMessage();
        service.addCountMessage();

        StatisticsDTO expected = new StatisticsDTO(3, 4, 4);

        Assertions.assertEquals(expected, service.getAllStatistics());

    }
}
