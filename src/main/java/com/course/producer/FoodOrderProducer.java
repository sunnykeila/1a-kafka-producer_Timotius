package com.course.producer;

import com.course.entity.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class FoodOrderProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectMapper22 = new ObjectMapper();

    public void send22(FoodOrder foodOrder) throws JsonProcessingException {
        var json = objectMapper22.writeValueAsString(foodOrder);
        kafkaTemplate.send("t_food_order", json);

    }

}
