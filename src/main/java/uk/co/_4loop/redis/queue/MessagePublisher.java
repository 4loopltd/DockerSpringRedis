package uk.co._4loop.redis.queue;

public interface MessagePublisher {
    void publish(final String message);
}
