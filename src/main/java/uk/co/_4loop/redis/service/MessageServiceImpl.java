package uk.co._4loop.redis.service;

import org.springframework.stereotype.Service;
import uk.co._4loop.redis.queue.MessagePublisher;
import uk.co._4loop.redis.queue.RedisMessageSubscriber;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    final MessagePublisher messagePublisher;

    public MessageServiceImpl(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void sendMessage(String message) {
        messagePublisher.publish(message);
    }

    @Override
    public List<String> getMessages() {
        return RedisMessageSubscriber.messageList.stream().toList();
    }


}
