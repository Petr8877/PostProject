package by.itacademy.postproject.dto;

import java.util.Objects;

public class StatisticsDTO {

    private int activeUsers;

    private int countMessage;

    public int getActiveUsers() {
        return this.activeUsers;
    }

    public void setActiveUsers() {
        this.activeUsers++;
    }

    public int getCountMessage() {
        return countMessage;
    }

    public void setCountMessage() {
        this.countMessage++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDTO that = (StatisticsDTO) o;
        return countMessage == that.countMessage && Objects.equals(activeUsers, that.activeUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeUsers, countMessage);
    }

    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "activeUsers=" + activeUsers +
                ", countMessage=" + countMessage +
                '}';
    }
}
