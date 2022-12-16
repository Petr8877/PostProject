package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, List<MessageDTO>> copyUsersMessages1 = usersMessages;
        return copyUsersMessages1;
    }
}
