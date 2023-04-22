package com.sakcode.kafkatestapp.rest;

import com.sakcode.kafkatestapp.domain.NotifiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String publishMessage(@RequestBody NotifiEntity request) {
        if (request.getAmount() > 0) {
            for (int i = 0; i < request.getAmount(); i++) {
                kafkaTemplate.send("myTopic", request.getMessage() + " - " + i);
            }
        }
        return "Message is sent!";
    }

}
