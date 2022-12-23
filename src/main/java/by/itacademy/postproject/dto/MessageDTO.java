package by.itacademy.postproject.dto;

public class MessageDTO {
    private final String recipient;
    private final String text;

    public MessageDTO(String recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}
