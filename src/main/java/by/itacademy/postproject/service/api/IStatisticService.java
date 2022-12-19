package by.itacademy.postproject.service.api;

public interface IStatisticService {
    Integer getCountOfActiveUsers();
    Integer getCountOfUsers();
    Integer getCountOfMessages();
    void setCountOfActiveUsers();
}
