package by.itacademy.postproject.web;

import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.factory.MessageServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final String PARAM_NAME_RECIPIENT = "recipient";
    private final String PARAM_NAME_TEXT = "text";

    private final IMessageService service;

    public MessageServlet() {
        this.service = MessageServiceSingleton.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] logins = parameterMap.get(PARAM_NAME_RECIPIENT);
        String recipient = (logins == null) ? null : logins[0];

        String[] passwords = parameterMap.get(PARAM_NAME_TEXT);
        String text = (passwords == null) ? null : passwords[0];
        PrintWriter writer = resp.getWriter();

        service.sendMessage(ActionSession.getParameterValue(req, "login"), recipient, text);

        writer.write("<p> Message sent </p>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MessageDTO> messageDTOList = service.getMessage().get(ActionSession.getParameterValue(req, "login"));
        PrintWriter writer = resp.getWriter();

        for (MessageDTO messageDTO : messageDTOList) {
            writer.write("<p>" + messageDTO + "</p>");
        }
    }
}
