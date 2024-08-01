package com.jm.anota_ai_desafio.services.aws;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    private String message;
    private String subject;
    private String messageType;
    public MessageDTO(@NotNull String ownerId) {
    }

    public MessageDTO(String message, String subject, String messageType) {
        this.message = message;
        this.subject = subject;
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
