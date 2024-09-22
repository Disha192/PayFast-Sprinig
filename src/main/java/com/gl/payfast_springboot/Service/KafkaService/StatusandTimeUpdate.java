package com.gl.payfast_springboot.Service.KafkaService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class StatusandTimeUpdate {

    @Getter
    private String status;

    private final String[] statuses = { "in progress", "in transit", "completed"};
    private int currentIndex = 0;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "PaymentStatus";

    private ScheduledExecutorService scheduler;

    public void startStatusChange() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::updateStatus, 0, 1, TimeUnit.SECONDS);
    }

    private void updateStatus() {
        currentIndex = (currentIndex + 1) % statuses.length;
        status = statuses[currentIndex];
        String message = "Status: " + status + ", Time: " + new Date();

        kafkaTemplate.send(topic, status, message);
    }

    public void stopScheduler() {
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }

    public Date getDate() {
        return new Date();
    }
}
