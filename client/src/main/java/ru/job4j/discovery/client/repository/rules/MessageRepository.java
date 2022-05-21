package ru.job4j.discovery.client.repository.rules;

import org.springframework.stereotype.Repository;
import ru.job4j.discovery.client.models.Message;

import java.util.List;

@Repository
public interface MessageRepository {

    Message save(Message message);

    List<Message> findAll();
}
