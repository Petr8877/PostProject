package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.PostedMessageDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {
    private IMessageDAO messageDAO;
    private IRegistrationService registrationService;

    public MessageService(IMessageDAO messageDAO, IRegistrationService registrationService) {
        this.messageDAO = messageDAO;
        this.registrationService = registrationService;

    }

    @Override
    public void sendMessage(PostedMessageDTO messageDTO) {
        if (registrationService.isExist(messageDTO.getRecipient())) {
            messageDAO.save(messageDTO);
        } else throw new IllegalArgumentException("such recipient is not registered");

    }

    @Override
    public Map<String, List<PostedMessageDTO>> getSendMessage() {
        return messageDAO.getSendMessage();
    }

    @Override
    public List<PostedMessageDTO> getUserSendMessage(String login) {
        List<PostedMessageDTO> userSendMessage;

            userSendMessage = messageDAO.getUserSendMessage(login);

        return userSendMessage;
    }

    @Override
    public Integer getCountOfMessage() {
        return messageDAO.getCountOfMessage();
    }
}
