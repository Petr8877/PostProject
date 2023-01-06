package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.MessageDAO;
import by.itacademy.postproject.dao.RegisteredUsersDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticsServiceTest {
    @Test
    public void getActiveUsers(){
        RegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());
        StatisticsService service = new StatisticsService(registrationService,
                new MessageService(new MessageDAO(), registrationService));
        Assertions.assertEquals(0, service.getActiveUsers());
   }

    @Test
    public void addActiveUsers(){
        RegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());
        StatisticsService service = new StatisticsService(registrationService,
                new MessageService(new MessageDAO(), registrationService));
        service.addActiveUsers();
        int expected = 1;
        Assertions.assertEquals(expected, service.getActiveUsers());
    }

    @Test
    public void addActiveUsers2(){
        RegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());
        StatisticsService service = new StatisticsService(registrationService,
                new MessageService(new MessageDAO(), registrationService));
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        Assertions.assertEquals(4, service.getActiveUsers());
    }

    @Test
    public void removeActiveUser(){
        RegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());
        StatisticsService service = new StatisticsService(registrationService,
                new MessageService(new MessageDAO(), registrationService));
        service.addActiveUsers();
        service.addActiveUsers();
        service.addActiveUsers();
        service.removeActiveUser();
        Assertions.assertEquals(2, service.getActiveUsers());
    }

    @Test
    public void getCountMessage(){
        RegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());
        StatisticsService service = new StatisticsService(registrationService,
                new MessageService(new MessageDAO(), registrationService));
        Assertions.assertEquals(0, service.getCountMessage());
    }

}
