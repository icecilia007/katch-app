package com.katch.app.services.implementation;

import com.katch.app.models.Status;
import com.katch.app.models.User;
import com.katch.app.repository.UserRepository;
import com.katch.app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void save(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    @Override
    public void disconnect(User user) {
        User storedUser = userRepository.findById(user.getNickName()).orElse(null);
        if(storedUser!=null){
            storedUser.setStatus(Status.ONLINE);
            userRepository.save(storedUser);
        }
    }

    @Override
    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }

    @Override
    public Optional<User> findByNickName(String id) {
        return userRepository.findById(id);
    }
}
