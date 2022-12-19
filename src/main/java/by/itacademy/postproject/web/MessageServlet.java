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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        List<MessageDTO> user = service.getUserSendMessage(ActionSession.getParameterValue(req, "user"));
        user.forEach(s-> writer.write("<p>"+s.getText()+"</p>"));
        writer.write("<p> All messages </p>");
        service.getSendMessage().forEach((key, value) -> writer.write("<p>" + key + "</p>"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] recipients = parameterMap.get(PARAM_NAME_RECIPIENT);
        String[] texts = parameterMap.get(PARAM_NAME_TEXT);

        String recipient = (recipients == null) ? null : recipients[0];
        String text = (texts == null) ? null : texts[0];

//        PostMessageDTO postMessageDTO = new PostMessageDTO(recipient, text);
        try {
            MessageDTO messageDTO = new MessageDTO(ActionSession.getParameterValue(req, "user"), recipient, text);
            service.sendMessage(messageDTO);
//
            writer.write("<p> Message send </p>");
        } catch (Exception e){
            writer.write("<p>"+e.getMessage()+"</p>");
        }


    }
}
