package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.StatisticsDTO;

import java.util.Set;

public interface IStatisticsService {

    Set<String> getActiveUsers();

    int getCountMessage();

    void addActiveUsers(String login);

    void setCountMessage();

    //на рассмотрение
    StatisticsDTO getAllStatistics();
}
