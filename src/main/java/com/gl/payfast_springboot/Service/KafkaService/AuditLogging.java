package com.gl.payfast_springboot.Service.KafkaService;

import com.gl.payfast_springboot.Entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditLogging {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAuditLog(Transaction transaction) {
        String auditMessage = "AuditLog: " + transaction.getAccountId() + " " + transaction.getTransactionRecipient() + " " + transaction.getTransactionAmount() + " " + transaction.getTransactionDate();
        kafkaTemplate.send("AuditLog", auditMessage);
    }
}
