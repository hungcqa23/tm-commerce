package com.hungcqa23.notification.controller;

import com.hungcqa23.notification.dto.ApiResponse;
import com.hungcqa23.notification.dto.request.SendEmailRequest;
import com.hungcqa23.notification.dto.response.EmailResponse;
import com.hungcqa23.notification.service.EmailService;
import com.hungcqa23.notification.service.IdempotencyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailController {
    EmailService emailService;
    IdempotencyService idempotencyService;
    
    String extractMessageId(String message) {
        // Split the message into timestamp and accountId using the "-" delimiter
        String[] parts = message.split("-");
        
        String timestamp = parts[0];
        String accountId = parts[1];
        
        return timestamp + "-" + accountId;
    }
    
    @PostMapping("/email/send")
    ApiResponse<EmailResponse> sendEmail(@RequestBody SendEmailRequest request) {
        return ApiResponse.<EmailResponse>builder()
                .data(emailService.sendEmail(request))
                .build();
    }

    @KafkaListener(topics = "onboard-successful")
    public void listen(String message) {
        log.info("Message received: {}", message);
        
        // Extract the business key from the message (e.g., timestamp + accountId)
        String messageId = extractMessageId(message);
        
        // Check if the message was already processed
        if (idempotencyService.isMessageProcessed(messageId)) {
            log.info("Message with id {} has already been processed, skipping.", messageId);
            return; // Skip processing this message
        }
        
        // Mark the message as processed
        idempotencyService.markMessageAsProcessed(messageId);
    }
}
