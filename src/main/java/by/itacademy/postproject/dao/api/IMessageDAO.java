package by.itacademy.postproject.dao.api;


import by.itacademy.postproject.dto.PostedMessageDTO;

import java.util.List;
import java.util.Map;

public interface IMessageDAO {
    void save(PostedMessageDTO messageDTO);
    Map<String,List<PostedMessageDTO>>  getSendMessage();

    List<PostedMessageDTO> getUserSendMessage(String login);
}
