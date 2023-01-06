package by.itacademy.postproject.controllers.web.servlets;

import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.entity.SavedMessageEntity;
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

        String[] recipients = parameterMap.get(PARAM_NAME_RECIPIENT);
        String recipient = (recipients == null) ? null : recipients[0];

        String[] texts = parameterMap.get(PARAM_NAME_TEXT);
        String text = (texts == null) ? null : texts[0];

        PrintWriter writer = resp.getWriter();

        try {
            if (recipients == null) {
                throw new IllegalArgumentException("Message recipient not entered");
            }
            if (texts == null) {
                throw new IllegalArgumentException("No message to send to recipient");
            }
            MessageDTO messageDTO = new MessageDTO(ActionSession.getParameterValue(req, "user").getLogin(), recipient, text);
            service.sendMessage(messageDTO);
            req.setAttribute("success_message", "message send");
            req.getRequestDispatcher("/views/Mail.jsp").forward(req, resp);

        } catch (IllegalArgumentException exception) {
            req.setAttribute("error_message", exception.getMessage());
            req.getRequestDispatcher("/views/Mail.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        try{
            List<SavedMessageEntity> messageList = service.getAllUserMessage(ActionSession.getParameterValue(req, "user").getLogin());
            messageList.forEach(s -> writer.write("<p>" + s+ "</p>"));
        } catch (IllegalArgumentException e) {
            writer.write("<p>" + e.getMessage() + "</p>");
        }
    }
}
