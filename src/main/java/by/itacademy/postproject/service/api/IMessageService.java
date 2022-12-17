package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.MessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    void sendMessage(MessageDTO messageDTO);
    Map<String, List<MessageDTO>> getSendMessage();

    List<MessageDTO> getUserSendMessage(String login);
}
