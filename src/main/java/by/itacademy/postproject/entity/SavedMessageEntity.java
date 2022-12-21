package by.itacademy.postproject.entity;

import by.itacademy.postproject.dto.MessageDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SavedMessageEntity {
    private MessageDTO messageDTO;
    private LocalDateTime timeMessage;

    public SavedMessageEntity(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
        this.timeMessage = LocalDateTime.now();
    }

    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

    public LocalDateTime getTimeMessage() {
        return timeMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedMessageEntity that = (SavedMessageEntity) o;
        return Objects.equals(messageDTO, that.messageDTO) && Objects.equals(timeMessage, that.timeMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageDTO, timeMessage);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return  messageDTO +
                ", timeMessage = " + dtf.format(timeMessage);
    }
}
