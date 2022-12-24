package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IStatisticsService;

import java.util.Set;


public class StatisticsService implements IStatisticsService {

    private final StatisticsDTO dto;

    public StatisticsService() {
        this.dto = new StatisticsDTO();
    }

    @Override
    public Set<String> getActiveUsers() {
        return dto.getActiveUsers();
    }

    @Override
    public int getCountMessage() {
        return dto.getCountMessage();
    }

    @Override
    public void addActiveUsers(String login) {
        dto.addActiveUsers(login);
    }

    @Override
    public void removeActiveUser(String login) {
        dto.removeActiveUser(login);
    }

    @Override
    public void setCountMessage() {
        dto.setCountMessage();
    }

    @Override
    public StatisticsDTO getAllStatistics() {
        return dto;
    }
}
