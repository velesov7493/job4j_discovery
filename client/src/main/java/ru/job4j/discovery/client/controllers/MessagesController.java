package ru.job4j.discovery.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.discovery.client.models.Message;
import ru.job4j.discovery.client.services.rules.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Value("${spring.application.name}")
    private String appName;

    private final MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getReceivedMessages();
    }

    @PostMapping("/send/{serviceId}")
    public void send(
            @PathVariable String serviceId,
            @RequestBody Message message) {
        message.setSender(appName);
        boolean sent = messageService.send(serviceId, message);
        if (!sent) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Неправильный идентификатор сервиса!"
            );
        }
    }

    @PostMapping("/receive")
    public void receive(@RequestBody Message message) {
        messageService.saveReceivedMessage(message);
    }
}
