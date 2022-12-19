package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.service.api.IMessageService;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {
    IMessageDAO messageDAO;
    public MessageService(IMessageDAO messageDAO) {
        this.messageDAO = messageDAO;

    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        messageDAO.save(messageDTO);

    }

    @Override
    public Map<String, List<MessageDTO>> getSendMessage() {
        return messageDAO.getSendMessage();
    }

    @Override
    public List<MessageDTO> getUserSendMessage( String login) {
        return messageDAO.getUserSendMessage(login);
    }
}
