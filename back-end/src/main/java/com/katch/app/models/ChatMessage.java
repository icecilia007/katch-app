package com.katch.app.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class ChatMessage {
    private String senderId;
    private String content;
}
