package by.itacademy.postproject.web.servlets.ui_servlets;


import by.itacademy.postproject.dto.PostedMessageDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.factory.MessageServiceSingleton;
import by.itacademy.postproject.web.servlets.ActionSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserChatServlet", urlPatterns = "/ui/user/chats")
public class UserChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IMessageService service = MessageServiceSingleton.getInstance();
        List<PostedMessageDTO> user = service.getUserSendMessage(ActionSession.getParameterValue(req, "user").getLogin());
        req.setAttribute("chats",user);
        req.getRequestDispatcher("/pages/user_messages.jsp").forward(req,resp);
    }

}
