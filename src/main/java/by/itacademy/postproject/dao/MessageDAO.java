package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.MessageDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDAO implements IMessageDAO {
    private Map<String,List<MessageDTO>>  sendMessageDAO = new HashMap<>();


    @Override
    public void save(MessageDTO messageDTO) {
        String sender = messageDTO.getSender();
        List<MessageDTO> list = sendMessageDAO.containsKey(sender) ?
                sendMessageDAO.get(sender) : new ArrayList<>();
        list.add(messageDTO);
        sendMessageDAO.put(sender,list);
    }

    @Override
    public Map<String, List<MessageDTO>> getSendMessage() {
        return sendMessageDAO;
    }

    @Override
    public List<MessageDTO> getUserSendMessage(String login) {
        return sendMessageDAO.get(login);
    }


}
