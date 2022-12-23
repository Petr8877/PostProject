package by.itacademy.postproject.dto;

import java.time.LocalDateTime;

public class PostedMessageDTO {

    private final LocalDateTime timeMessage;
    private MessageDTO messageDTO;
    private final String sender;

    public PostedMessageDTO(String sender, MessageDTO messageDTO) {
        this.timeMessage = LocalDateTime.now();
        this.sender = sender;
        this.messageDTO = messageDTO;

    }

    public LocalDateTime getTimeMessage() {
        return timeMessage;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return messageDTO.getRecipient();
    }

    public String getText() {
        return messageDTO.getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostedMessageDTO that = (PostedMessageDTO) o;

        if (timeMessage != null ? !timeMessage.equals(that.timeMessage) : that.timeMessage != null) return false;
        if (messageDTO != null ? !messageDTO.equals(that.messageDTO) : that.messageDTO != null) return false;
        return sender != null ? sender.equals(that.sender) : that.sender == null;
    }

    @Override
    public int hashCode() {
        int result = timeMessage != null ? timeMessage.hashCode() : 0;
        result = 31 * result + (messageDTO != null ? messageDTO.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        return result;
    }
}
