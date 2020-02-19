 package com.example.Configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate; 
import org.springframework.stereotype.Service;
 
 

@Service
public class PersonProducer {

	  private static final Logger logger = LoggerFactory.getLogger(PersonProducer.class);
	    private static final String TOPIC = "users";

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void sendMessage(String message) {

	        this.kafkaTemplate.send(TOPIC, message);
	        logger.info(String.format("#### -> Producing message -> %s", message));
	    }

}
