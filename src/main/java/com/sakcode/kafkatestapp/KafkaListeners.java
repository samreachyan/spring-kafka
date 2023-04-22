package com.sakcode.kafkatestapp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "myTopic",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("LISTENER REC: " + data);
    }
}
