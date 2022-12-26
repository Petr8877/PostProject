package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.StatisticsDTO;

public interface IStatisticsService {

   // Set<UserSessionDTO> getActiveUsers();

    int getCountMessage();

    int getActiveUsers();

    void addActiveUsers();

    void removeActiveUser();

    void addCountMessage();

    //на рассмотрение
    StatisticsDTO getAllStatistics();
}
