package by.itacademy.postproject.service;

import by.itacademy.postproject.dao.StatisticsDAO;
import by.itacademy.postproject.dao.api.IStatisticsDAO;
import by.itacademy.postproject.service.api.IStatisticsService;

import java.util.Set;

public class StatisticsService implements IStatisticsService {

    private final IStatisticsDAO dao;

    public StatisticsService(IStatisticsDAO dao) {
        this.dao = dao;
    }

    @Override
    public int getActiveUsers() {
        return dao.getActiveUsers();
    }

    @Override
    public int getCountMessage() {
        return dao.getCountMessage();
    }

    @Override
    public void setActiveUsers(){
        dao.setActiveUsers();
    }
}
