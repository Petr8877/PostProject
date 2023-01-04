package by.itacademy.postproject.service;

import by.itacademy.postproject.dto.PostedMessageDTO;
import by.itacademy.postproject.dto.StatisticDTO;
import by.itacademy.postproject.service.api.IMessageService;
import by.itacademy.postproject.service.api.IRegistrationService;
import by.itacademy.postproject.service.api.IStatisticService;



public class StatisticService implements IStatisticService {
    private IMessageService messageService;
    private IRegistrationService registrationService;
    private Integer countOfActiveUsers;

    public StatisticService(IMessageService messageService,
                            IRegistrationService registrationService) {
        this.messageService = messageService;
        this.registrationService = registrationService;
    }

    @Override
    public void addActiveUser(){
        if(countOfActiveUsers == null){
            countOfActiveUsers = 0;
        }
        countOfActiveUsers++;
    }


    @Override
    public StatisticDTO getStatistic() {
        return new StatisticDTO(getCountOfActiveUsers(),getCountOfUsers(),getCountOfMessages());
    }

    @Override
    public Integer getCountOfActiveUsers() {
        return countOfActiveUsers;
    }

    @Override
    public Integer getCountOfUsers() {
        return registrationService.getCountOfUsers();
    }

    @Override
    public Integer getCountOfMessages() {
        Integer countOfMessage = messageService.getCountOfMessage();
        return countOfMessage;
    }
}
