package com.katch.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class PrivateMessage extends ChatMessage{
    @Id
    private String id;
    private String chatId;
    private String recipientId;
    private Date timestamp;
}
