package by.itacademy.postproject.dao.api;

import by.itacademy.postproject.entity.SavedMessageEntity;

import java.util.List;
import java.util.Map;

public interface IMessageDAO {

    void save(SavedMessageEntity messageEntity);

    Map<String, List<SavedMessageEntity>> getMessage();

    List<SavedMessageEntity> getAllUserMessage(String login);

    int getCountAllMessage();
}
