package uk.co._4loop.redis.controller;

import org.springframework.web.bind.annotation.*;
import uk.co._4loop.redis.service.MessageService;

import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {

    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("get")
    public List<String> getMessages() {
        return messageService.getMessages();
    }

    @PostMapping("send")
    public void sendMessage(@RequestBody String message) {
        messageService.sendMessage(message);
    }
}
