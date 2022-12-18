package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IStatisticsDAO;
import by.itacademy.postproject.dto.StatisticsDTO;

import java.util.Objects;

public class StatisticsDAO implements IStatisticsDAO {

    private final StatisticsDTO statisticsDTO;

    public StatisticsDAO(StatisticsDTO statisticsDTO) {
        this.statisticsDTO = statisticsDTO;
    }

    public int getActiveUsers() {
        return statisticsDTO.getActiveUsers();
    }

    public void setActiveUsers() {
       statisticsDTO.setActiveUsers();
    }

    public int getCountMessage() {
        return statisticsDTO.getCountMessage();
    }

    public void setCountMessage() {
        statisticsDTO.setCountMessage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDAO that = (StatisticsDAO) o;
        return Objects.equals(statisticsDTO, that.statisticsDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticsDTO);
    }

    @Override
    public String toString() {
        return "StatisticsDAO{" +
                "statisticsDTO=" + statisticsDTO +
                '}';
    }
}
