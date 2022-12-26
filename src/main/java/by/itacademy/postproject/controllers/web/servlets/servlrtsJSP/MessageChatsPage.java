package by.itacademy.postproject.controllers.web.servlets.servlrtsJSP;

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
import java.util.Map;

@WebServlet(name = "MessageChatsPage", urlPatterns = "/ui/user/chats")
public class MessageChatsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IMessageService service = MessageServiceSingleton.getInstance();
//        Map<String, List<SavedMessageEntity>> message = service.getMessage();
//        String str = (String) req.getSession().getAttribute("user");
//        List<SavedMessageEntity> list = message.get(str);
//        req.setAttribute("list", list);
//        req.getRequestDispatcher("/views/MessageChats.jsp").forward(req, resp);
        req.getRequestDispatcher("/api/message").forward(req,resp);
    }
}
