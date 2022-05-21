package ru.job4j.discovery.client.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.discovery.client.models.Message;
import ru.job4j.discovery.client.repository.rules.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemMessageRepository implements MessageRepository {

    private AtomicInteger generator = new AtomicInteger(0);
    private Map<Integer, Message> messages = new ConcurrentHashMap<>();

    @Override
    public Message save(Message message) {
        message.setId(generator.incrementAndGet());
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(messages.values());
    }
}
