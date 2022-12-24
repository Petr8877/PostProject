package by.itacademy.postproject.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StatisticsDTO {
    private final Set<String> activeUsers=new HashSet<>();
    private int countMessage;

    public void addActiveUsers(String login) {
        this.activeUsers.add(login);
    }

    public void removeActiveUser(String login) {
        this.activeUsers.remove(login);
    }

    public Set<String> getActiveUsers() {
        return activeUsers;
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
        return "Number of active users in the application: " + activeUsers.size() + "\n" +
                "Number of sent messages in the application: " + countMessage;
    }
}
