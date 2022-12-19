package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.StatisticsDTO;

import java.util.Set;

public interface IStatisticsService {

    int getActiveUsers();

    int getCountMessage();

    void setActiveUsers();

    void setCountMessage();

    //на рассмотрение
    StatisticsDTO getAllStatistics();
}
