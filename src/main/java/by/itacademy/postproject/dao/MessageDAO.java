package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.entity.SavedMessageEntity;

import java.util.*;

public class MessageDAO implements IMessageDAO {

    private final Map<String, List<SavedMessageEntity>> usersMessages = new HashMap<>();

    @Override
    public void save(SavedMessageEntity messageEntity) {
        String recipient = messageEntity.getMessageDTO().getRecipient();
        List<SavedMessageEntity> list = usersMessages.containsKey(recipient) ?
                usersMessages.get(recipient) : new ArrayList<>();
        list.add(messageEntity);
        usersMessages.put(recipient,list);
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
