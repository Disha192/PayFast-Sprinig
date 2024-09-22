package com.gl.payfast_springboot.Service;

import com.gl.payfast_springboot.Entity.Transaction;
import com.gl.payfast_springboot.Repository.TransactionRepository;
import com.gl.payfast_springboot.Service.KafkaService.AuditLogging;
import com.gl.payfast_springboot.Service.KafkaService.StatusandTimeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    StatusandTimeUpdate statusandTimeUpdate;
    @Autowired
    AuditLogging auditLogging;

    public String createtransaction(Transaction transaction) {
        System.out.println("transaction="+transaction);
        transactionRepository.save(transaction);
        new Thread(() -> {
            statusandTimeUpdate.startStatusChange();
            try {
                Thread.sleep(3000); // Simulate processing time
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            statusandTimeUpdate.stopScheduler();
        }).start();
        auditLogging.sendAuditLog(transaction);
        return "Transaction done successfully";

    }
}
