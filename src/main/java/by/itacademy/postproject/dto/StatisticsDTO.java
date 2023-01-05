package by.itacademy.postproject.dto;

import java.util.Objects;

public class StatisticsDTO {
    private int countActiveUser;
    private int countAllUser;
    private int countMessage;

    public StatisticsDTO(int countActiveUser, int countAllUser, int countMessage) {
        this.countActiveUser = countActiveUser;
        this.countAllUser = countAllUser;
        this.countMessage = countMessage;
    }

    public int getCountActiveUser() {
        return countActiveUser;
    }

    public int getCountAllUser() {
        return countAllUser;
    }

    public int getCountMessage() {
        return countMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDTO that = (StatisticsDTO) o;
        return countActiveUser == that.countActiveUser
                && countAllUser == that.countAllUser
                && countMessage == that.countMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countActiveUser, countAllUser, countMessage);
    }

    @Override
    public String toString() {
        return "countActiveUser=" + countActiveUser +
                ", countAllUser=" + countAllUser +
                ", countMessage=" + countMessage;
    }
}
