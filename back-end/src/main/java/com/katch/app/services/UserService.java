package com.katch.app.services;

import com.katch.app.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
     void save(User user);
     void disconnect(User user);

     List<User> findConnectedUsers();

     Optional<User> findByNickName(String id);
}
