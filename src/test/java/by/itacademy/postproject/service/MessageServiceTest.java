package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.MessageDAO;
import by.itacademy.postproject.dao.RegisteredUsersDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class MessageServiceTest {

    @Test
    public void sendMessage(){
        MessageDAO dao = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(new RegisteredUsersDAO());

        IMessageService messageService = new MessageService(dao, registrationService);

        MessageDTO messageDTO = new MessageDTO("Lululu", "Lololo", "It's test");

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.sendMessage(messageDTO));

        Assertions.assertEquals("Such recipient is not registered", throwable.getMessage());

    }

    @Test
    public void sendMessage2(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);

        IMessageService messageService = new MessageService(daoMes, registrationService);

        MessageDTO messageDTO = new MessageDTO("Lululu", null, "It's test");

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.sendMessage(messageDTO));

        Assertions.assertEquals("Recipient not entered", throwable.getMessage());
    }

    @Test
    public void sendMessage3(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);

        IMessageService messageService = new MessageService(daoMes, registrationService);

        MessageDTO messageDTO = new MessageDTO("Lululu", "", "It's test");

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.sendMessage(messageDTO));

        Assertions.assertEquals("Recipient not entered", throwable.getMessage());
    }

    @Test
    public void sendMessage4(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO user = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));

        registrationService.register(user);

        MessageDTO messageDTO = new MessageDTO("Lululu", "Annyyy", "");

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.sendMessage(messageDTO));

        Assertions.assertEquals("Message didn't fill", throwable.getMessage());
    }

    @Test
    public void sendMessage5(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO user = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));

        registrationService.register(user);

        MessageDTO messageDTO = new MessageDTO("Lululu", "Annyyy", null);

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.sendMessage(messageDTO));

        Assertions.assertEquals("Message didn't fill", throwable.getMessage());

    }

    @Test
    public void sendMessage6(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO user = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));
        registrationService.register(user);

        MessageDTO messageDTO = new MessageDTO("Lululu", "Annyyy", "It's test");

        Assertions.assertDoesNotThrow(() -> messageService.sendMessage(messageDTO));
    }

    @Test
    public void getAllUserMessage(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
                () -> messageService.getAllUserMessage("kiki"));

        Assertions.assertEquals("No message for this user", throwable.getMessage());
    }

    @Test
    public void getAllUserMessage2(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO toWhom = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));

        registrationService.register(toWhom);

        MessageDTO messageDTO = new MessageDTO("Rolly", "Annyyy", "It's test");
        messageService.sendMessage(messageDTO);

        Assertions.assertDoesNotThrow(() -> messageService.getAllUserMessage(toWhom.getLogin()));
    }

    @Test
    public void getCountAllMessage(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO toWhom = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));

        registrationService.register(toWhom);

        MessageDTO messageDTO = new MessageDTO("Rolly", "Annyyy", "It's test");
        messageService.sendMessage(messageDTO);

        Assertions.assertEquals(1, messageService.getCountAllMessage());
    }

    @Test
    public void getCountAllMessage2(){
        RegisteredUsersDAO daoReg = new RegisteredUsersDAO();
        MessageDAO daoMes = new MessageDAO();
        IRegistrationService registrationService = new RegistrationService(daoReg);
        IMessageService messageService = new MessageService(daoMes, registrationService);

        UserDTO toWhom = new UserDTO("Annyyy","12345678", "Ann Ivanova", LocalDate.of(2000, 10, 10));
        UserDTO toWhom2 = new UserDTO("Rollly","87654321", "Olya Smirnova", LocalDate.of(1999, 01, 11));

        registrationService.register(toWhom);
        registrationService.register(toWhom2);

        MessageDTO messageDTO = new MessageDTO("Rollly", "Annyyy", "It's test");
        MessageDTO messageDTO2 = new MessageDTO("Annyyy", "Rollly", "It's test");

        messageService.sendMessage(messageDTO);
        messageService.sendMessage(messageDTO2);

        Assertions.assertEquals(2, messageService.getCountAllMessage());
    }

}
