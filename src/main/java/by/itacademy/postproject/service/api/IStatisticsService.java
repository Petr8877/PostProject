package by.itacademy.postproject.service.api;

import java.util.Set;

public interface IStatisticsService {

    int getActiveUsers();

    int getCountMessage();

    void setActiveUsers();

    void setCountMessage();
}
