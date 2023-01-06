package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.entity.SavedMessageEntity;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageDAO dao;
    private IRegistrationService registrationService;

    public MessageService(IMessageDAO dao, IRegistrationService registrationService) {
        this.dao = dao;
        this.registrationService = registrationService;
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        validate(messageDTO);
        dao.save(new SavedMessageEntity(messageDTO));
    }

    @Override
    public Map<String, List<SavedMessageEntity>> getMessage() {
        return dao.getMessage();
    }

    @Override
    public List<SavedMessageEntity> getAllUserMessage(String login) {
        List<SavedMessageEntity> userSendMessage = dao.getAllUserMessage(login);
        if(userSendMessage == null) {
            throw new IllegalArgumentException("No message for this user");
        }
        return userSendMessage;
    }

    @Override
    public int getCountAllMessage() {
        return dao.getCountAllMessage();
    }

    private void validate(MessageDTO message) {
        String toWhom = message.getRecipient();

        if (toWhom == null || toWhom.isBlank()) {
            throw new IllegalArgumentException("Recipient not entered");
        }

        if(!registrationService.isExist(message.getRecipient())){
            throw new IllegalArgumentException("Such recipient is not registered");
        }

        String text = message.getText();

        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Message didn't fill");
        }

    }
}
