package com.katch.app.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public abstract class ChatMessage {
    private String senderId;
    private String content;
    private MessageType type;
}
