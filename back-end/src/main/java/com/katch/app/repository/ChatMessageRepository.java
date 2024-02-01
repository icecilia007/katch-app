package com.katch.app.repository;

import com.katch.app.models.PrivateMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<PrivateMessage, String> {
    List<PrivateMessage> findByChatId(String chatId);
}
