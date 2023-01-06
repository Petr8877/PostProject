package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.StatisticsDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;
import by.itacademy.postproject.service.api.IStatisticsService;

import java.util.concurrent.atomic.AtomicInteger;


public class StatisticsService implements IStatisticsService {

    private final AtomicInteger countActiveUser;
    private final IRegistrationService registrationService;
    private final IMessageService messageService;

    public StatisticsService(IRegistrationService registrationService, IMessageService messageService) {
        this.countActiveUser = new AtomicInteger();
        this.registrationService = registrationService;
        this.messageService = messageService;
    }

    @Override
    public int getCountMessage() {
        return messageService.getCountAllMessage();
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
    public int getCountAllUser() {
        return registrationService.getCountAllUser();
    }
    @Override
    public StatisticsDTO getAllStatistics() {
        return new StatisticsDTO(getActiveUsers(), getCountAllUser(),getCountMessage());
    }
}
