package com.gl.payfast_springboot.Service.KafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BasicConsumerService {
    private String getLastconsumeMessage = "";
    @KafkaListener(topics = "AuditLog", groupId = "group_id")
    public void consumeMessage(String message) {
        this.getLastconsumeMessage = message;
    }

    public String getLastconsumeMessage() {
        return getLastconsumeMessage;
    }
}
