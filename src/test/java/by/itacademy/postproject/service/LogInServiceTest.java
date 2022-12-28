package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.LogInDTO;
import by.itacademy.postproject.entity.ClientType;
import by.itacademy.postproject.service.factory.RegistrationServiceSingleton;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LogInServiceTest {


    @Test
    public void getClientType() {
        assertEquals(RegistrationServiceSingleton.getInstance().getClientType("Administrator"), ClientType.ADMINISTRATOR);
    }

    @Test
    public void signInExceptionNoUser() {
        LogInDTO log = new LogInDTO("lololo", "123456789");
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        assertThrowsExactly(IllegalArgumentException.class, () -> logInService.signIn(log));
    }

    @Test
    public void signInNoException() {
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        LogInDTO log = new LogInDTO("Administrator", "12345678");
        boolean result = false;
        try {
            logInService.signIn(log);
        } catch (IllegalArgumentException e) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    public void signInExceptionWrongPassword() {
        LogInDTO log = new LogInDTO("Administrator", "1234567");
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        assertThrowsExactly(IllegalArgumentException.class, () -> logInService.signIn(log));
    }

    @Test
    public void signInExceptionInvalidLogin() {
        LogInDTO log = new LogInDTO("Administrato", "12345678");
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        assertThrowsExactly(IllegalArgumentException.class, () -> logInService.signIn(log));
    }

    @Test
    public void signInExceptionPasswordNotEntered() {
        LogInDTO log = new LogInDTO("Administrator", "");
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        assertThrowsExactly(IllegalArgumentException.class, () -> logInService.signIn(log));
    }

    @Test
    public void signInExceptionLoginNotEntered() {
        LogInDTO log = new LogInDTO("", "12345678");
        LogInService logInService = new LogInService(RegistrationServiceSingleton.getInstance());
        assertThrowsExactly(IllegalArgumentException.class, () -> logInService.signIn(log));
    }
}