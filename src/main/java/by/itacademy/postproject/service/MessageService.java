package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.entity.SavedMessageEntity;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IStatisticsService;
import by.itacademy.postproject.service.factory.StatisticsServiceSingleton;

import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageDAO dao;
    private final IStatisticsService statisticsService;

    public MessageService(IMessageDAO dao, IStatisticsService statisticsService) {
        this.dao = dao;
        this.statisticsService = StatisticsServiceSingleton.getInstance();
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        validate(messageDTO);
        dao.save(new SavedMessageEntity(messageDTO));
        statisticsService.setCountMessage();
    }

    @Override
    public Map<String, List<SavedMessageEntity>> getMessage() {
        return dao.getMessage();
    }

    @Override
    public List<SavedMessageEntity> getAllUserMessage(String login) {
        return dao.getAllUserMessage(login);
    }

    private void validate(MessageDTO message){
        String toWhom = message.getRecipient();

        if(toWhom == null || toWhom.isBlank()){
            throw new IllegalArgumentException("Recipient not entered");
        }

        String text = message.getText();

        if(text == null || text.isBlank()){
            throw new IllegalArgumentException("Message didn't fill");
        }

    }
}
