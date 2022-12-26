package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.StatisticDTO;

public interface IStatisticService {
    StatisticDTO getStatistic();
    Integer getCountOfActiveUsers();
    Integer getCountOfUsers();
    Integer getCountOfMessages();
    void addActiveUser();
}
