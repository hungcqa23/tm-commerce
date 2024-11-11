package com.tm.auth.services;

import com.tm.auth.entities.OutboxEvent;
import com.tm.auth.repositories.OutboxEventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OutboxPublisherService {
    OutboxEventRepository outboxEventRepository;
    KafkaTemplate<String, String> kafkaTemplate;
    
    @Scheduled(fixedRate = 10000)
    public void publishPendingEvents() {
        System.out.println("Publishing pending events... every 10 seconds");
        List<OutboxEvent> pendingEvents = outboxEventRepository.findByStatus("PENDING");
        
        for (OutboxEvent pendingEvent : pendingEvents) {
            try {
                // Publish the event to Kafka
                System.out.println("Publishing event: " + pendingEvent.getEventType());
                System.out.println("Payload: " + pendingEvent.getPayload());
                System.out.println("Message ID: " + pendingEvent.getMessageId());
                kafkaTemplate.send(pendingEvent.getEventType(), pendingEvent.getMessageId(), pendingEvent.getPayload());
                // Mark the event as processed
                pendingEvent.setStatus("PROCESSED");
                outboxEventRepository.save(pendingEvent);
            } catch (Exception e) {
                // Handle any exceptions that occur while publishing the event
                System.out.println("Error publishing event: " + e.getMessage());
            }
        }
    }
}
