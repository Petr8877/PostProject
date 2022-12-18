package by.itacademy.postproject.service.factory;

import by.itacademy.postproject.dao.factory.MessageDAOSingleton;
import by.itacademy.postproject.dao.factory.StatisticsDAOSingleton;
import by.itacademy.postproject.service.MessageService;
import by.itacademy.postproject.service.StatisticsService;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IStatisticsService;

public class StatisticsServiceSingleton {
    private volatile static StatisticsService instance;

    private StatisticsServiceSingleton() {
    }

    public static StatisticsService getInstance() {
        if (instance == null) {
            synchronized (StatisticsService.class) {
                if (instance == null) {
                    instance = new StatisticsService(StatisticsDAOSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
