package by.itacademy.postproject.dao.factory;

import by.itacademy.postproject.dao.StatisticsDAO;
import by.itacademy.postproject.dto.StatisticsDTO;

public class StatisticsDAOSingleton {
    private volatile static StatisticsDAO instance;

    private StatisticsDAOSingleton() {
    }

    public static StatisticsDAO getInstance() {
        if (instance == null) {
            synchronized (StatisticsDAOSingleton.class) {
                if (instance == null) {
                    instance = new StatisticsDAO(new StatisticsDTO());
                }
            }
        }
        return instance;
    }
}
