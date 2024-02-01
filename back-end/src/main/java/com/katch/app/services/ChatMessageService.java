package com.katch.app.services;

import com.katch.app.models.PrivateMessage;

import java.util.List;

public interface ChatMessageService {
    PrivateMessage save(PrivateMessage chatMessage);
    List<PrivateMessage> findChatMessages(String senderId, String recipientId);
}
