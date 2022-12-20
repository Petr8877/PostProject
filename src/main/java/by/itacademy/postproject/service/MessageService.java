package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.dto.RegisteredUsersDTO;
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
        dao.save(messageDTO);
        statisticsService.setCountMessage();
    }

    @Override
    public Map<String, List<MessageDTO>> getMessage() {
        return dao.getMessage();
    }

    @Override
    public List<MessageDTO> getAllUserMessage(String login) {
        return dao.getAllUserMessage(login);
    }
}
