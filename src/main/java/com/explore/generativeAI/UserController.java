package com.explore.generativeAI;


import org.springframework.ai.chat.client.ChatClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gemma")
public class UserController {

    private final UserService gemmaChatService;

    public UserController(UserService gemmaChatService) {
        this.gemmaChatService = gemmaChatService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        return gemmaChatService.sendMessage(message);
    }
}
