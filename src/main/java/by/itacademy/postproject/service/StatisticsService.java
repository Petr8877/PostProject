package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IStatisticsService;


public class StatisticsService implements IStatisticsService {

    private final StatisticsDTO dto;

    public StatisticsService() {
        this.dto = new StatisticsDTO();
    }

    @Override
    public int getActiveUsers() {
        return dto.getActiveUsers();
    }

    @Override
    public int getCountMessage() {
        return dto.getCountMessage();
    }

    @Override
    public void setActiveUsers() {
        dto.setActiveUsers();
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
