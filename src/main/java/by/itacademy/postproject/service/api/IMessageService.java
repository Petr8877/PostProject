package by.itacademy.postproject.service.api;

import by.itacademy.postproject.dto.MessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    void sendMessage(String sender, String recipient, String text);

    Map<String, List<MessageDTO>> getMessage();
}
