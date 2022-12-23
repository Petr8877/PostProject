package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.PostedMessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    void sendMessage(PostedMessageDTO messageDTO);
    Map<String, List<PostedMessageDTO>> getSendMessage();

    List<PostedMessageDTO> getUserSendMessage(String login);
}
