package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageDAO dao;

    public MessageService(IMessageDAO dao) {
        this.dao = dao;
    }

    @Override
    public void sendMessage(String sender, String recipient, String text) {
        StatisticsService service = StatisticsServiceSingleton.getInstance();
        dao.save(new MessageDTO(sender, recipient, text));
        service.setCountMessage();
    }

    @Override
    public Map<String, List<MessageDTO>> getMessage() {
        return dao.getMessage();
    }
}
