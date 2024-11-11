package com.hungcqa23.notification.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdempotencyService {
    RedisTemplate<String, String> redisTemplate;
    static final String IDEMPOTENCY_KEY_PREFIX = "processed_message:";
    
    public boolean isMessageProcessed(String messageId) {
        return Optional.ofNullable(redisTemplate)
                .map(template -> template.hasKey(IDEMPOTENCY_KEY_PREFIX + messageId))
                .orElse(false);  // Return false if redisTemplate is null
    }
    
    // Mark message as processed
    public void markMessageAsProcessed(String messageId) {
        System.out.println("Set key successfully!");
        redisTemplate.opsForValue().set(IDEMPOTENCY_KEY_PREFIX + messageId, "processed", 1, TimeUnit.HOURS);
    }
}
