package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.dto.RegisteredUsersDTO;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    void sendMessage(MessageDTO messageDTO);

    Map<String, List<MessageDTO>> getMessage();

    List<MessageDTO>getAllUserMessage(String login);
}
