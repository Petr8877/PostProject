package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.service.api.IRegistrationService;
import by.itacademy.postproject.service.factory.RegistrationServiceSingleton;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    private final IRegistrationService service = RegistrationServiceSingleton.getInstance();

    @Test
    public void registerLogin1() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("", "123456789", "John John", LocalDate.of(1990, 11, 11))), "Login not entered");
    }

    @Test
    public void registerLogin2() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("Ипотлит", "123456789", "John John", LocalDate.of(1990, 11, 11))), "Wrong format of login");
    }

    @Test
    public void registerLogin3() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("12345", "123456789", "John John", LocalDate.of(1990, 11, 11))), "login can not be less then 6 symbols");
    }

    @Test
    public void registerLogin4() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("1234567890098765432112345678901", "123456789", "John John", LocalDate.of(1990, 11, 11))), "login cannot be longer then 30 symbols");
    }

    @Test
    public void registerPassword1() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "", "John John", LocalDate.of(1990, 11, 11))), "Password not entered");
    }

    @Test
    public void registerPassword2() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "1234567", "John John", LocalDate.of(1990, 11, 11))), "Password can not be less then 8 symbols");
    }

    @Test
    public void registerFullName1() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "12345678", "", LocalDate.of(1990, 11, 11))), "Full name not entered");
    }

    @Test
    public void registerFullName2() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "12345678", "qw qw", LocalDate.of(1990, 11, 11))), "full name cannot be less then 4 symbols");
    }

    @Test
    public void registerFullName3() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "12345678", "Шадрин Илья", LocalDate.of(1990, 11, 11))), "write correct full name");
    }

    @Test
    public void registerBirthdate1() {
        assertThrows(IllegalArgumentException.class, () -> service.register(new UserDTO("123456", "12345678", "John John", LocalDate.of(1000, 11, 11))), "Invalid date of birth");
    }
}