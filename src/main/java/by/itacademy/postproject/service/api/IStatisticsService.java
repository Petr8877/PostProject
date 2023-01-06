package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.StatisticsDTO;

public interface IStatisticsService {

    int getCountMessage();

    int getActiveUsers();

    void addActiveUsers();

    void removeActiveUser();

    int getCountAllUser();

    StatisticsDTO getAllStatistics();
}
