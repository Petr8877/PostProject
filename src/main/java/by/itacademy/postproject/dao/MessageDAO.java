package by.itacademy.postproject.dao;

import by.itacademy.postproject.dao.api.IMessageDAO;
import by.itacademy.postproject.dto.PostedMessageDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDAO implements IMessageDAO {
    private Map<String,List<PostedMessageDTO>>  sendMessageDAO = new HashMap<>();


    @Override
    public void save(PostedMessageDTO messageDTO) {
        String recipient = messageDTO.getRecipient();
        List<PostedMessageDTO> list = sendMessageDAO.containsKey(recipient) ?
                sendMessageDAO.get(recipient) : new ArrayList<>();
        list.add(messageDTO);
        sendMessageDAO.put(recipient,list);
    }

    @Override
    public Map<String, List<PostedMessageDTO>> getSendMessage() {
        return sendMessageDAO;
    }

    @Override
    public List<PostedMessageDTO> getUserSendMessage(String login) {
//        if(isRecipientExist(login)){
//            throw new IllegalArgumentException("No messages");
//        }

        return sendMessageDAO.get(login);
    }

    @Override
    public Integer getCountOfMessage() {
        int count = 0;
        for ( String  val: sendMessageDAO.keySet()) {
            for (PostedMessageDTO message: sendMessageDAO.get(val) ) {
                count++;
            }
        }
        return count;
    }

    private boolean isRecipientExist(String login){
        return sendMessageDAO.containsKey(login);
    }


}
