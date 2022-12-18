package by.itacademy.postproject.service.factory;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.StatisticsService;

public class StatisticsServiceSingleton {
    private volatile static StatisticsService instance;

    private StatisticsServiceSingleton() {
    }

    public static StatisticsService getInstance() {
        if (instance == null) {
            synchronized (StatisticsService.class) {
                if (instance == null) {
                    instance = new StatisticsService(new StatisticsDTO());
                }
            }
        }
        return instance;
    }
}
