package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.entity.SavedMessageEntity;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;
import by.itacademy.postproject.service.api.IStatisticsService;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageDAO dao;
    private final IStatisticsService statisticsService;
    private IRegistrationService registrationService;

    public MessageService(IMessageDAO dao, IStatisticsService statisticsService, IRegistrationService registrationService) {
        this.dao = dao;
        this.statisticsService = statisticsService;
        this.registrationService = registrationService;
    }

    @Override
    public boolean sendMessage(MessageDTO messageDTO) {
        if (validate(messageDTO)) {
            dao.save(new SavedMessageEntity(messageDTO));
            statisticsService.addCountMessage();
            return true;
        }
        return false;
    }

    @Override
    public Map<String, List<SavedMessageEntity>> getMessage() {
        return dao.getMessage();
    }

    @Override
    public List<SavedMessageEntity> getAllUserMessage(String login) {
        List<SavedMessageEntity> userSendMessage = dao.getAllUserMessage(login);
        ;
//        if(userSendMessage == null) {
//            throw new IllegalArgumentException("No message for this user");
//        }
        return userSendMessage;
    }

    private boolean validate(MessageDTO message) {
        String toWhom = message.getRecipient();

        if (toWhom == null || toWhom.isBlank()) {
            return false;
//            throw new IllegalArgumentException("Recipient not entered");
        }

        if (!registrationService.isExist(message.getRecipient())) {
            return false;
            //throw new IllegalArgumentException("Such recipient is not registered");
        }

        String text = message.getText();

        if (text == null || text.isBlank()) {
            return false;
            //throw new IllegalArgumentException("Message didn't fill");
        }
        return true;
    }
}
