package by.itacademy.postproject.web;

import by.itacademy.postproject.dto.UserDTO;
import by.itacademy.postproject.service.api.IRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {
    private IRegistrationService registrationService;

    private final String LOGIN_PARAM_NAME = "login";
    private final String PASSWORD_PARAM_NAME = "password";
    private final String FULL_NAME_PARAM_NAME = "fullName";
    private final String BIRTHDATE_PARAM_NAME = "birthdate";

    public RegistrationServlet(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] logins = parameterMap.get(LOGIN_PARAM_NAME);
        String[] passwords = parameterMap.get(PASSWORD_PARAM_NAME);
        String[] fullNames = parameterMap.get(FULL_NAME_PARAM_NAME);
        String[] dates = parameterMap.get(BIRTHDATE_PARAM_NAME);

        String login = logins == null ? null : logins[0];
        String password = passwords == null ? null : passwords[0];
        String fullName = fullNames == null ? null : fullNames[0];
        String date = dates == null ? null : dates[0];

        try{
            if(logins == null) {
                throw new IllegalArgumentException("Логин не введен");
            }

            if(passwords == null) {
                throw new IllegalArgumentException("Пароль не введен");
            }

            if(fullNames == null) {
                throw new IllegalArgumentException("Полное имя не введено");
            }

            if(dates == null) {
                throw new IllegalArgumentException("Дата рождения не введена");
            }

            LocalDate birthdate = parseDate(date);

            registrationService.register(new UserDTO(login, password, fullName, birthdate));

            writer.write("<p>" + "Пользователь зарегистрирован" + "</p>");

        } catch (IllegalArgumentException exception) {
          writer.write("<p>" + exception.getMessage() + "</p>");
        } catch (DateTimeParseException exception) {
            writer.write("<p>" + "Неверный формат даты" + "</p>");
        }

    }

    public LocalDate parseDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Дата рождения не введена");
        }
        return LocalDate.parse(date);
    }
}
