package by.itacademy.postproject.dao.api;


import by.itacademy.postproject.dto.MessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageDAO {
    void save(MessageDTO messageDTO);
    Map<String,List<MessageDTO>>  getSendMessage();

    List<MessageDTO> getUserSendMessage(String login);
}
