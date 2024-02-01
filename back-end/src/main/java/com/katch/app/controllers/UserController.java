package com.katch.app.controllers;

import com.katch.app.models.User;
import com.katch.app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @MessageMapping(".addUser")
    @SendTo("/topic")
    public User addUser(@Payload User user){
        userService.save(user);
        return user;
    }

    @MessageMapping(".disconnectUser")
    @SendTo("/topic")
    public User disconnectUser(@Payload User user){
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findConnectedUsers(){
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
    @GetMapping("/{nickname}")
    public ResponseEntity<Optional<User>> findUserByNickName(@PathVariable String nickname){
        return ResponseEntity.ok(userService.findByNickName(nickname));
    }
}
