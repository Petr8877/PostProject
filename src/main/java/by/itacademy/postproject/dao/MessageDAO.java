package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.entity.SavedMessageEntity;

import java.util.*;

public class MessageDAO implements IMessageDAO {

    private final Map<String, List<SavedMessageEntity>> usersMessages = new HashMap<>();

    @Override
    public void save(SavedMessageEntity messageEntity) {
        List<SavedMessageEntity> list;
        String loginSender = messageEntity.getMessageDTO().getSender();
        if (usersMessages.containsKey(loginSender)){
            list = usersMessages.get(loginSender);
        } else {
            list = new ArrayList<>();
        }
        list.add(messageEntity);
        usersMessages.put(loginSender, list);
    }

    @Override
    public Map<String, List<SavedMessageEntity>> getMessage() {
        return usersMessages;
    }

    @Override
    public List<SavedMessageEntity> getAllUserMessage(String login) {
        return this.usersMessages.get(login);
    }
}
