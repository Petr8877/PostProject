package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;
import by.itacademy.postproject.dto.RegisteredUsersDTO;

import java.util.*;

public class MessageDAO implements IMessageDAO {

    private final Map<String, List<MessageDTO>> usersMessages = new HashMap<>();


    @Override
    public void save(MessageDTO messageDTO) {
        List<MessageDTO> list;
        if (usersMessages.containsKey(messageDTO.getSender())) {
            list = usersMessages.get(messageDTO.getSender());
        } else {
            list = new ArrayList<>();
        }
        list.add(messageDTO);
        usersMessages.put(messageDTO.getSender(), list);
    }

    @Override
    public Map<String, List<MessageDTO>> getMessage() {
        return usersMessages;
    }

    @Override
    public List<MessageDTO> getAllUserMessage(String login) {
        return this.usersMessages.get(login);
    }
}
