package uk.co._4loop.redis.service;


import java.util.List;

public interface MessageService {

    void sendMessage(final String message);

    List<String> getMessages();

}
