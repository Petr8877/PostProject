package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IRegistrationService;
import by.itacademy.postproject.service.api.IStatisticsService;

import java.util.concurrent.atomic.AtomicInteger;


public class StatisticsService implements IStatisticsService {

    private final AtomicInteger countActiveUser;
    private final AtomicInteger countMessage;
    private final IRegistrationService registrationService;

    public StatisticsService(IRegistrationService registrationService) {
        this.countActiveUser = new AtomicInteger();
        this.countMessage = new AtomicInteger();
        this.registrationService = registrationService;
    }

    @Override
    public int getCountMessage() {
        return this.countMessage.intValue();
    }

    @Override
    public int getActiveUsers() {
        return this.countActiveUser.intValue();
    }

    @Override
    public void addActiveUsers() {
        countActiveUser.incrementAndGet();
    }

    @Override
    public void removeActiveUser() {
        countActiveUser.decrementAndGet();
    }

    @Override
    public void addCountMessage() {
        countMessage.incrementAndGet();
    }

    @Override
    public StatisticsDTO getAllStatistics() {
        int countActiveUser = this.getActiveUsers();
        int countAllUser = registrationService.getCountAllUser();
        int countAllMessage = this.getCountMessage();
        return new StatisticsDTO(countActiveUser, countAllUser, countAllMessage);
    }
}
