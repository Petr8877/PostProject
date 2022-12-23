package by.itacademy.postproject.dto;

public class StatisticDTO {
    private Integer activeUsers;
    private Integer countOfAllUsers;
    private Integer countOfMessages;

    public StatisticDTO(Integer activeUsers, Integer countOfAllUsers, Integer countOfMessages) {
        this.activeUsers = activeUsers;
        this.countOfAllUsers = countOfAllUsers;
        this.countOfMessages = countOfMessages;
    }

    public Integer getActiveUsers() {
        return activeUsers;
    }

    public Integer getCountOfAllUsers() {
        return countOfAllUsers;
    }

    public Integer getCountOfMessages() {
        return countOfMessages;
    }
}
