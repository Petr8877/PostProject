package by.itacademy.postproject.dto;

import java.util.Objects;

public class MessageDTO {

    private final String sender;
    private final String recipient;
    private final String text;

    public MessageDTO(String sender, String recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDTO that = (MessageDTO) o;
        return Objects.equals(sender, that.sender) && Objects.equals(recipient, that.recipient) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, recipient, text);
    }

    @Override
    public String toString() {
        return "sender = " + sender +
                ", recipient = " + recipient +
                ", text = " + text;
    }
}
