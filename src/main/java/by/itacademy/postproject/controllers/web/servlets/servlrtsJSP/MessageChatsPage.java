package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

import by.itacademy.postproject.controllers.web.servlets.ActionSession;
import by.itacademy.postproject.entity.SavedMessageEntity;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.factory.MessageServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MessageChatsPage", urlPatterns = "/ui/user/chats")
public class MessageChatsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IMessageService service = MessageServiceSingleton.getInstance();
        List<SavedMessageEntity>messageList = null;

        try {
            messageList = service.getAllUserMessage(ActionSession.getParameterValue(req, "user").getLogin());
        } catch (IllegalArgumentException e) {
            req.setAttribute("exception", e.getMessage());
        }

        req.setAttribute("chats", messageList);

        req.getRequestDispatcher("/views/MessageChats.jsp").forward(req, resp);

    }
}
