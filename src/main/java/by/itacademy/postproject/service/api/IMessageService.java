package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.entity.SavedMessageEntity;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    void sendMessage(MessageDTO messageDTO);

    Map<String, List<SavedMessageEntity>> getMessage();

    List<SavedMessageEntity> getAllUserMessage(String login);
}
